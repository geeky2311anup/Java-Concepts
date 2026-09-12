// ===============================
// 1. EVEN OR ODD EVALUATION
// ===============================
System.out.println("\n--- Parity Check ---");

int targetValue = 18;

// Bitwise AND (& 1) returns 0 for even numbers, 1 for odd numbers
if ((targetValue & 1) == 0) {
    System.out.println("Result: Even");
} else {
    System.out.println("Result: Odd");
}


// ===============================
// 2. SUMMATION OF DIGITS
// ===============================
System.out.println("\n--- Digit Sum Computation ---");

int inputVal = 58392;
int accumulatedSum = 0;
int currentVal = Math.abs(inputVal);

while (currentVal > 0) {
    accumulatedSum += currentVal % 10;
    currentVal /= 10;
}

System.out.println("Total Digit Sum = " + accumulatedSum);


// ===============================
// 3. PRIMALITY TESTING
// ===============================
System.out.println("\n--- Primality Test ---");

int checkNumber = 29;
boolean primeFlag = checkNumber >= 2;

// Check divisibility up to the square root of checkNumber
for (int divisor = 2; divisor * divisor <= checkNumber && primeFlag; divisor++) {
    if (checkNumber % divisor == 0) {
        primeFlag = false;
    }
}

System.out.println(primeFlag ? "Status: Prime Number" : "Status: Composite Number");


// ===============================
// 4. FIBONACCI SEQUENCE GENERATION
// ===============================
System.out.println("\n--- Fibonacci Sequence ---");

int totalTerms = 10;
int firstTerm = 0;
int secondTerm = 1;

for (int termIdx = 0; termIdx < totalTerms; termIdx++) {
    System.out.print(firstTerm + (termIdx == totalTerms - 1 ? "" : " "));

    int sumNext = firstTerm + secondTerm;
    firstTerm = secondTerm;
    secondTerm = sumNext;
}
System.out.println();


// ===============================
// 5. GREATEST COMMON DIVISOR (EUCLIDEAN)
// ===============================
System.out.println("\n--- Greatest Common Divisor ---");

int valA = 48;
int valB = 18;

int tempA = valA;
int tempB = valB;

while (tempB != 0) {
    int modVal = tempA % tempB;
    tempA = tempB;
    tempB = modVal;
}

int computedGcd = tempA;
System.out.println("Calculated GCD = " + computedGcd);


// ===============================
// 6. LEAST COMMON MULTIPLE
// ===============================
System.out.println("\n--- Least Common Multiple ---");

int number1 = 12;
int number2 = 18;

int x = number1;
int y = number2;

// Euclidean algorithm to obtain GCD first
while (y != 0) {
    int mod = x % y;
    x = y;
    y = mod;
}

// Compute LCM using the formula: (|a * b|) / GCD(a, b)
int computedLcm = (x == 0) ? 0 : Math.abs(number1 * number2) / x;

System.out.println("Calculated LCM = " + computedLcm);
