package com.karma.thread.signal.actual2;

import com.karma.thread.signal.actual.common.MonitorObject;

public class WaitAndNotify {
	
	private MonitorObject monitorObject = new MonitorObject();
	private boolean isSignalled = false;
	
	public void doWait(){
		synchronized(monitorObject){
			while(!isSignalled)
				try {
					monitorObject.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			isSignalled=false;
		}
	}
	
	public void doNotify(){
		synchronized (monitorObject) {
			isSignalled = true;
			monitorObject.notify();
		}
	}
}
