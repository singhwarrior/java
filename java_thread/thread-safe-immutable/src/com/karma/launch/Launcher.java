package com.karma.launch;

public class Launcher {
	public static void main(String[] args) {
		ImmutableCounter immutableCounter = new ImmutableCounter(0);
		Thread t1 = new Thread(new MyThread(immutableCounter,1000), "Thread-1");
		Thread t2 = new Thread(new MyThread(immutableCounter,9), "Thread-2");
		t1.start();
		t2.start();
	}
}
