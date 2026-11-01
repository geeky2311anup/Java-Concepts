
import java.util.*;

public class IndexOutOfBoundException4 {
    public static void main(String[] args) {

        // 1. ArrayIndexOutOfBoundsException
        System.out.println("===== Array Example =====");

        int[] arr = new int[5];

        System.out.println(arr[0]); // Valid: 0
        System.out.println(arr[4]); // Valid: 0

        // System.out.println(arr[5]); // Exception: Index 5 is invalid
        // System.out.println(arr[-1]); // Exception: Negative index


        // 2. StringIndexOutOfBoundsException
        System.out.println("\n===== String Example =====");

        String str = "Hello";

        System.out.println(str.charAt(0)); // Valid: H
        System.out.println(str.charAt(4)); // Valid: o

        // System.out.println(str.charAt(5)); // Exception
        // System.out.println(str.charAt(-1)); // Exception


        // 3. ArrayList IndexOutOfBoundsException
        System.out.println("\n===== ArrayList Example =====");

        ArrayList<Integer> list = new ArrayList<>();

        list.add(10);
        list.add(20);
        list.add(30);

        System.out.println(list.get(0)); // Valid: 10
        System.out.println(list.get(2)); // Valid: 30

        // System.out.println(list.get(3)); // Exception
        // list.remove(5); // Exception


        // 4. LinkedList IndexOutOfBoundsException
        System.out.println("\n===== LinkedList Example =====");

        LinkedList<String> names = new LinkedList<>();

        names.add("Aman");
        names.add("Rahul");
        names.add("Rohit");

        System.out.println(names.get(1)); // Valid: Rahul

        // System.out.println(names.get(3)); // Exception
        // names.remove(5); // Exception


        // 5. SubList IndexOutOfBoundsException
        System.out.println("\n===== SubList Example =====");

        List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50);

        System.out.println(numbers.subList(1, 3)); // [20, 30]

        // System.out.println(numbers.subList(1, 6)); // Exception
        // System.out.println(numbers.subList(-1, 3)); // Exception


        // 6. String substring IndexOutOfBoundsException
        System.out.println("\n===== Substring Example =====");

        String message = "Programming";

        System.out.println(message.substring(0, 4)); // Prog

        // System.out.println(message.substring(0, 15)); // Exception
        // System.out.println(message.substring(-1, 4)); // Exception


        // 7. Character array example
        System.out.println("\n===== Character Array Example =====");

        char[] chars = {'A', 'B', 'C'};

        System.out.println(chars[1]); // Valid: B

        // System.out.println(chars[3]); // Exception


        System.out.println("\nProgram completed successfully!");
    }
}
