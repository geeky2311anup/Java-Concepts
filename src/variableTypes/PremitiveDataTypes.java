// ===============================
// MAXIMUM OF THREE NUMBERS
// ===============================

System.out.println("\n=== Maximum of Three Numbers ===");

int a = 12;
int b = 45;
int c = 30;

int largest = Math.max(a, Math.max(b, c));

System.out.println("Largest = " + largest);

// ===============================
// MINIMUM OF THREE NUMBERS
// ===============================

System.out.println("\n=== Minimum of Three Numbers ===");

int smallest = Math.min(a, Math.min(b, c));

System.out.println("Smallest = " + smallest);

// ===============================
// SQUARE & CUBE
// ===============================

System.out.println("\n=== Square and Cube ===");

int value1 = 6;

System.out.println("Square = " + (value1 * value1));
System.out.println("Cube = " + (value1 * value1 * value1));

// ===============================
// ASCII VALUE
// ===============================

System.out.println("\n=== ASCII Value ===");

char ch = 'A';

System.out.println("Character = " + ch);
System.out.println("ASCII = " + (int) ch);

// ===============================
// ASCII TO CHARACTER
// ===============================

System.out.println("\n=== ASCII to Character ===");

int ascii = 97;

System.out.println("Character = " + (char) ascii);

// ===============================
// CHARACTER CASE CHECK
// ===============================

System.out.println("\n=== Character Case Check ===");

char letter = 'G';

if (Character.isUpperCase(letter))
    System.out.println(letter + " is Uppercase");
else
    System.out.println(letter + " is Lowercase");

// ===============================
// VOWEL OR CONSONANT
// ===============================

System.out.println("\n=== Vowel or Consonant ===");

char alphabet = 'e';

if ("aeiouAEIOU".indexOf(alphabet) != -1)
    System.out.println(alphabet + " is a Vowel");
else
    System.out.println(alphabet + " is a Consonant");

// ===============================
// POSITIVE NEGATIVE OR ZERO
// ===============================

System.out.println("\n=== Positive Negative or Zero ===");

int num = -12;

if (num > 0)
    System.out.println("Positive");
else if (num < 0)
    System.out.println("Negative");
else
    System.out.println("Zero");

// ===============================
// ABSOLUTE VALUE
// ===============================

System.out.println("\n=== Absolute Value ===");

int negative = -45;

System.out.println("Absolute = " + Math.abs(negative));

// ===============================
// POWER USING Math.pow()
// ===============================

System.out.println("\n=== Power Function ===");

int base = 3;
int exponent = 4;

System.out.println(base + "^" + exponent + " = " + Math.pow(base, exponent));

// ===============================
// SQUARE ROOT
// ===============================

System.out.println("\n=== Square Root ===");

double number1 = 144;

System.out.println("Square Root = " + Math.sqrt(number1));

// ===============================
// CEIL FLOOR ROUND
// ===============================

System.out.println("\n=== Ceil Floor Round ===");

double decimal = 15.67;

System.out.println("Floor = " + Math.floor(decimal));
System.out.println("Ceil = " + Math.ceil(decimal));
System.out.println("Round = " + Math.round(decimal));

// ===============================
// RANDOM DOUBLE
// ===============================

System.out.println("\n=== Random Double ===");

double randomDouble = Math.random();

System.out.println("Random = " + randomDouble);

// ===============================
// BOOLEAN OPERATORS
// ===============================

System.out.println("\n=== Boolean Operators ===");

boolean x = true;
boolean y = false;

System.out.println("x && y = " + (x && y));
System.out.println("x || y = " + (x || y));
System.out.println("!x = " + (!x));

// ===============================
// TYPE CASTING
// ===============================

System.out.println("\n=== Type Casting ===");

double price = 199.99;

int whole = (int) price;

System.out.println("Double = " + price);
System.out.println("Integer = " + whole);

// ===============================
// INTEGER DIVISION
// ===============================

System.out.println("\n=== Integer Division ===");

int dividend = 17;
int divisor = 5;

System.out.println("Quotient = " + (dividend / divisor));
System.out.println("Remainder = " + (dividend % divisor));

// ===============================
// BOOLEAN COMPARISON
// ===============================

System.out.println("\n=== Boolean Comparison ===");

int age = 20;

boolean eligible = age >= 18;

System.out.println("Eligible to Vote = " + eligible);

// ===============================
// STRING TO NUMBER
// ===============================

System.out.println("\n=== String to Number ===");

String text = "250";

int integerValue = Integer.parseInt(text);

System.out.println(integerValue + 50);

// ===============================
// NUMBER TO STRING
// ===============================

System.out.println("\n=== Number to String ===");

int score = 95;

String scoreText = String.valueOf(score);

System.out.println(scoreText + " Marks");

// ===============================
// DIGIT COUNT
// ===============================

System.out.println("\n=== Count Digits ===");

int digitNumber = 987654;

int digits = String.valueOf(digitNumber).length();

System.out.println("Digits = " + digits);

// ===============================
// REVERSE SIGN
// ===============================

System.out.println("\n=== Reverse Sign ===");

int original = 40;

System.out.println("Original = " + original);
System.out.println("Negative = " + (-original));

// ===============================
// IS DIVISIBLE
// ===============================

System.out.println("\n=== Divisibility Check ===");

int check = 36;

System.out.println("Divisible by 3 = " + (check % 3 == 0));
System.out.println("Divisible by 5 = " + (check % 5 == 0));

// ===============================
// HYPOTENUSE
// ===============================

System.out.println("\n=== Hypotenuse ===");

double side1 = 3;
double side2 = 4;

double hypotenuse = Math.hypot(side1, side2);

System.out.println("Hypotenuse = " + hypotenuse);

// ===============================
// CLAMP VALUE
// ===============================

System.out.println("\n=== Clamp Value ===");

int input = 125;

int clamped = Math.max(0, Math.min(100, input));

System.out.println("Clamped Value = " + clamped);

// ===============================
// DEGREE TO RADIAN
// ===============================

System.out.println("\n=== Degree to Radian ===");

double degree = 180;

System.out.println("Radians = " + Math.toRadians(degree));

// ===============================
// RADIAN TO DEGREE
// ===============================

System.out.println("\n=== Radian to Degree ===");

double radian = Math.PI;

System.out.println("Degrees = " + Math.toDegrees(radian));
