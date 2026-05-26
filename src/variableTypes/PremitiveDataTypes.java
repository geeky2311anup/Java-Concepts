// Primitive Data Types in Java
public class PrimitiveDataTypes {
    public static void main(String[] args) {

        // Integer types
        byte byteVar = 100;
        short shortVar = 10000;
        int intVar = 100000;
        long longVar = 100000L;

        // Floating-point types
        float floatVar = 10.5f;
        double doubleVar = 20.5;

        // Character type
        char charVar = 'A';

        // Boolean type
        boolean booleanVar = true;

        // Implicit Conversions (Widening)
        int i = 100;
        long l = i;
        float f = l;
        double d = f;

        System.out.println("=== Implicit Conversions ===");
        System.out.println("int to long: " + l);
        System.out.println("long to float: " + f);
        System.out.println("float to double: " + d);

        // Explicit Conversions (Narrowing)
        double num = 99.99;
        int intNum = (int) num;
        byte byteNum = (byte) intNum;

        System.out.println("\n=== Explicit Conversions ===");
        System.out.println("double value: " + num);
        System.out.println("double to int: " + intNum);
        System.out.println("int to byte: " + byteNum);

        // Primitive values
        System.out.println("\n=== Primitive Values ===");
        System.out.println("Byte Value: " + byteVar);
        System.out.println("Short Value: " + shortVar);
        System.out.println("Integer Value: " + intVar);
        System.out.println("Long Value: " + longVar);
        System.out.println("Float Value: " + floatVar);
        System.out.println("Double Value: " + doubleVar);
        System.out.println("Character Value: " + charVar);
        System.out.println("Boolean Value: " + booleanVar);

        // ASCII / Unicode
        System.out.println("\n=== Character and ASCII ===");
        System.out.println("Character: " + charVar);
        System.out.println("ASCII Value: " + (int) charVar);

        // Arithmetic operations
        int a = 10;
        int b = 3;

        System.out.println("\n=== Arithmetic Operations ===");
        System.out.println("Addition: " + (a + b));
        System.out.println("Subtraction: " + (a - b));
        System.out.println("Multiplication: " + (a * b));
        System.out.println("Division: " + (a / b));
        System.out.println("Modulus: " + (a % b));

        // Range of primitive types
        System.out.println("\n=== Data Type Ranges ===");
        System.out.println("Byte Range: " + Byte.MIN_VALUE + " to " + Byte.MAX_VALUE);
        System.out.println("Short Range: " + Short.MIN_VALUE + " to " + Short.MAX_VALUE);
        System.out.println("Int Range: " + Integer.MIN_VALUE + " to " + Integer.MAX_VALUE);
        System.out.println("Long Range: " + Long.MIN_VALUE + " to " + Long.MAX_VALUE);
        System.out.println("Float Range: " + Float.MIN_VALUE + " to " + Float.MAX_VALUE);
        System.out.println("Double Range: " + Double.MIN_VALUE + " to " + Double.MAX_VALUE);

        // Wrapper Classes
        Integer wrapperInt = Integer.valueOf(50);
        Double wrapperDouble = Double.valueOf(25.5);

        System.out.println("\n=== Wrapper Classes ===");
        System.out.println("Integer Wrapper: " + wrapperInt);
        System.out.println("Double Wrapper: " + wrapperDouble);

        // Auto Boxing and Unboxing
        Integer boxed = 200; // Autoboxing
        int unboxed = boxed; // Unboxing

        System.out.println("\n=== Autoboxing and Unboxing ===");
        System.out.println("Boxed Integer: " + boxed);
        System.out.println("Unboxed int: " + unboxed);
    }
}
