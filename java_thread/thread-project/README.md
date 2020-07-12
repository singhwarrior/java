# Thread Signals
### Thread Signal
Threads can signal each other. For that they use thread signaling.   

#### Custom Signal(Busy Wait)
If one thread wants to tell another thread that it has completed its working and another thread can start working on it, it can use a shared variable like MySignal. See the class ThreadA and ThreadB in package com.karma.thread.signal.custom
So MySignal is shared by both threads ThreadA and ThreadB. As soon as ThreadA gets its process done it sets the MySignal variable as true. On the other hand ThreadB will keep on waiting until the variable inside MySignal is set to true. See code busyWait method inside class ThreadB.

```sh
private void busyWait(){
	while(!sharedMySignal.isProcessingDone());
}
```

But busy wait is a less performent way of waiting for signal. Because thread is still active and hence any other thread which is free cannot utilize CPU. 

#### Wait and Notify
Java gives method wait, notify and notifyall which is just simulation of above scenario but the difference is when a thread waits using wait method, it becomes inactive and does not use CPU.
See the class ThreadSignalLauncher1. It has two threads, ThreadA and ThreadB which share WaitAndNotify object. WaitAndNotify contains two methods, doWait and doNotify and an object of a smiple class MonitorObject. 
ThreadA calls doNotify on WaitAndNotify that it is done with its working and on the other hand ThreadB calls doWait method on the same WaitAndNotify object and then starts its processing. 
 

