// ===============================
// AUTOBOXING & UNBOXING
// ===============================

System.out.println("\n=== AutoBoxing & Unboxing ===");

Integer boxed = 50;      // Autoboxing
int unboxed = boxed;     // Unboxing

System.out.println("Boxed Integer = " + boxed);
System.out.println("Unboxed int = " + unboxed);

// ===============================
// RANDOM NUMBER
// ===============================

System.out.println("\n=== Random Number Example ===");

int randomNum = (int)(Math.random() * 100) + 1;

System.out.println("Random Number (1-100): " + randomNum);

// ===============================
// SWAP TWO NUMBERS
// ===============================

System.out.println("\n=== Swapping Numbers ===");

int first = 10;
int second = 20;

System.out.println("Before Swap: " + first + ", " + second);

int temp = first;
first = second;
second = temp;

System.out.println("After Swap: " + first + ", " + second);

// ===============================
// EVEN OR ODD
// ===============================

System.out.println("\n=== Even or Odd ===");

int number = 17;

String resultText = (number % 2 == 0)
        ? "Even"
        : "Odd";

System.out.println(number + " is " + resultText);

// ===============================
// TEMPERATURE CONVERSION
// ===============================

System.out.println("\n=== Celsius to Fahrenheit ===");

double celsius = 37.0;
double fahrenheit = (celsius * 9 / 5) + 32;

System.out.println(celsius + "°C = " + fahrenheit + "°F");

// ===============================
// DIGIT EXTRACTION
// ===============================

System.out.println("\n=== Digit Extraction ===");

int value = 9876;

System.out.println("Last Digit = " + (value % 10));
System.out.println("Remaining Number = " + (value / 10));

// ===============================
// UNICODE CHARACTERS
// ===============================

System.out.println("\n=== Unicode Characters ===");

char heart = '\u2665';

System.out.println("Unicode Heart: " + heart);

// ===============================
// INCREMENT & DECREMENT
// ===============================

System.out.println("\n=== Increment & Decrement ===");

int count = 5;

System.out.println("Original = " + count);
System.out.println("Post Increment = " + count++);
System.out.println("After Increment = " + count);
System.out.println("Pre Increment = " + (++count));

// ===============================
// COMPOUND ASSIGNMENT
// ===============================

System.out.println("\n=== Compound Assignment ===");

int marks = 50;

marks += 10;
System.out.println("After += 10 : " + marks);

marks *= 2;
System.out.println("After *= 2 : " + marks);

// ===============================
// BITWISE OPERATORS
// ===============================

System.out.println("\n=== Bitwise Operators ===");

int p = 5; // 0101
int q = 3; // 0011

System.out.println("p & q = " + (p & q));
System.out.println("p | q = " + (p | q));
System.out.println("p ^ q = " + (p ^ q));
System.out.println("p << 1 = " + (p << 1));
System.out.println("p >> 1 = " + (p >> 1));

// ===============================
// RELATIONAL OPERATORS
// ===============================

System.out.println("\n=== Relational Operators ===");

int num1 = 15;
int num2 = 20;

System.out.println("num1 == num2 : " + (num1 == num2));
System.out.println("num1 != num2 : " + (num1 != num2));
System.out.println("num1 < num2  : " + (num1 < num2));
System.out.println("num1 > num2  : " + (num1 > num2));

// ===============================
// AREA OF CIRCLE
// ===============================

System.out.println("\n=== Area of Circle ===");

double radius = 7.0;
double area = Math.PI * radius * radius;

System.out.println("Radius = " + radius);
System.out.println("Area = " + area);

// ===============================
// SIMPLE INTEREST
// ===============================

System.out.println("\n=== Simple Interest ===");

double principal = 10000;
double rate = 8;
double years = 2;

double simpleInterest = (principal * rate * years) / 100;

System.out.println("Simple Interest = " + simpleInterest);
