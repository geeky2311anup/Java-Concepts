// ===============================
// MAXIMUM OF TWO NUMBERS
// ===============================

System.out.println("\n=== Maximum of Two Numbers ===");

int a1 = 25;
int b1 = 40;

System.out.println("Maximum = " + Math.max(a1, b1));

// ===============================
// MINIMUM OF TWO NUMBERS
// ===============================

System.out.println("\n=== Minimum of Two Numbers ===");

System.out.println("Minimum = " + Math.min(a1, b1));

// ===============================
// SQUARE ROOT
// ===============================

System.out.println("\n=== Square Root ===");

int num = 64;

System.out.println("Square Root = " + Math.sqrt(num));

// ===============================
// POWER OF A NUMBER
// ===============================

System.out.println("\n=== Power of a Number ===");

System.out.println("2^5 = " + (int) Math.pow(2, 5));

// ===============================
// CUBE OF A NUMBER
// ===============================

System.out.println("\n=== Cube of a Number ===");

int cubeNum = 5;

System.out.println("Cube = " + (int) Math.pow(cubeNum, 3));

// ===============================
// ABSOLUTE VALUE
// ===============================

System.out.println("\n=== Absolute Value ===");

int negative = -35;

System.out.println("Absolute = " + Math.abs(negative));

// ===============================
// ROUND, CEIL AND FLOOR
// ===============================

System.out.println("\n=== Round, Ceil and Floor ===");

double value = 8.67;

System.out.println("Round = " + Math.round(value));
System.out.println("Ceil = " + Math.ceil(value));
System.out.println("Floor = " + Math.floor(value));

// ===============================
// CHECK EVEN OR ODD
// ===============================

System.out.println("\n=== Even or Odd ===");

int evenOdd = 18;

if (evenOdd % 2 == 0)
    System.out.println("Even");
else
    System.out.println("Odd");

// ===============================
// CHECK LEAP YEAR
// ===============================

System.out.println("\n=== Leap Year ===");

int year = 2024;

if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)
    System.out.println("Leap Year");
else
    System.out.println("Not a Leap Year");

// ===============================
// RANDOM INTEGER (0-99)
// ===============================

System.out.println("\n=== Random Integer ===");

int randomInt = (int) (Math.random() * 100);

System.out.println("Random Integer = " + randomInt);

// ===============================
// DEGREE TO RADIAN
// ===============================

System.out.println("\n=== Degree to Radian ===");

double degree = 90;

System.out.println("Radians = " + Math.toRadians(degree));

// ===============================
// RADIAN TO DEGREE
// ===============================

System.out.println("\n=== Radian to Degree ===");

double radian = Math.PI;

System.out.println("Degrees = " + Math.toDegrees(radian));

// ===============================
// SINE, COSINE AND TANGENT
// ===============================

System.out.println("\n=== Trigonometric Functions ===");

double angle = Math.toRadians(30);

System.out.println("Sin = " + Math.sin(angle));
System.out.println("Cos = " + Math.cos(angle));
System.out.println("Tan = " + Math.tan(angle));

// ===============================
// CHECK PRIME NUMBER
// ===============================

System.out.println("\n=== Prime Number Check ===");

int prime = 29;
boolean isPrime = true;

if (prime <= 1)
    isPrime = false;
else {
    for (int i = 2; i <= Math.sqrt(prime); i++) {
        if (prime % i == 0) {
            isPrime = false;
            break;
        }
    }
}

System.out.println(isPrime);
