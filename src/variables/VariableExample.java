        // ================= STRINGBUILDER =================
        System.out.println("\n36. STRINGBUILDER");
        System.out.println("-----------------");

        StringBuilder sb = new StringBuilder("Hello");
        sb.append(" World");
        sb.insert(5, ",");
        sb.replace(0, 5, "Hi");
        System.out.println("StringBuilder: " + sb);
        sb.reverse();
        System.out.println("Reversed: " + sb);

        // ================= MATH METHODS =================
        System.out.println("\n37. MATH METHODS");
        System.out.println("----------------");

        int a = 15, b = 4;
        System.out.println("Maximum: " + Math.max(a, b));
        System.out.println("Minimum: " + Math.min(a, b));
        System.out.println("Power: " + Math.pow(2, 5));
        System.out.println("Square Root: " + Math.sqrt(64));
        System.out.println("Random Number: " + (int)(Math.random() * 100));

        // ================= WRAPPER CLASS =================
        System.out.println("\n38. WRAPPER CLASS");
        System.out.println("-----------------");

        Integer num = Integer.valueOf(100);
        Double decimal = Double.valueOf(45.67);

        System.out.println("Integer: " + num);
        System.out.println("Double: " + decimal);
        System.out.println("Parsed Integer: " + Integer.parseInt("250"));
        System.out.println("Parsed Double: " + Double.parseDouble("98.45"));

        // ================= COMMAND LINE ARGUMENTS =================
        System.out.println("\n39. COMMAND LINE ARGUMENTS");
        System.out.println("--------------------------");

        if (args.length > 0) {
            System.out.println("Arguments:");
            for (String arg : args) {
                System.out.println(arg);
            }
        } else {
            System.out.println("No command line arguments provided.");
        }

        // ================= DATE & TIME =================
        System.out.println("\n40. DATE & TIME");
        System.out.println("---------------");

        java.time.LocalDate today = java.time.LocalDate.now();
        java.time.LocalTime currentTime = java.time.LocalTime.now();

        System.out.println("Today's Date: " + today);
        System.out.println("Current Time: " + currentTime);
