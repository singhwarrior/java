package com.karma.launch;

public class MyThread implements Runnable{

	private int size_of_increament = 1;
	private ImmutableCounter counter;
	
	public MyThread(ImmutableCounter counter, int size_of_increament) {
		this.counter = counter;
		this.size_of_increament = size_of_increament;
	}

	@Override
	public void run() {
		increamentCounter();
	}
	
	private void increamentCounter(){
		for(int i=0; i<size_of_increament; i++){
			counter = counter.increament();		
		}
		System.out.println(Thread.currentThread().getName()+":"+counter.getValue());
	}

}
