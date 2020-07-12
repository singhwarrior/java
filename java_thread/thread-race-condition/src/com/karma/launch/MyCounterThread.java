package com.karma.launch;


/**
 * Race Condition and Critical Section.
 * 
 * @author singg
 *
 */
public class MyCounterThread implements Runnable{

	private Counter counter;
	private int value;
	public MyCounterThread(Counter counter, int value) {
		this.counter = counter;
		this.value = value;
	}
	@Override
	public void run() {
		synchronized(counter){
			counter.increament(value);			
		}
	}
	

}
