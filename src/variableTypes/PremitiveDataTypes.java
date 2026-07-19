// ===============================
// ABSOLUTE VALUE
// ===============================

System.out.println("\n=== Absolute Value ===");

int value = -25;

System.out.println("Absolute = " + Math.abs(value));

// ===============================
// POWER OF A NUMBER
// ===============================

System.out.println("\n=== Power ===");

int base = 3;
int exponent = 4;

System.out.println(base + "^" + exponent + " = " + (int)Math.pow(base, exponent));

// ===============================
// SQUARE ROOT
// ===============================

System.out.println("\n=== Square Root ===");

int number = 81;

System.out.println("Square Root = " + Math.sqrt(number));

// ===============================
// FLOOR, CEIL & ROUND
// ===============================

System.out.println("\n=== Floor, Ceil and Round ===");

double decimal = 12.67;

System.out.println("Floor = " + Math.floor(decimal));
System.out.println("Ceil = " + Math.ceil(decimal));
System.out.println("Round = " + Math.round(decimal));

// ===============================
// POSITIVE, NEGATIVE OR ZERO
// ===============================

System.out.println("\n=== Positive, Negative or Zero ===");

int x = -15;

if (x > 0)
    System.out.println("Positive");
else if (x < 0)
    System.out.println("Negative");
else
    System.out.println("Zero");

// ===============================
// MULTIPLE OF 5
// ===============================

System.out.println("\n=== Multiple of 5 ===");

int multiple = 45;

System.out.println(multiple % 5 == 0);

// ===============================
// ASCII VALUE OF CHARACTER
// ===============================

System.out.println("\n=== ASCII Value ===");

char ch = 'A';

System.out.println("ASCII = " + (int) ch);

// ===============================
// CHARACTER FROM ASCII
// ===============================

System.out.println("\n=== Character from ASCII ===");

int ascii = 97;

System.out.println("Character = " + (char) ascii);

// ===============================
// CLAMP VALUE BETWEEN RANGE
// ===============================

System.out.println("\n=== Clamp Value ===");

int num = 120;
int low = 0;
int high = 100;

num = Math.max(low, Math.min(num, high));

System.out.println("Clamped Value = " + num);

// ===============================
// RANDOM DOUBLE
// ===============================

System.out.println("\n=== Random Double ===");

double randomDouble = Math.random();

System.out.println("Random Double = " + randomDouble);

// ===============================
// SIGN OF A NUMBER
// ===============================

System.out.println("\n=== Sign of Number ===");

int signNum = -8;

System.out.println(Integer.signum(signNum));

// ===============================
// HYPOTENUSE OF RIGHT TRIANGLE
// ===============================

System.out.println("\n=== Hypotenuse ===");

double a = 3;
double b = 4;

System.out.println("Hypotenuse = " + Math.hypot(a, b));

// ===============================
// DIVISIBLE BY BOTH 3 AND 5
// ===============================

System.out.println("\n=== Divisible by 3 and 5 ===");

int n = 30;

System.out.println(n % 3 == 0 && n % 5 == 0);

// ===============================
// MAX OF THREE NUMBERS
// ===============================

System.out.println("\n=== Maximum of Three Numbers ===");

int p = 12;
int q = 45;
int r = 31;

System.out.println(Math.max(p, Math.max(q, r)));

// ===============================
// MIN OF THREE NUMBERS
// ===============================

System.out.println("\n=== Minimum of Three Numbers ===");

System.out.println(Math.min(p, Math.min(q, r)));
