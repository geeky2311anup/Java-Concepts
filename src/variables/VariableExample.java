        // ArrayList
        System.out.println("\n30. ARRAYLIST");
        System.out.println("-------------");
        ArrayList<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");
        System.out.println("Fruits: " + fruits);

        // HashMap
        System.out.println("\n31. HASHMAP");
        System.out.println("-----------");
        HashMap<Integer, String> students = new HashMap<>();
        students.put(1, "Rahul");
        students.put(2, "Priya");
        students.put(3, "Amit");
        System.out.println("Student with ID 2: " + students.get(2));

        // Exception Handling
        System.out.println("\n32. EXCEPTION HANDLING");
        System.out.println("----------------------");
        try {
            int result = 20 / 0;
            System.out.println(result);
        } catch (ArithmeticException e) {
            System.out.println("Exception Caught: " + e.getMessage());
        }

        // Command Line Style Formatting
        System.out.println("\n33. STRING FORMAT");
        System.out.println("-----------------");
        String name = "John";
        int age = 21;
        System.out.printf("Name: %s, Age: %d%n", name, age);

        // Type Casting
        System.out.println("\n34. TYPE CASTING");
        System.out.println("----------------");
        double value = 25.78;
        int intValue = (int) value;
        System.out.println("Double: " + value);
        System.out.println("Integer: " + intValue);

        // Character Methods
        System.out.println("\n35. CHARACTER METHODS");
        System.out.println("---------------------");
        char ch = 'A';
        System.out.println("Is Letter: " + Character.isLetter(ch));
        System.out.println("Lowercase: " + Character.toLowerCase(ch));
