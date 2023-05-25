package com.karma.secret.consumer.app;

public class Launcher {
    public static void main(String[] args) {
        String mongoUserName = System.getenv("MONGO_USER_NAME");
        System.out.println(mongoUserName);
        //Other Task of the Job
    }
}
