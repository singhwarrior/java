package com.karma.launch;

public class Launcher {
	public static void main(String[] args) {
		Thread t1 = new Thread(new MyThread(3), "Thread-1");
		Thread t2 = new Thread(new MyThread(5), "Thread-2");
		t1.start();
		t2.start();
	}
}
