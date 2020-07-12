package com.karma.launch;

public class MyThread implements Runnable{

	private int size_of_increament = 1;
	
	public MyThread(int size_of_increament) {
		this.size_of_increament = size_of_increament;
	}
	
	@Override
	public void run() {
		increamentCounter();
	}
	
	private void increamentCounter(){
		Counter counter = new Counter();
		for(int i=0; i<size_of_increament; i++){
			counter.increament();			
		}
		System.out.println(Thread.currentThread().getName()+":"+counter.getValue());
	}

}
