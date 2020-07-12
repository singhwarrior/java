# Thread Safe
Code that is safe from RACE Condition will be considered as Thread Safe. 

# Local Variables are Thread Safe
When a local variable/local object is initialized within a method of a Thread, then it is thread safe. The reason is that local variable is not shared between two threads.

# Example
Counter is a simple class which contains two methods increment() and getValue()
	
	increament() => increaments value by 1
	getValue() => gives current value of Counter

MyThread is implementation of a Runnable class, contains,

	A variable size_of_increament => which shows how_many_times counter needs to be increament.
	increamentCounter() => A counter is created locally inside thie method and is incremented as defined in size_of_increament.
Launcher class

	Contains two threads of MyThread and increament 3 times and 5 times. 
	
No matter how many times we run Launcher, always counter value of Thread-1=3 and Thread-2=5, because code inside increamentCounter() is Thread Safe. There is no shared resource between two threads.  
 