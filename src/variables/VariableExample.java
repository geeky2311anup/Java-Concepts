import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // ArrayList
        System.out.println("\n30. ARRAYLIST");
        System.out.println("-------------");
        ArrayList<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");
        fruits.add("Mango");
        
        // Added: Updating element & checking existence
        fruits.set(1, "Blueberry"); // Replaces Banana with Blueberry
        System.out.println("Contains Apple: " + fruits.contains("Apple"));
        System.out.println("Fruits: " + fruits);
        System.out.println("First Fruit: " + fruits.get(0));
        
        fruits.remove("Blueberry");
        System.out.println("After Removing Blueberry: " + fruits);
        System.out.println("Size: " + fruits.size());

        // HashMap
        System.out.println("\n31. HASHMAP");
        System.out.println("-----------");
        HashMap<Integer, String> students = new HashMap<>();
        students.put(1, "Rahul");
        students.put(2, "Priya");
        students.put(3, "Amit");
        
        // Added: Default getter & key-value iteration
        System.out.println("Student with ID 2: " + students.get(2));
        System.out.println("Student with ID 99 (Default): " + students.getOrDefault(99, "Not Found"));
        System.out.println("Contains Key 1: " + students.containsKey(1));
        
        System.out.println("All Students:");
        for (Map.Entry<Integer, String> entry : students.entrySet()) {
            System.out.println("  ID: " + entry.getKey() + " -> Name: " + entry.getValue());
        }

        // Exception Handling
        System.out.println("\n32. EXCEPTION HANDLING");
        System.out.println("----------------------");
        try {
            int[] nums = {1, 2, 3};
            int result = 20 / 0;
            System.out.println(nums[5]); // Potential ArrayIndexOutOfBoundsException
            System.out.println(result);
        } catch (ArithmeticException e) {
            System.out.println("Exception Caught: " + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) { // Added: Multi-catch handling
            System.out.println("Array Index Error: " + e.getMessage());
        } finally {
            System.out.println("Finally block executed.");
        }

        // String Formatting
        System.out.println("\n33. STRING FORMAT");
        System.out.println("-----------------");
        String name = "John";
        int age = 21;
        double marks = 92.5;
        // Added: Width padding and explicit String.format usage
        String formattedStr = String.format("User: %-10s | Score: %05.2f", name, marks);
        System.out.println(formattedStr);
        System.out.printf("Name: %s, Age: %d, Marks: %.1f%n", name, age, marks);

        // Type Casting
        System.out.println("\n34. TYPE CASTING");
        System.out.println("----------------");
        double value = 25.78;
        int intValue = (int) value; // Explicit narrowing
        float floatValue = (float) value;
        
        // Added: Implicit widening cast
        long implicitLong = intValue; 
        
        System.out.println("Double: " + value);
        System.out.println("Integer (Narrowed): " + intValue);
        System.out.println("Float: " + floatValue);
        System.out.println("Long (Widened): " + implicitLong);

        // Character Methods
        System.out.println("\n35. CHARACTER METHODS");
        System.out.println("---------------------");
        char ch = 'A';
        char numChar = '7';
        
        System.out.println("Is Letter: " + Character.isLetter(ch));
        System.out.println("Is Digit: " + Character.isDigit(numChar)); // Added digit check
        System.out.println("Is Uppercase: " + Character.isUpperCase(ch));
        System.out.println("Lowercase: " + Character.toLowerCase(ch));
        System.out.println("ASCII Value: " + (int) ch);
    }
}
