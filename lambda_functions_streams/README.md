# Streams and Functional Programming in Java

### Functional Programming in Java

Functional Programming a long awaited feature in Java. Java 1.8 came up with concept of Lambda Functions and Streams. It made Java to step towards writing much more simpler iterative logic.   

Lets understand how Java to implement Java Lambda Functions. For to write Lambda Expression first we need to create **Function Interface**. It is nothing but same old interface with single abstract method. Inside LambdaAndStreams.java, first Drawable interface has been created which is nothing but a Function Interface. It contains an abstract method draw() and a default method move which is a concrete method.

```Java
private interface Drawable{
 void draw();
 default void move(String shape){
  System.out.println("Moving "+shape);
 }
}
```

To create a Lambda Function rectangle is created. The function implements the one and only abstract method mentioned in Function Interface. Following code snippet shows the same.

```Java
Drawable rectangle = () -> {
 System.out.println("Drawing Rectangle");
};
```

The above code creates the Function Object. Following code snippet shows how to call the function.

```Java
rectangle.draw();
rectangle.move("rectangle");
```   

### Streams in Java

In Java 1.8, another feature or module came together with Functional Programming concept which is Stream. We can find different streams inside package **java.util.stream**. As shown in the code snippet inside LambdaAndStreams.java, calling forEach function on IntStream object. We can see the local variable i is a new variable for every iteration. 
```Java
IntStream.range(0,11).forEach((i) -> {
 Runnable task = () -> System.out.println("TASK_ID="+i);
 executorService.execute(task);
});
```
Following code snippet shows how the same parallel tasks used to be created in older way. We can see there we do need to create a final variable.  


### Higher Order Functions

Most of the functional programming language allow to call a function object as an argument when we define a function. It makes the implementation flexible. We can replace function object with any implementaion of the function(arguments and return type should be maintained as per definition).

Following code snippet shows that following function sum takes first argument as function object and second argument is a Integer Stream. Function object only takes functions which can take Integer as an argument and also returns an Integer argument. 


```Java
private static int sum(Unary f, IntStream numbers){
 return numbers.map((i) -> f.function(i)).sum();
}
```  

Following code snippets show how easily the Higher Order Function can take different implementation of the function object. 

```Java
System.out.println(sum((i) -> i, IntStream.range(1,10)));
System.out.println(sum(i -> i*i, IntStream.range(1,10)));
System.out.println(sum(i -> i*i*i, IntStream.range(1,10)));
System.out.println(sum(i -> cube(i), IntStream.range(1,10)));
```

### Difference from other Functional Programming

For passing function as an argument we need to define an Interface but in another functional programming languages like Scala we dont need to define an Interface but we can define a higher oder function as follows:

```Scala
def sum(f : Int => Int, numbers : List[Int]){
 var sum = 0
 numbers.foreach(sum+=f(_))
 sum 
}
```

But in as said earlier in Java we have to define an Interface which is some extra code we have to write which could have been avoided.







