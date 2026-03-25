import java.util.Vector;

public class BasicCollection1 {
    public static void main(String[] args){
        // Array example
        int[] arr = new int[5];
        arr[0] = 10;
        arr[1] = 20;

        System.out.println("Array elements:");
        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }

        // Vector example
        Vector<Integer> vec = new Vector<>();
        vec.add(10);
        vec.add(20);
        vec.add(30);

        System.out.println("\nVector elements:");
        for(int i = 0; i < vec.size(); i++){
            System.out.println(vec.get(i));
        }

        // Extra operations
        System.out.println("\nFirst element in Vector: " + vec.get(0));
        System.out.println("Vector size: " + vec.size());

        vec.remove(1); // removes element at index 1

        System.out.println("\nVector after removal:");
        for(Integer val : vec){
            System.out.println(val);
        }
    }
}