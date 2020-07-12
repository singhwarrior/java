package com.karma.thread.signal.custom;

public class ThreadB implements Runnable{

	private MySignal sharedMySignal = new MySignal();
	
	public ThreadB(MySignal mySignal) {
		sharedMySignal = mySignal;
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
		while(!sharedMySignal.isProcessingDone());
	}
	
	private void doProcess(){
		System.out.println("Thread B finished it's work");			
	}

}
