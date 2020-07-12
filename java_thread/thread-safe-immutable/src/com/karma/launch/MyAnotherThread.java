package com.karma.launch;

public class MyAnotherThread implements Runnable {

	private int size_of_increament = 1;
	private Calculator calculator;

	public MyAnotherThread(Calculator calculator, int size_of_increament) {
		this.calculator = calculator;
		this.size_of_increament = size_of_increament;
	}

	@Override
	public void run() {
		increamentCounter();
	}

	private void increamentCounter() {
		synchronized (calculator) {
			for (int i = 0; i < size_of_increament; i++) {
				calculator.increament();
			}
			System.out.println(Thread.currentThread().getName() + ":" + calculator.getCounter().getValue());			
		}
	}

}
