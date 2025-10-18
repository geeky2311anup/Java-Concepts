//here are the primitive data types in Java
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

        //conversions
        int i = 100;
        long l = i; // implicit conversion from int to long
        float f = l; // implicit conversion from long to float
        double d = f; // implicit conversion from float to double
        System.out.println("Implicit Conversions:");
        System.out.println("int to long: " + l);
        System.out.println("long to float: " + f);
        System.out.println("float to double: " + d);

        // Printing the values
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