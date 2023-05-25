package com.karma.avro;

import org.apache.avro.Schema;
import org.apache.avro.file.SeekableByteArrayInput;
import org.apache.avro.generic.GenericDatumReader;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.io.BinaryDecoder;
import org.apache.avro.io.DatumReader;
import org.apache.avro.io.DecoderFactory;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class AvroDesrializationDecoder {

    public static void main(String[] args) throws IOException {

        byte[] data = Files.readAllBytes(Paths.get("./data/users_byte_array.avro"));
        Schema schema = new Schema.Parser().parse(new File("./old/User.avsc"));
        DatumReader<GenericRecord> reader = new GenericDatumReader<>(schema, schema);

        SeekableByteArrayInput seekableByteArrayInput = new SeekableByteArrayInput(data);
        BinaryDecoder decoder = DecoderFactory.get().binaryDecoder(seekableByteArrayInput, null);

        while(!decoder.isEnd()){

            GenericRecord record = reader.read(null, decoder);
            System.out.println(record);
        }

        seekableByteArrayInput.close();

    }
}
