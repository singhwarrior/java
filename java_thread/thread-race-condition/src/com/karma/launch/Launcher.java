package com.karma.launch;

public class Launcher {

	public static void main(String[] args) {
		Counter counter = new Counter();
		Thread t1 = new Thread(new MyCounterThread(counter, 2));
		Thread t2 = new Thread(new MyCounterThread(counter, 3));
		t2.start();
		t1.start();
		
	}

}
