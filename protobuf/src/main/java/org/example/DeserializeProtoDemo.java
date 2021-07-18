package org.example;

import org.demo.protobuf.Department;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class DeserializeProtoDemo {
    public static void main(String[] args) {
        InputStream is = null;
        try{
            Department department1 = Department.parseFrom(new FileInputStream("/Users/g0s051y/gitws/java/protobuf/department/department1"));
            System.out.println(department1.toString());
        }catch(FileNotFoundException e){

        }catch (IOException e){

        }
    }
}
