package com.karma.avro;

import org.apache.avro.Schema;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericDatumWriter;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.io.BinaryEncoder;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.io.EncoderFactory;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class AvroSerializationEncoder {

    public static void main(String[] args) throws IOException {


        Schema schema = new Schema.Parser().parse(new File("./old/User.avsc"));


        GenericRecord user1 = new GenericData.Record(schema);
        user1.put("name", "Alyssa");
        user1.put("favorite_number", 256);
// Leave favorite color null

        GenericRecord user2 = new GenericData.Record(schema);
        user2.put("name", "Ben");
        user2.put("favorite_number", 7);
        user2.put("favorite_color", "red");

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        BinaryEncoder encoder = EncoderFactory.get().binaryEncoder(baos, null);

        DatumWriter<GenericRecord> datumWriter = new GenericDatumWriter<>(schema);

        datumWriter.write(user1, encoder);
        datumWriter.write(user2, encoder);

        encoder.flush();

        FileOutputStream fos = new FileOutputStream(new File("./data/users_byte_array.avro"));
        baos.writeTo(fos);

        baos.flush();
        baos.close();
    }
}
