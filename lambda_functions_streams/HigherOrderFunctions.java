import java.util.stream.IntStream;

public class HigherOrderFunctions{
 public static void main(String[] args){
  Binary _add = (x,y) -> x + y;
  System.out.println(_add.operation((i) -> i*i, 2,3));
  System.out.println(sum((i) -> i, IntStream.range(1,10)));
  System.out.println(sum(i -> i*i, IntStream.range(1,10)));
  System.out.println(sum(i -> i*i*i, IntStream.range(1,10)));  
  System.out.println(sum(i -> cube(i), IntStream.range(1,10)));
 }

 private interface Unary{
  int function(int x);
 }

 private interface Binary{
 
  int function(int x, int y);
 
  default int operation(Unary f, int x, int y){
   return function(f.function(x), f.function(y));
  }
 }

 private static int sum(Unary f, IntStream numbers){
  return numbers.map((i) -> f.function(i)).sum();
 }

 private static int cube(int x){
  return x*x*x;
 }

}
