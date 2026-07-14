import java.util.*;
import java.util.function.*;

// Functional interface
interface LivingThings {
    void canBreathe();
}

// 1. Using a normal class
class Carnivore implements LivingThings {
    @Override
    public void canBreathe() {
        System.out.println("Carnivore can breathe");
    }
}

// 2. Using an anonymous class
class AnonymousClassExample {
    static LivingThings herbivore = new LivingThings() {
        @Override
        public void canBreathe() {
            System.out.println("Herbivore can breathe");
        }
    };
}

// 3. Using a lambda expression
class LambdaExample {
    static LivingThings omnivore = () ->
            System.out.println("Omnivore can breathe");
}

// Custom Functional Interfaces
interface Addition {
    int add(int a, int b);
}

interface Square {
    int square(int n);
}

interface Greeting {
    String greet(String name);
}

interface EvenNumber {
    boolean isEven(int n);
}

interface Maximum {
    int max(int a, int b);
}

interface StringLength {
    int length(String str);
}

interface Message {
    void print(String msg);
}

interface RandomNumber {
    int generate();
}

interface Factorial {
    int fact(int n);
}

interface Power {
    int power(int base, int exponent);
}

public class LambdaExpression {

    public static void main(String[] args) {

        System.out.println("===== Three Ways of Implementing Functional Interface =====");

        // Normal class
        Carnivore tiger = new Carnivore();
        tiger.canBreathe();

        // Anonymous class
        AnonymousClassExample.herbivore.canBreathe();

        // Lambda expression
        LambdaExample.omnivore.canBreathe();

        System.out.println("\n===== Lambda Examples =====");

        // Addition
        Addition sum = (a, b) -> a + b;
        System.out.println("Sum = " + sum.add(10, 20));

        // Square
        Square sq = n -> n * n;
        System.out.println("Square of 5 = " + sq.square(5));

        // Greeting
        Greeting greet = name -> "Hello " + name;
        System.out.println(greet.greet("Anup"));

        // Even Number
        EvenNumber even = n -> n % 2 == 0;
        System.out.println("20 is Even : " + even.isEven(20));
        System.out.println("15 is Even : " + even.isEven(15));

        // Maximum
        Maximum maximum = (a, b) -> a > b ? a : b;
        System.out.println("Maximum = " + maximum.max(45, 70));

        // String Length
        StringLength length = str -> str.length();
        System.out.println("Length = " + length.length("Lambda Expression"));

        // Print Message
        Message message = msg -> System.out.println("Message: " + msg);
        message.print("Welcome to Java Lambda");

        // No parameter
        RandomNumber random = () -> 100;
        System.out.println("Generated Number = " + random.generate());

        // Multi-statement Lambda
        Addition multiplyThenAdd = (a, b) -> {
            int result = a * b;
            return result + 10;
        };
        System.out.println("Multiply Then Add = " + multiplyThenAdd.add(4, 5));

        // Factorial
        Factorial factorial = n -> {
            int ans = 1;
            for (int i = 1; i <= n; i++)
                ans *= i;
            return ans;
        };
        System.out.println("Factorial of 5 = " + factorial.fact(5));

        // Power
        Power power = (base, exp) -> {
            int ans = 1;
            for (int i = 0; i < exp; i++)
                ans *= base;
            return ans;
        };
        System.out.println("2^5 = " + power.power(2, 5));

        System.out.println("\n===== Thread Using Lambda =====");

        Thread t = new Thread(() ->
                System.out.println("Thread executed using Lambda"));
        t.start();

        Runnable runnable = () ->
                System.out.println("Runnable executed using Lambda");
        runnable.run();

        System.out.println("\n===== Collection and Comparator =====");

        List<String> fruits = new ArrayList<>();
        fruits.add("Mango");
        fruits.add("Apple");
        fruits.add("Orange");
        fruits.add("Banana");

        fruits.sort((a, b) -> a.compareTo(b));

        System.out.println("Sorted Fruits:");
        fruits.forEach(System.out::println);

        Comparator<Integer> comparator = (a, b) -> a - b;
        System.out.println("Compare 10 and 20 = " + comparator.compare(10, 20));

        System.out.println("\n===== Built-in Functional Interfaces =====");

        Consumer<String> consumer =
                s -> System.out.println("Consumer: " + s);
        consumer.accept("Hello Java");

        Predicate<Integer> predicate =
                n -> n > 50;
        System.out.println("75 > 50 : " + predicate.test(75));

        Function<Integer, Integer> function =
                x -> x * x;
        System.out.println("Square of 8 = " + function.apply(8));

        Supplier<String> supplier =
                () -> "Supplied Value";
        System.out.println(supplier.get());

        BinaryOperator<Integer> binaryOperator =
                (a, b) -> a + b;
        System.out.println("BinaryOperator Sum = " + binaryOperator.apply(30, 40));

        UnaryOperator<Integer> unaryOperator =
                x -> x * 10;
        System.out.println("UnaryOperator Result = " + unaryOperator.apply(9));

        System.out.println("\n===== Method Reference =====");

        fruits.forEach(System.out::println);

        System.out.println("\n===== Program Completed =====");
    }
}
