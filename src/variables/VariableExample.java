public class VariableExample {

    public static void main(String[] args) {

        System.out.println("=================================");
        System.out.println("      JAVA VARIABLES DEMO");
        System.out.println("=================================\n");

        // Primitive Data Types
        int age = 25;
        long population = 1400000000L;
        double salary = 55000.75;
        float percentage = 89.5f;
        char grade = 'A';
        boolean isJavaFun = true;

        // Non-Primitive Data Type
        String courseName = "Java Programming";

        // Constant Variable
        final double PI = 3.14159;

        System.out.println("1. PRIMITIVE DATA TYPES");
        System.out.println("-----------------------");
        System.out.println("Integer (age): " + age);
        System.out.println("Long (population): " + population);
        System.out.println("Double (salary): " + salary);
        System.out.println("Float (percentage): " + percentage);
        System.out.println("Character (grade): " + grade);
        System.out.println("Boolean (isJavaFun): " + isJavaFun);

        System.out.println("\n2. NON-PRIMITIVE DATA TYPE");
        System.out.println("--------------------------");
        System.out.println("String Value: " + courseName);

        System.out.println("\n3. CONSTANT VARIABLE");
        System.out.println("--------------------");
        System.out.println("PI Value: " + PI);

        // Updating Variables
        age += 5;
        salary += 10000;

        System.out.println("\n4. VARIABLE MODIFICATION");
        System.out.println("------------------------");
        System.out.println("Updated Age: " + age);
        System.out.println("Updated Salary: " + salary);

        // Arithmetic Operations
        int num1 = 20;
        int num2 = 10;

        System.out.println("\n5. ARITHMETIC OPERATIONS");
        System.out.println("------------------------");
        System.out.println("Number 1 = " + num1);
        System.out.println("Number 2 = " + num2);
        System.out.println("Addition       : " + (num1 + num2));
        System.out.println("Subtraction    : " + (num1 - num2));
        System.out.println("Multiplication : " + (num1 * num2));
        System.out.println("Division       : " + (num1 / num2));
        System.out.println("Modulus        : " + (num1 % num2));

        // Comparison Operators
        System.out.println("\n6. COMPARISON OPERATORS");
        System.out.println("-----------------------");
        System.out.println("num1 > num2  : " + (num1 > num2));
        System.out.println("num1 < num2  : " + (num1 < num2));
        System.out.println("num1 == num2 : " + (num1 == num2));
        System.out.println("num1 != num2 : " + (num1 != num2));

        // Type Casting
        double decimalNumber = 99.99;
        int integerNumber = (int) decimalNumber;

        System.out.println("\n7. TYPE CASTING");
        System.out.println("----------------");
        System.out.println("Original Double Value : " + decimalNumber);
        System.out.println("Converted Integer Value : " + integerNumber);

        // Implicit Type Casting
        int marks = 95;
        double marksDouble = marks;

        System.out.println("\n8. IMPLICIT TYPE CASTING");
        System.out.println("-------------------------");
        System.out.println("Integer Marks : " + marks);
        System.out.println("Converted Double Marks : " + marksDouble);

        // String Operations
        System.out.println("\n9. STRING OPERATIONS");
        System.out.println("--------------------");
        System.out.println("Course Name: " + courseName);
        System.out.println("Length of String: " + courseName.length());
        System.out.println("Upper Case: " + courseName.toUpperCase());
        System.out.println("Lower Case: " + courseName.toLowerCase());

        System.out.println("\n=================================");
        System.out.println(" Program Executed Successfully ");
        System.out.println("=================================");
    }
}
