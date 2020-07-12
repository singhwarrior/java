package com.karma.thread.signal.custom;

public class ThreadA implements Runnable {
	
	private MySignal sharedMySignal = new MySignal();
	private PoolSignal poolSignal;
	private int i = 0;
	
	public ThreadA(MySignal mySignal, PoolSignal poolSignal, int i) {
		sharedMySignal = mySignal;
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
			sharedMySignal.setProcessingDone(true);
	}

}
