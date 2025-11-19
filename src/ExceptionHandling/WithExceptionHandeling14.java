public class WithExceptionHandeling14 {
    public static  String[] arr = new String[2];
    public static void main(String[] args){
        
       try{
         setVal(5,"Hello");
       }
       catch(ArrayIndexOutOfBoundsException exceptionObj){
        System.out.println("ArrayIndexOutOfBoundsException handled successfully.");
       }    
    }

    public static void setVal(int ind, String val) throws ArrayIndexOutOfBoundsException{
        arr[ind] = val;// this will cause ArrayIndexOutOfBoundsException at runtime because index is out of bounds.
    }
}
//or you can do like this
//    public static void main(String[] args){
//     try{
//       String[] arr = new String[2];
//       int ind = 5;
//       String val = "Hello";
//       arr[ind] = val; // this will cause ArrayIndexOutOfBoundsException at runtime because index is out of bounds.
//     }  
//     catch(ArrayIndexOutOfBoundsException exceptionObj){
//      System.out.println("ArrayIndexOutOfBoundsException handled successfully.");
//     }
// }      
//we should avoid exception handling if stack trace is large and we are not able to find the root cause of the exception.

