public class VariableExample {

    public static void main(String[] args) {

        // Primitive Data Types
        int age = 25;
        long population = 1400000000L;
        double salary = 55000.75;
        float percentage = 89.5f;
        char grade = 'A';
        boolean isJavaFun = true;

        // Non-Primitive Data Type
        String name = "Java Programming";

        // Constant
        final double PI = 3.14159;

        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Population: " + population);
        System.out.println("Salary: " + salary);
        System.out.println("Percentage: " + percentage);
        System.out.println("Grade: " + grade);
        System.out.println("Is Java Fun? " + isJavaFun);
        System.out.println("PI Value: " + PI);

        // Variable Modification
        age = age + 5;
        salary += 10000;

        System.out.println("\nAfter Update:");
        System.out.println("Updated Age: " + age);
        System.out.println("Updated Salary: " + salary);

        // Arithmetic Operations
        int a = 20;
        int b = 10;

        System.out.println("\nArithmetic Operations:");
        System.out.println("Addition: " + (a + b));
        System.out.println("Subtraction: " + (a - b));
        System.out.println("Multiplication: " + (a * b));
        System.out.println("Division: " + (a / b));
        System.out.println("Modulus: " + (a % b));

        // Type Casting
        double num = 99.99;
        int convertedNum = (int) num;

        System.out.println("\nType Casting:");
        System.out.println("Original Double: " + num);
        System.out.println("Converted Integer: " + convertedNum);
    }
}
