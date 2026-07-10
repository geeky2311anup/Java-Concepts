        // Ternary Operator
        System.out.println("\n19. TERNARY OPERATOR");
        System.out.println("--------------------");
        String status = (marks >= 50) ? "Pass" : "Fail";
        System.out.println("Result: " + status);

        // String Comparison
        System.out.println("\n20. STRING COMPARISON");
        System.out.println("---------------------");
        String str1 = "Java";
        String str2 = "Java";
        System.out.println("Equals: " + str1.equals(str2));
        System.out.println("Contains 'av': " + str1.contains("av"));

        // Multidimensional Array
        System.out.println("\n21. 2D ARRAY");
        System.out.println("------------");
        int[][] matrix = {
                {1, 2},
                {3, 4}
        };

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        // Exception Handling
        System.out.println("\n22. EXCEPTION HANDLING");
        System.out.println("----------------------");
        try {
            int value = 10 / 2;
            System.out.println("Division Result: " + value);
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero.");
        } finally {
            System.out.println("Finally block executed.");
        }

        // User Defined Method
        System.out.println("\n23. METHOD DEMO");
        System.out.println("---------------");
        printMessage("Welcome to Java Programming!");
