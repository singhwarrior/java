package com.karma.thread.signal.custom;

public class PoolSignal {
	private MySignal[] mySignals = null;

	synchronized public MySignal[] getMySignals() {
		return mySignals;
	}

	public void setMySignals(MySignal[] mySignals) {
		this.mySignals = mySignals;
	}
	
	synchronized public boolean isAllThreadsCompleted(){
		boolean poolDone = true;
		for(MySignal signal : mySignals){
			poolDone = poolDone&&signal.isProcessingDone();  
		}
		return poolDone;
	}
	
}
