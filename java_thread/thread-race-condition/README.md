# Race Condition, Critical Section
### What is Critical Section & Race Condition
Critical Section is code where the thread execution order does matter. Execution Order matters because of a resource(variable, database, file) shared by different threads. This is called race condition because different threads are racing to get a common shared resource and passing through critical section. 

### Effect of Race Condition
Value of shared value will not appear as expected.

### Solution: Get lock on shared object
By using synchronized block a thread can get lock on shared object and once it is writing or updating data on that shared object, other threads cannot update the same.

### Code: Explanation
MyCounterThread is a Thread class. Any thread created using this class can share the same Counter object. 
If we see the run method of MyCounterThread class, it increaments the counter value by the value given to it. 

See the code inside the class Launcher

```sh
		Counter counter = new Counter();
		Thread t1 = new Thread(new MyCounterThread(counter, 2));
		Thread t2 = new Thread(new MyCounterThread(counter, 3));
		t2.start();
		t1.start();
```

In the above code snippet, we can see that t1 and t2 are sharing same counter object and both increament the same counter object in their run method. Following statement in the run method is a critical section:

```sh
counter.increament(value);
```

Hence it is kept inside synchronized block:
```sh
		synchronized(counter){
			counter.increament(value);			
		}
```