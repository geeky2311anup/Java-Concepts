public class ClassCastException2 {
    public static void main(String[] args) {

        // Example 1
        try {
            Object obj = 100;
            String s = (String) obj;
            System.out.println(s);
        } catch (ClassCastException e) {
            System.out.println("Example 1: " + e);
        }

        // Example 2
        try {
            Object obj = "Hello Java";
            Integer num = (Integer) obj;
            System.out.println(num);
        } catch (ClassCastException e) {
            System.out.println("Example 2: " + e);
        }

        // Example 3
        try {
            Object obj = 25.5;
            Integer num = (Integer) obj;
            System.out.println(num);
        } catch (ClassCastException e) {
            System.out.println("Example 3: " + e);
        }

        // Example 4
        try {
            Object obj = new Object();
            String s = (String) obj;
            System.out.println(s);
        } catch (ClassCastException e) {
            System.out.println("Example 4: " + e);
        }

        // Safe Casting using instanceof
        System.out.println("\n=== Safe Casting ===");

        Object obj = "Java Programming";

        if (obj instanceof String) {
            String str = (String) obj;
            System.out.println("Successfully Casted: " + str);
        } else {
            System.out.println("Object is not a String");
        }

        // Another safe example
        Object value = 500;

        if (value instanceof Integer) {
            Integer num = (Integer) value;
            System.out.println("Integer Value: " + num);
        } else {
            System.out.println("Not an Integer");
        }
    }
}
