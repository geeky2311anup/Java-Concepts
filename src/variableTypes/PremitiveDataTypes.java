// ===============================
// FIND MAXIMUM OF THREE NUMBERS
// ===============================

System.out.println("\n=== Maximum of Three Numbers ===");

int x = 15;
int y = 42;
int z = 27;

int maxThree = Math.max(x, Math.max(y, z));

System.out.println("Maximum = " + maxThree);


// ===============================
// FIND MINIMUM OF THREE NUMBERS
// ===============================

System.out.println("\n=== Minimum of Three Numbers ===");

int minThree = Math.min(x, Math.min(y, z));

System.out.println("Minimum = " + minThree);


// ===============================
// CHECK POSITIVE OR NEGATIVE
// ===============================

System.out.println("\n=== Positive or Negative ===");

int checkNum = -12;

if (checkNum > 0)
    System.out.println("Positive");
else if (checkNum < 0)
    System.out.println("Negative");
else
    System.out.println("Zero");


// ===============================
// SWAP TWO NUMBERS
// ===============================

System.out.println("\n=== Swap Two Numbers ===");

int first = 10;
int second = 20;

int temp = first;
first = second;
second = temp;

System.out.println("First = " + first);
System.out.println("Second = " + second);


// ===============================
// NUMBER OF DIGITS
// ===============================

System.out.println("\n=== Number of Digits ===");

int number = 58392;
int count = 0;
int copy = Math.abs(number);

while (copy > 0) {
    copy /= 10;
    count++;
}

System.out.println("Number of Digits = " + count);


// ===============================
// REVERSE A NUMBER
// ===============================

System.out.println("\n=== Reverse a Number ===");

int original = 12345;
int reverse = 0;

int tempNum = original;

while (tempNum != 0) {
    int digit = tempNum % 10;
    reverse = reverse * 10 + digit;
    tempNum /= 10;
}

System.out.println("Reverse = " + reverse);


// ===============================
// CHECK PALINDROME NUMBER
// ===============================

System.out.println("\n=== Palindrome Number ===");

int palindromeNum = 121;
int reversedNum = 0;
int originalNum = palindromeNum;

while (palindromeNum != 0) {
    int digit = palindromeNum % 10;
    reversedNum = reversedNum * 10 + digit;
    palindromeNum /= 10;
}

if (originalNum == reversedNum)
    System.out.println("Palindrome");
else
    System.out.println("Not a Palindrome");


// ===============================
// FACTORIAL OF A NUMBER
// ===============================

System.out.println("\n=== Factorial ===");

int factNum = 5;
long factorial = 1;

for (int i = 1; i <= factNum; i++) {
    factorial *= i;
}

System.out.println("Factorial = " + factorial);
