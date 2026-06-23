import java.util.Arrays;

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

        age += 5;
        salary += 10000;

        System.out.println("\n4. VARIABLE MODIFICATION");
        System.out.println("------------------------");
        System.out.println("Updated Age: " + age);
        System.out.println("Updated Salary: " + salary);

        int num1 = 20;
        int num2 = 10;

        System.out.println("\n5. ARITHMETIC OPERATIONS");
        System.out.println("------------------------");
        System.out.println("Addition       : " + (num1 + num2));
        System.out.println("Subtraction    : " + (num1 - num2));
        System.out.println("Multiplication : " + (num1 * num2));
        System.out.println("Division       : " + (num1 / num2));
        System.out.println("Modulus        : " + (num1 % num2));

        System.out.println("\n6. COMPARISON OPERATORS");
        System.out.println("-----------------------");
        System.out.println("num1 > num2  : " + (num1 > num2));
        System.out.println("num1 < num2  : " + (num1 < num2));
        System.out.println("num1 == num2 : " + (num1 == num2));
        System.out.println("num1 != num2 : " + (num1 != num2));

        double decimalNumber = 99.99;
        int integerNumber = (int) decimalNumber;

        System.out.println("\n7. TYPE CASTING");
        System.out.println("----------------");
        System.out.println("Double Value : " + decimalNumber);
        System.out.println("Integer Value: " + integerNumber);

        int marks = 95;
        double marksDouble = marks;

        System.out.println("\n8. IMPLICIT TYPE CASTING");
        System.out.println("-------------------------");
        System.out.println("Integer Marks : " + marks);
        System.out.println("Double Marks  : " + marksDouble);

        System.out.println("\n9. STRING OPERATIONS");
        System.out.println("--------------------");
        System.out.println("Course Name: " + courseName);
        System.out.println("Length: " + courseName.length());
        System.out.println("Upper Case: " + courseName.toUpperCase());
        System.out.println("Lower Case: " + courseName.toLowerCase());

        // Arrays
        int[] numbers = {10, 20, 30, 40, 50};

        System.out.println("\n10. ARRAY OPERATIONS");
        System.out.println("--------------------");
        System.out.println("Array: " + Arrays.toString(numbers));
        System.out.println("First Element: " + numbers[0]);
        System.out.println("Last Element: " + numbers[numbers.length - 1]);

        // For Loop
        System.out.println("\n11. FOR LOOP");
        System.out.println("------------");
        for (int i = 1; i <= 5; i++) {
            System.out.println("Count = " + i);
        }

        // While Loop
        System.out.println("\n12. WHILE LOOP");
        System.out.println("--------------");
        int count = 1;
        while (count <= 3) {
            System.out.println("Value = " + count);
            count++;
        }

        // If Else
        System.out.println("\n13. IF ELSE");
        System.out.println("-----------");
        if (marks >= 90) {
            System.out.println("Grade: Excellent");
        } else {
            System.out.println("Grade: Good");
        }

        // Switch Case
        System.out.println("\n14. SWITCH CASE");
        System.out.println("---------------");
        int day = 3;

        switch (day) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            default:
                System.out.println("Other Day");
        }

        // Enhanced For Loop
        System.out.println("\n15. ENHANCED FOR LOOP");
        System.out.println("---------------------");
        for (int value : numbers) {
            System.out.print(value + " ");
        }

        // Logical Operators
        System.out.println("\n\n16. LOGICAL OPERATORS");
        System.out.println("---------------------");
        boolean a = true;
        boolean b = false;

        System.out.println("a && b = " + (a && b));
        System.out.println("a || b = " + (a || b));
        System.out.println("!a = " + (!a));

        // Math Functions
        System.out.println("\n17. MATH FUNCTIONS");
        System.out.println("------------------");
        System.out.println("Maximum: " + Math.max(25, 50));
        System.out.println("Minimum: " + Math.min(25, 50));
        System.out.println("Square Root of 64: " + Math.sqrt(64));
        System.out.println("Power 2^5: " + Math.pow(2, 5));

        // Method Call
        System.out.println("\n18. METHOD CALL");
        System.out.println("---------------");
        int result = addNumbers(15, 25);
        System.out.println("Sum = " + result);

        System.out.println("\n=================================");
        System.out.println(" Program Executed Successfully ");
        System.out.println("=================================");
    }

    static int addNumbers(int a, int b) {
        return a + b;
    }
}
