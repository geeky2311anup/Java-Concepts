// ===============================
// EVEN OR ODD
// ===============================

System.out.println("\n=== Even or Odd ===");

int evenOdd = 27;

if (evenOdd % 2 == 0)
    System.out.println(evenOdd + " is Even");
else
    System.out.println(evenOdd + " is Odd");

// ===============================
// SWAP TWO NUMBERS
// ===============================

System.out.println("\n=== Swap Two Numbers ===");

int first = 10;
int second = 20;

System.out.println("Before Swap: " + first + " " + second);

int temp = first;
first = second;
second = temp;

System.out.println("After Swap: " + first + " " + second);

// ===============================
// MAX OF TWO NUMBERS
// ===============================

System.out.println("\n=== Maximum of Two Numbers ===");

int num1 = 35;
int num2 = 18;

System.out.println("Maximum = " + Math.max(num1, num2));

// ===============================
// MIN OF TWO NUMBERS
// ===============================

System.out.println("\n=== Minimum of Two Numbers ===");

System.out.println("Minimum = " + Math.min(num1, num2));

// ===============================
// CHARACTER IS DIGIT
// ===============================

System.out.println("\n=== Character is Digit ===");

char digitChar = '8';

System.out.println(Character.isDigit(digitChar));

// ===============================
// CHARACTER IS LETTER
// ===============================

System.out.println("\n=== Character is Letter ===");

char alpha = 'Z';

System.out.println(Character.isLetter(alpha));

// ===============================
// CHARACTER TO UPPERCASE
// ===============================

System.out.println("\n=== Character to Uppercase ===");

char lower = 'g';

System.out.println(Character.toUpperCase(lower));

// ===============================
// CHARACTER TO LOWERCASE
// ===============================

System.out.println("\n=== Character to Lowercase ===");

char upper = 'P';

System.out.println(Character.toLowerCase(upper));

// ===============================
// MAX & MIN INTEGER VALUE
// ===============================

System.out.println("\n=== Integer Limits ===");

System.out.println("Maximum Integer = " + Integer.MAX_VALUE);
System.out.println("Minimum Integer = " + Integer.MIN_VALUE);

// ===============================
// RANDOM INTEGER
// ===============================

System.out.println("\n=== Random Integer ===");

int randomInt = (int) (Math.random() * 100) + 1;

System.out.println("Random Number = " + randomInt);

// ===============================
// INCREMENT & DECREMENT
// ===============================

System.out.println("\n=== Increment and Decrement ===");

int count = 5;

System.out.println("Original = " + count);
System.out.println("After Increment = " + (++count));
System.out.println("After Decrement = " + (--count));

// ===============================
// AREA OF CIRCLE
// ===============================

System.out.println("\n=== Area of Circle ===");

double radius = 7;

double area = Math.PI * radius * radius;

System.out.println("Area = " + area);

// ===============================
// SIMPLE INTEREST
// ===============================

System.out.println("\n=== Simple Interest ===");

double principal = 10000;
double rate = 7.5;
double time = 2;

double interest = (principal * rate * time) / 100;

System.out.println("Simple Interest = " + interest);

// ===============================
// LEAP YEAR CHECK
// ===============================

System.out.println("\n=== Leap Year Check ===");

int year = 2024;

boolean leap = (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0);

System.out.println(year + " is Leap Year = " + leap);

// ===============================
// TEMPERATURE CONVERSION
// ===============================

System.out.println("\n=== Celsius to Fahrenheit ===");

double celsius = 37;

double fahrenheit = (celsius * 9 / 5) + 32;

System.out.println("Fahrenheit = " + fahrenheit);
