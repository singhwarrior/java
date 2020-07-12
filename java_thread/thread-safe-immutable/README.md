# Thread Safe-Immutable Objects
Immutable Objects can be Thread Safe depending on how they are used.

# Example of Immutable Object
See the Immutable counter @ImmutableCounter class.
	
	
	Line1 : ImmutableCounter counter = new ImmutableCounter(0);
	Line2 : System.out.println(counter.getValue());
	Line3 : counter = counter.increament();
	Line4 : System.out.println(counter.getValue());	
	
In the above scenario, 
Line1 creates a new object counter which has an instance variable called value=0.
Line3 counter.increament() will create a new object of ImmutableCounter, which will be referenced by counter variable. It will take the value of previous object add 1 to it and create a new object by passing the incremented value. 
So we are not changing/mutating the first object but created a new object.

# Example of using Immutable object as thread safe 
See @MyThread class, where there is a variable counter of type @ImmutableCounter. Now if there is a shared counter object in two threads as shown in class Launcher class, it will be thread safe.

# Example of using Immutable object but thread unsafe 
If Immutable object itself has been used as instance variable of another object and that object is shared between different threads then that will be not thread safe. Example: Calculator class where ImmutableCounter class has been used as instance variable. But since object of Calculator class is shared between two threads shown in AnotherLauncher class, so it is not thread safe. 