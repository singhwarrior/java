package com.karma.thread.signal.actual;

import com.karma.thread.signal.actual.common.MonitorObject;

/**
 * Basic wait and notify
 * @author singg
 *
 */
public class WaitAndNotify {
	
	private MonitorObject monitorObject = new MonitorObject();
	
	public void doWait(){
		synchronized (monitorObject) {
			try {
				monitorObject.wait();
			} catch (Exception e) {
				e.printStackTrace();
			}			
		}
	}
	
	public void doNotify(){
		synchronized (monitorObject) {
			monitorObject.notify();			
		}
	}
}
