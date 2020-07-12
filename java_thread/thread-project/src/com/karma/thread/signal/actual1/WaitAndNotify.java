package com.karma.thread.signal.actual1;

import com.karma.thread.signal.actual.common.MonitorObject;

/**
 * This class is proper implementation of of Signaling.
 * This class shows implementation of Wait and Notify Algorithm
 * 
 * @author singg
 *
 */
public class WaitAndNotify {
	
	private MonitorObject monitorObject = new MonitorObject();
	private boolean isSignalled = false;
	
	public void doWait(){
		synchronized(monitorObject){
			if(!isSignalled)
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
