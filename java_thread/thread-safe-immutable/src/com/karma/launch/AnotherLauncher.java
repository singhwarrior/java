package com.karma.launch;

public class AnotherLauncher {
	public static void main(String[] args) {
		ImmutableCounter immutableCounter = new ImmutableCounter(0);
		Calculator calculator = new Calculator();
		calculator.setCounter(immutableCounter);
		Thread t1 = new Thread(new MyAnotherThread(calculator,10000), "Thread-1");
		Thread t2 = new Thread(new MyAnotherThread(calculator,99), "Thread-2");
		t1.start();
		t2.start();
//		t1.start();
	}
}
