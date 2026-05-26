// Add these inside main()

// Type Promotion
System.out.println("\n=== Type Promotion ===");
byte x = 10;
byte y = 20;
int result = x + y; // byte + byte becomes int
System.out.println("Result of byte + byte: " + result);

// Overflow
System.out.println("\n=== Overflow Example ===");
byte maxByte = 127;
maxByte++;
System.out.println("After 127 + 1 = " + maxByte);

// Underflow
byte minByte = -128;
minByte--;
System.out.println("After -128 - 1 = " + minByte);

// Character Arithmetic
System.out.println("\n=== Character Arithmetic ===");
char ch = 'A';
System.out.println("Character: " + ch);
System.out.println("Next Character: " + (char)(ch + 1));
System.out.println("ASCII Value: " + (int)ch);

// Number Literals
System.out.println("\n=== Number Literals ===");
int binaryNum = 0b1010;
int octalNum = 012;
int hexNum = 0xA;

System.out.println("Binary 1010 = " + binaryNum);
System.out.println("Octal 12 = " + octalNum);
System.out.println("Hex A = " + hexNum);

// Scientific Notation
System.out.println("\n=== Scientific Notation ===");
double scientific = 1.5e3;
System.out.println("1.5e3 = " + scientific);

// Parsing String to Primitive
System.out.println("\n=== Parsing Strings ===");
String numStr = "500";
int parsedInt = Integer.parseInt(numStr);

String doubleStr = "12.34";
double parsedDouble = Double.parseDouble(doubleStr);

System.out.println("Parsed Integer = " + parsedInt);
System.out.println("Parsed Double = " + parsedDouble);

// Wrapper Utility Methods
System.out.println("\n=== Wrapper Utility Methods ===");
System.out.println("Max Integer = " + Integer.MAX_VALUE);
System.out.println("Min Integer = " + Integer.MIN_VALUE);
System.out.println("Integer.compare(10,20) = " + Integer.compare(10,20));

// instanceof
System.out.println("\n=== instanceof Operator ===");
Integer obj = 100;
System.out.println(obj instanceof Integer);

// Math Class
System.out.println("\n=== Math Class Methods ===");
System.out.println("Max = " + Math.max(10,20));
System.out.println("Min = " + Math.min(10,20));
System.out.println("Power = " + Math.pow(2,5));
System.out.println("Square Root = " + Math.sqrt(25));

// Ternary Operator
System.out.println("\n=== Ternary Operator ===");
int age = 20;
String status = (age >= 18) ? "Adult" : "Minor";
System.out.println(status);
