

public class NullPointerException5 {
    public static void main(String [] args){
        String str = null;
         System.out.println(str+"hello");// this will not throw NullPointerException because of concatenation, it results in "nullhello"
          System.out.println(str);//this will not throw NullPointerException, it will print "null"
         System.out.println(str.charAt(0));// this will throw NullPointerException at runtime
        System.out.println(str.length()); // This will throw NullPointerException at runtime
    }
}
