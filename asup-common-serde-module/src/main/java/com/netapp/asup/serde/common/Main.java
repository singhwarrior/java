package com.netapp.asup.serde.common;

import com.netapp.asup.serde.common.proto.AggregateOuterClass.Aggregate;
import com.netapp.asup.serde.common.proto.AggregateOuterClass.Counter;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

public class Main {

    public static void main(String[] args) {
        System.out.println( "Hello World!" );
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("linger.ms", 1);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
//        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "io.confluent.kafka.serializers.protobuf.KafkaProtobufSerializer");
        props.put("schema.registry.url", "http://127.0.0.1:8084");


        Producer producer = new KafkaProducer(props);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(new File("./prehn/20220531/0000/2022053100000028/pcs/aggregate.json")));
            String prev = null;
            String curr;

            while((curr = reader.readLine()) != null){
                if(prev != null){
                    Aggregate aggregate = getAggregate(prev, curr);
//                    System.out.println(aggregate.getObjectName());
                    System.out.println(aggregate.toByteString());
                    ProducerRecord record = new ProducerRecord("test_topic", aggregate);
                    producer.send(record);
                }

//                System.out.println(curr);

//                ProducerRecord record = new ProducerRecord("aggr_op_topic", curr);
//                producer.send(record);

                prev = curr;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        } finally {
            if(reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            producer.close();
        }
    }

    public static Aggregate getAggregate(String prev, String curr) throws ParseException {

        Aggregate.Builder aggregateBuilder = Aggregate.newBuilder();

        JSONParser currJsonParser = new JSONParser();

        JSONObject currJsonObject = (JSONObject) currJsonParser.parse(curr);
        JSONObject prevJsonObject = (JSONObject) currJsonParser.parse(prev);

        String objectName = (String) currJsonObject.get("object_name");

        JSONArray currTimeStamps = ((JSONArray) currJsonObject.get("timestamps"));
        long currTs = (long)((JSONObject) currTimeStamps.get(0)).get("timestamp");

        JSONArray prevTimeStamps = ((JSONArray) prevJsonObject.get("timestamps"));
        long prevTs = (long)((JSONObject) prevTimeStamps.get(0)).get("timestamp");

        JSONObject currInstances = (JSONObject)((JSONArray)((JSONObject) currTimeStamps.get(0)).get("instances")).get(0);
        String instanceName = (String) currInstances.get("instance_keys");

        JSONObject prevInstances = (JSONObject)((JSONArray)((JSONObject) prevTimeStamps.get(0)).get("instances")).get(0);

        Iterator it = ((JSONArray) currInstances.get("counters")).iterator();
        it.next();

        Map<String, Long[]> counters = new HashMap<>();

        while(it.hasNext()){
            JSONObject counterJson = (JSONObject) it.next();
            String counterName = (String) counterJson.get("counter_name");
            long value = Long.parseLong((String)counterJson.get("value"));

            Long[] values = new Long[2];
            values[0] = value;
            values[1] = 0L;

            counters.put(counterName, values);

//            Counter counter = Counter.newBuilder().setCounterName(counterName)
//                    .setCurrentValue(value).build();
//            aggregateBuilder.addCounters(counter);
        }

        Iterator prevInstancesCountersIterator = ((JSONArray) prevInstances.get("counters")).iterator();
        prevInstancesCountersIterator.next();
        while(prevInstancesCountersIterator.hasNext()){
            JSONObject counterJson = (JSONObject) prevInstancesCountersIterator.next();
            String counterName = (String) counterJson.get("counter_name");

            long value = Long.parseLong((String)counterJson.get("value"));
            if(counters.containsKey(counterName)){
                counters.get(counterName)[1] = value;
            }else{
                Long[] values = new Long[2];
                values[0] = 0L;
                values[1] = value;

                counters.put(counterName, values);
            }

        }

        for(String key : counters.keySet()){
            aggregateBuilder.addCounters(
                    Counter.newBuilder()
                    .setCounterName(key)
                    .setCurrentValue(counters.get(key)[0])
                    .setPrevValue(counters.get(key)[1]).build());
        }


        return aggregateBuilder
                .setObjectName(objectName)
                .setInstanceName(instanceName)
                .setCurrentTimestamp(currTs)
                .setPrevTimestamp(prevTs).build();

    }


}
