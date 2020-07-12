package com.karma.thread.signal.actual2;

public class ThreadA implements Runnable{

	private WaitAndNotify waitAndNotify;
	
	public ThreadA(WaitAndNotify waitAndNotify){
		this.waitAndNotify = waitAndNotify;
	}
	
	@Override
	public void run() {
		for(int i=0; i<10;i++)
			System.out.println(Thread.currentThread().getName()+" "+i);
		System.out.println(Thread.currentThread().getName()+" processed");
		synchronized (waitAndNotify) {
			waitAndNotify.doNotify();			
		}
	}

}
