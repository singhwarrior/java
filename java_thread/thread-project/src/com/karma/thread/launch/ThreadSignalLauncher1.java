package com.karma.thread.launch;

import com.karma.thread.signal.actual1.ThreadA;
import com.karma.thread.signal.actual1.ThreadB;
import com.karma.thread.signal.actual1.WaitAndNotify;


public class ThreadSignalLauncher1 {
	public static void main(String[] args) {
		WaitAndNotify waitAndNotify = new WaitAndNotify();
		Runnable threadA1 = new ThreadA(waitAndNotify);
		Runnable threadB = new ThreadB(waitAndNotify);
		Thread t1 = new Thread(threadA1);
		t1.setName("ThreadA");
		Thread t2 = new Thread(threadB);
		t2.setName("ThreadB");
		t2.start();
		t1.start();
	}
}
