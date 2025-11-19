

public class IndexOutOfBoundException4 {
    public static void main(String[] args) {
        int[] arr = new int[5];
        System.out.println(arr[5]); // This will throw IndexOutOfBoundsException at runtime
        String str = "Hello";
        System.out.println(str.charAt(5)); // This will also throw IndexOutOfBoundsException at runtime
    }
}
