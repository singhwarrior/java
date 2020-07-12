package com.karma.thread.signal.actual2;

public class ThreadB implements Runnable{

	private WaitAndNotify waitAndNotify;
	
	public ThreadB(WaitAndNotify waitAndNotify){
		this.waitAndNotify = waitAndNotify;
	}
	
	@Override
	public void run() {
		waitAndNotify.doWait();
		System.out.println(Thread.currentThread().getName()+" processed");
	}
	
}
