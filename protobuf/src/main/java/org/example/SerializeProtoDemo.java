package org.example;

import org.demo.protobuf.Department;
import org.demo.protobuf.Employee;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class SerializeProtoDemo {
    public static void main(String[] args) {

        Employee emp1 = Employee.newBuilder()
                .setName("Gaurav Singh")
                .setId(1001)
                .setEmail("gaurav@xyz.com")
                .addPhones(Employee.PhoneNumber.newBuilder()
                        .setType(Employee.PhoneType.MOBILE)
                        .setNumber("9999999999").build())
                .build();

        Employee emp2 = Employee.newBuilder()
                .setName("Saurabh Singh")
                .setId(1002)
                .setEmail("saurabh@xyz.com")
                .addPhones(Employee.PhoneNumber.newBuilder()
                        .setType(Employee.PhoneType.MOBILE)
                        .setNumber("9999999998").build())
                .build();

        Department department = Department.newBuilder()
                .addEmployees(emp1)
                .addEmployees(emp2)
                .build();

        System.out.println(department.toString());

        try{
            department.writeTo(new FileOutputStream("/Users/g0s051y/gitws/java/protobuf/department/department1"));
        }catch(FileNotFoundException e){

        }catch (IOException e){

        }
    }
}
