        // Enhanced For Loop
        System.out.println("\n24. ENHANCED FOR LOOP");
        System.out.println("---------------------");
        int[] numbers = {10, 20, 30, 40, 50};
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Math Class
        System.out.println("\n25. MATH CLASS");
        System.out.println("--------------");
        System.out.println("Maximum: " + Math.max(15, 25));
        System.out.println("Minimum: " + Math.min(15, 25));
        System.out.println("Square Root of 64: " + Math.sqrt(64));

        // StringBuilder
        System.out.println("\n26. STRINGBUILDER");
        System.out.println("-----------------");
        StringBuilder sb = new StringBuilder("Java");
        sb.append(" Programming");
        System.out.println("Output: " + sb);

        // Wrapper Class
        System.out.println("\n27. WRAPPER CLASS");
        System.out.println("-----------------");
        String numStr = "123";
        int number = Integer.parseInt(numStr);
        System.out.println("Parsed Integer: " + number);

        // Random Number
        System.out.println("\n28. RANDOM NUMBER");
        System.out.println("-----------------");
        Random random = new Random();
        System.out.println("Random Number (0-99): " + random.nextInt(100));

        // Current Date and Time
        System.out.println("\n29. CURRENT DATE & TIME");
        System.out.println("-----------------------");
        LocalDateTime now = LocalDateTime.now();
        System.out.println("Current Date & Time: " + now);
