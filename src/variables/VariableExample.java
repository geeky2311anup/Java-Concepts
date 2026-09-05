// ================= STRINGBUILDER =================
System.out.println("\n36. STRINGBUILDER");
System.out.println("-----------------");

StringBuilder sb = new StringBuilder("Hello");

sb.append(" World");
System.out.println("After Append: " + sb);

sb.insert(5, ",");
System.out.println("After Insert: " + sb);

sb.replace(0, 5, "Hi");
System.out.println("After Replace: " + sb);

System.out.println("Length: " + sb.length());
System.out.println("Character at index 2: " + sb.charAt(2));

System.out.println("Substring: " + sb.substring(0, 4));

sb.delete(2, 4);
System.out.println("After Delete: " + sb);

sb.deleteCharAt(1);
System.out.println("After Delete Char: " + sb);

sb.append(" Java");
System.out.println("After Append Again: " + sb);

System.out.println("Index of Java: " + sb.indexOf("Java"));

sb.reverse();
System.out.println("Reversed: " + sb);

sb.reverse();
System.out.println("Back to Original: " + sb);

System.out.println("Length: " + sb.length());
System.out.println("Capacity: " + sb.capacity());


// ================= MATH METHODS =================
System.out.println("\n37. MATH METHODS");
System.out.println("----------------");

int a = 15, b = 4;

System.out.println("Maximum: " + Math.max(a, b));
System.out.println("Minimum: " + Math.min(a, b));
System.out.println("Power: " + Math.pow(2, 5));
System.out.println("Square Root: " + Math.sqrt(64));
System.out.println("Absolute Value: " + Math.abs(-25));
System.out.println("Rounded Value: " + Math.round(12.6));
System.out.println("Ceiling: " + Math.ceil(12.3));
System.out.println("Floor: " + Math.floor(12.9));

System.out.println("Random Number: " + (int)(Math.random() * 100));

System.out.println("Sign: " + Math.signum(-10));
System.out.println("Cube Root: " + Math.cbrt(27));
System.out.println("2 to the Power 3: " + Math.pow(2, 3));

System.out.println("Sine 90°: " + Math.sin(Math.toRadians(90)));
System.out.println("Cosine 0°: " + Math.cos(Math.toRadians(0)));
System.out.println("Tangent 45°: " + Math.tan(Math.toRadians(45)));

System.out.println("PI: " + Math.PI);
System.out.println("E: " + Math.E);

System.out.println("Log: " + Math.log(10));
System.out.println("Log10: " + Math.log10(100));


// ================= WRAPPER CLASS =================
System.out.println("\n38. WRAPPER CLASS");
System.out.println("-----------------");

Integer num = Integer.valueOf(100);
Double decimal = Double.valueOf(45.67);

System.out.println("Integer: " + num);
System.out.println("Double: " + decimal);

System.out.println("Parsed Integer: " + Integer.parseInt("250"));
System.out.println("Parsed Double: " + Double.parseDouble("98.45"));

System.out.println("Integer as String: " + num.toString());
System.out.println("Maximum Integer: " + Integer.MAX_VALUE);
System.out.println("Minimum Integer: " + Integer.MIN_VALUE);

System.out.println("Integer to Binary: " + Integer.toBinaryString(10));
System.out.println("Integer to Hex: " + Integer.toHexString(255));
System.out.println("Integer to Octal: " + Integer.toOctalString(8));

System.out.println("Compare: " + Integer.compare(20, 10));
System.out.println("Is Digit: " + Character.isDigit('5'));
System.out.println("Is Letter: " + Character.isLetter('A'));

System.out.println("Is Letter or Digit: " + Character.isLetterOrDigit('7'));
System.out.println("Is Whitespace: " + Character.isWhitespace(' '));
System.out.println("Uppercase: " + Character.toUpperCase('a'));
System.out.println("Lowercase: " + Character.toLowerCase('A'));

System.out.println("Binary to Integer: " + Integer.parseInt("1010", 2));
System.out.println("Hex to Integer: " + Integer.parseInt("FF", 16));


// ================= COMMAND LINE ARGUMENTS =================
System.out.println("\n39. COMMAND LINE ARGUMENTS");
System.out.println("--------------------------");

if (args.length > 0) {

    System.out.println("Total Arguments: " + args.length);

    System.out.println("Arguments:");

    for (int i = 0; i < args.length; i++) {
        System.out.println("Argument " + (i + 1) + ": " + args[i]);
    }

    System.out.println("First Argument: " + args[0]);
    System.out.println("Last Argument: " + args[args.length - 1]);

    // Check whether a particular argument exists
    String search = "Java";
    boolean found = false;

    for (String arg : args) {
        if (arg.equals(search)) {
            found = true;
            break;
        }
    }

    System.out.println("Contains '" + search + "': " + found);

} else {
    System.out.println("No command line arguments provided.");
}


// ================= DATE & TIME =================
System.out.println("\n40. DATE & TIME");
System.out.println("---------------");

java.time.LocalDate today = java.time.LocalDate.now();
java.time.LocalTime currentTime = java.time.LocalTime.now();
java.time.LocalDateTime dateTime = java.time.LocalDateTime.now();

System.out.println("Today's Date: " + today);
System.out.println("Current Time: " + currentTime);
System.out.println("Current Date & Time: " + dateTime);

System.out.println("Year: " + today.getYear());
System.out.println("Month: " + today.getMonth());
System.out.println("Month Value: " + today.getMonthValue());
System.out.println("Day: " + today.getDayOfMonth());

System.out.println("Day of Week: " + today.getDayOfWeek());
System.out.println("Day of Year: " + today.getDayOfYear());

System.out.println("Tomorrow: " + today.plusDays(1));
System.out.println("Yesterday: " + today.minusDays(1));

System.out.println("Next Month: " + today.plusMonths(1));
System.out.println("Previous Month: " + today.minusMonths(1));

System.out.println("Current Hour: " + currentTime.getHour());
System.out.println("Current Minute: " + currentTime.getMinute());
System.out.println("Current Second: " + currentTime.getSecond());
System.out.println("Current Nano: " + currentTime.getNano());

System.out.println("Date After 1 Year: " + today.plusYears(1));
System.out.println("Date Before 1 Year: " + today.minusYears(1));

System.out.println("Is Leap Year: " + today.isLeapYear());

System.out.println("Day of Week in 10 Days: "
        + today.plusDays(10).getDayOfWeek());


// Date comparison
java.time.LocalDate futureDate = today.plusDays(10);

System.out.println("Is Future Date After Today: "
        + futureDate.isAfter(today));

System.out.println("Is Today Before Future Date: "
        + today.isBefore(futureDate));

System.out.println("Are Dates Equal: "
        + today.isEqual(today));
