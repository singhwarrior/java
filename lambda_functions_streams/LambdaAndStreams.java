import java.util.concurrent.*;
import java.util.stream.IntStream;

public class LambdaAndStreams{
 public static void main(String[] args){
  // Lambda Function. We have to have a Functional Interface in Java
  Drawable rectangle = () -> {
   System.out.println("Drawing Rectangle");
  };
  rectangle.draw(); 
  rectangle.move("rectangle");
  
  ExecutorService executorService = Executors.newFixedThreadPool(10);
  
  /*
  for(int i=0; i<=10; i++){
   final int index = i;
   Runnable task = () -> System.out.println("TASK_ID="+index);
   executorService.execute(task);  
  }
  */
  
  IntStream.range(0,11).forEach((i) -> {
   Runnable task = () -> System.out.println("TASK_ID="+i);
   executorService.execute(task);
  });
  executorService.shutdown();
  
  Unary square = (x) -> x*x;
  Unary cube = (x) -> x*x*x;
  System.out.println("SQUARE of "+2+"="+square.function(2));
  System.out.println("CUBE of "+3+"="+cube.function(3));

  Binary _add = (x,y) -> x + y;
  Binary _mul = (x,y) -> x*y;
  System.out.println("SUM of 2,3 ="+_add.function(2,3));
  System.out.println("PRODUCT of 2,3 ="+_mul.function(2,3));
 }

 private interface Drawable{
  void draw();
  default void move(String shape){
   System.out.println("Moving "+shape);
  }
 }

 private interface Unary{
  int function(int x);
 }

 private interface Binary{
  int function(int x, int y);
 }
 	
}
