// ===============================
// CHECK EVEN OR ODD
// ===============================

System.out.println("\n=== Even or Odd ===");

int evenOddNum = 18;

if (evenOddNum % 2 == 0)
    System.out.println("Even");
else
    System.out.println("Odd");


// ===============================
// SUM OF DIGITS
// ===============================

System.out.println("\n=== Sum of Digits ===");

int digitNumber = 58392;
int digitSum = 0;
int tempValue = Math.abs(digitNumber);

while (tempValue > 0) {
    digitSum += tempValue % 10;
    tempValue /= 10;
}

System.out.println("Sum of Digits = " + digitSum);


// ===============================
// CHECK PRIME NUMBER
// ===============================

System.out.println("\n=== Prime Number ===");

int primeNum = 29;
boolean isPrime = true;

if (primeNum < 2)
    isPrime = false;
else {
    for (int i = 2; i * i <= primeNum; i++) {
        if (primeNum % i == 0) {
            isPrime = false;
            break;
        }
    }
}

if (isPrime)
    System.out.println("Prime");
else
    System.out.println("Not Prime");


// ===============================
// FIBONACCI SERIES
// ===============================

System.out.println("\n=== Fibonacci Series ===");

int terms = 10;
int a = 0;
int b = 1;

for (int i = 1; i <= terms; i++) {
    System.out.print(a + " ");

    int next = a + b;
    a = b;
    b = next;
}

System.out.println();


// ===============================
// GREATEST COMMON DIVISOR
// ===============================

System.out.println("\n=== GCD ===");

int num1 = 48;
int num2 = 18;

int a1 = num1;
int b1 = num2;

while (b1 != 0) {
    int remainder = a1 % b1;
    a1 = b1;
    b1 = remainder;
}

System.out.println("GCD = " + a1);


// ===============================
// LEAST COMMON MULTIPLE
// ===============================

System.out.println("\n=== LCM ===");

int p = 12;
int q = 18;

int pCopy = p;
int qCopy = q;

while (qCopy != 0) {
    int rem = pCopy % qCopy;
    pCopy = qCopy;
    qCopy = rem;
}

int gcd = pCopy;
int lcm = Math.abs(p * q) / gcd;

System.out.println("LCM = " + lcm);
