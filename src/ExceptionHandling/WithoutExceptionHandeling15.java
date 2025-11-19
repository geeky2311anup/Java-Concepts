public class WithoutExceptionHandeling15 {
    public static String[] arr = new String[5];
    public static void main(String[] args){
        String val = "Hello";
        int ind = 10;
        //we want to set the value at index 10
        int strLen = arr.length;
        if(ind>=0 && ind<strLen){
           if(val!=null){
            arr[ind] = val;
           }
           else{
            System.out.println("Null value cannot be set in the array.");
           }
        }
        else{
            System.out.println("Index out of bounds exception will occur if we try to set value at index " + ind);
        }

    }
    
}
