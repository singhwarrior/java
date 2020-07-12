
public class Anonymous{

 public static void main(String[] args){
  System.out.println("Hello World!");

  // Named class
  Drawable circle = new Circle();
  circle.draw();

  // Annonymous class
  Drawable square = new Drawable(){
   
   public void draw(){
    System.out.println("Drawing Square!!");
   }

   public void move(){
    System.out.println("Moving Square!!");
   }
  };

  square.draw();
  square.move();

 }

 interface Drawable{
  void draw();
  void move();
 }

 static class Circle implements Drawable{
   public void draw(){
    System.out.println("Drawing Circle!!");
   }

   public void move(){
    System.out.println("Moving Circle!!");
   }  
 }
	
}
