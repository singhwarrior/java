package com.karma.avro;

import org.apache.avro.Schema;
import org.apache.avro.file.DataFileReader;
import org.apache.avro.generic.GenericDatumReader;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.io.DatumReader;
import org.apache.avro.io.Decoder;
import org.apache.avro.io.DecoderFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class AvroDeserializationOld {

    public static void main(String[] args) throws IOException {

        Schema schema = new Schema.Parser().parse(new File("./old/User.avsc"));
        File file = new File("./data/users.avro");


//        DatumReader<GenericRecord> datumReader = new GenericDatumReader<>(schema);
//        DataFileReader<GenericRecord> dataFileReader = new DataFileReader<GenericRecord>(file, datumReader);

        byte[] object = Files.readAllBytes(Paths.get("./data/users.avro"));

        DatumReader<GenericRecord> reader = new GenericDatumReader<GenericRecord>(schema, schema);
        Decoder decoder = DecoderFactory.get().binaryDecoder(object, null);
        System.out.println(reader.read(null, decoder));

//        GenericRecord user = null;
//        while (dataFileReader.hasNext()) {
//// Reuse user object by passing it to next(). This saves us from
//// allocating and garbage collecting many objects for files with
//// many items.
//            user = dataFileReader.next(user);
//            System.out.println(user);
//        }
    }
}
