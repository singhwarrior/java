package com.karma.thread.launch;

import com.karma.thread.signal.custom.MySignal;
import com.karma.thread.signal.custom.PoolSignal;
import com.karma.thread.signal.custom.ThreadA;
import com.karma.thread.signal.custom.ThreadB;

public class CustomSignalLauncher {
	public static void main(String[] args) {
		MySignal mySignal = new MySignal();
		MySignal[] sharedPoolSignal = new MySignal[2];
		sharedPoolSignal[0] = new MySignal();
		sharedPoolSignal[1] = new MySignal();
		PoolSignal poolSignal = new PoolSignal();
		poolSignal.setMySignals(sharedPoolSignal);
		Runnable threadA1 = new ThreadA(mySignal, poolSignal, 0);
		Runnable threadA2 = new ThreadA(mySignal, poolSignal, 1);
		Runnable threadB = new ThreadB(mySignal);
		Thread t11 = new Thread(threadA1);
		t11.setName("ThreadA1");
		Thread t12 = new Thread(threadA2);
		t12.setName("ThreadA2");
		Thread t2 = new Thread(threadB);
		t2.start();
		t11.start();
		t12.start();
	}
}
