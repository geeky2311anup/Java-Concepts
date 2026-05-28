// Demonstration of Primitive Data Types in Java

public class PrimitiveDataTypes {
    public static void main(String[] args) {

        // ===============================
        // INTEGER DATA TYPES
        // ===============================

        byte byteVar = 100;
        short shortVar = 10000;
        int intVar = 100000;
        long longVar = 100000000L;

        // ===============================
        // FLOATING POINT DATA TYPES
        // ===============================

        float floatVar = 10.5f;
        double doubleVar = 20.55555;

        // ===============================
        // CHARACTER & BOOLEAN
        // ===============================

        char charVar = 'A';
        boolean booleanVar = true;

        // ===============================
        // IMPLICIT TYPE CONVERSION
        // ===============================

        int i = 100;
        long l = i;          // int -> long
        float f = l;         // long -> float
        double d = f;        // float -> double

        System.out.println("=== Implicit Type Conversion ===");
        System.out.println("int to long: " + l);
        System.out.println("long to float: " + f);
        System.out.println("float to double: " + d);

        // ===============================
        // EXPLICIT TYPE CASTING
        // ===============================

        double decimalNum = 99.99;
        int convertedInt = (int) decimalNum;

        long bigNumber = 5000;
        short convertedShort = (short) bigNumber;

        System.out.println("\n=== Explicit Type Casting ===");
        System.out.println("double to int: " + convertedInt);
        System.out.println("long to short: " + convertedShort);

        // ===============================
        // ASCII VALUE USING CHAR
        // ===============================

        char letter = 'B';
        int asciiValue = letter;

        System.out.println("\n=== Character Operations ===");
        System.out.println("Character: " + letter);
        System.out.println("ASCII Value: " + asciiValue);

        // ===============================
        // ARITHMETIC OPERATIONS
        // ===============================

        int a = 20;
        int b = 10;

        System.out.println("\n=== Arithmetic Operations ===");
        System.out.println("Addition: " + (a + b));
        System.out.println("Subtraction: " + (a - b));
        System.out.println("Multiplication: " + (a * b));
        System.out.println("Division: " + (a / b));
        System.out.println("Modulus: " + (a % b));

        // ===============================
        // BOOLEAN OPERATIONS
        // ===============================

        boolean x = true;
        boolean y = false;

        System.out.println("\n=== Boolean Operations ===");
        System.out.println("x AND y: " + (x && y));
        System.out.println("x OR y: " + (x || y));
        System.out.println("NOT x: " + (!x));

        // ===============================
        // MIN AND MAX VALUES
        // ===============================

        System.out.println("\n=== Min and Max Values ===");
        System.out.println("Byte Min: " + Byte.MIN_VALUE);
        System.out.println("Byte Max: " + Byte.MAX_VALUE);

        System.out.println("Short Min: " + Short.MIN_VALUE);
        System.out.println("Short Max: " + Short.MAX_VALUE);

        System.out.println("Integer Min: " + Integer.MIN_VALUE);
        System.out.println("Integer Max: " + Integer.MAX_VALUE);

        System.out.println("Long Min: " + Long.MIN_VALUE);
        System.out.println("Long Max: " + Long.MAX_VALUE);

        System.out.println("Float Min: " + Float.MIN_VALUE);
        System.out.println("Float Max: " + Float.MAX_VALUE);

        System.out.println("Double Min: " + Double.MIN_VALUE);
        System.out.println("Double Max: " + Double.MAX_VALUE);

        // ===============================
        // PRINTING ALL ORIGINAL VALUES
        // ===============================

        System.out.println("\n=== Original Primitive Values ===");
        System.out.println("Byte Value: " + byteVar);
        System.out.println("Short Value: " + shortVar);
        System.out.println("Integer Value: " + intVar);
        System.out.println("Long Value: " + longVar);
        System.out.println("Float Value: " + floatVar);
        System.out.println("Double Value: " + doubleVar);
        System.out.println("Character Value: " + charVar);
        System.out.println("Boolean Value: " + booleanVar);
    }
}
