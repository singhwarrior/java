package com.karma.thread.signal.actual;

import com.karma.thread.signal.custom.PoolSignal;

public class ThreadA implements Runnable {
	
	private WaitAndNotify waitAndNotify;
	private PoolSignal poolSignal;
	private int i = 0;
	
	public ThreadA(WaitAndNotify waitAndNotify, PoolSignal poolSignal, int i) {
		this.waitAndNotify = waitAndNotify;
		this.poolSignal = poolSignal;
		this.i = i;
	}
	
	@Override
	public void run() {
		process();
	}
	
	synchronized public void process(){
		for(int i=0; i<10; i++)
			System.out.println(Thread.currentThread().getName()+i);
		System.out.println(Thread.currentThread().getName()+" finished it's work");
		this.poolSignal.getMySignals()[i].setProcessingDone(true);
		if(this.poolSignal.isAllThreadsCompleted())
			waitAndNotify.doNotify();
	}

}
