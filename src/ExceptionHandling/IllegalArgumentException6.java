//illegal argument exception is caused when a method has been passed an illegal or
// inappropriate argument. like passing a negative number to a method that expects a positive number. or passing null
// to a method that does not accept null values.

public class IllegalArgumentException6 {
    public static void main(String[] args){
       int val = Integer.parseInt("123a"); // this will cause NumberFormatException beacause of illegal argument because
     // "123a" is not a valid integer, because parsing method expects a valid integer string. 
    }
  
    
}
