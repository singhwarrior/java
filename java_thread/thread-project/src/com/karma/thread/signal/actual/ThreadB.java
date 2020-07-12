package com.karma.thread.signal.actual;

public class ThreadB implements Runnable{

	private WaitAndNotify waitAndNotify;
	
	public ThreadB(WaitAndNotify waitAndNotify) {
		this.waitAndNotify = waitAndNotify;
	}
	
	@Override
	public void run() {
		waitAndProcess();
	}
	
	synchronized private void waitAndProcess(){
		busyWait();
		doProcess();
	}
	
	private void busyWait(){
		waitAndNotify.doWait();
	}
	
	private void doProcess(){
		System.out.println("Thread B finished it's work");			
	}

}
