// Three ways of implementing a functional interface

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

    static LivingThings HerbivoreObject = new LivingThings() {
        @Override
        public void canBreathe() {
            System.out.println("Herbivore can breathe");
        }
    };
}

// 3. Using a lambda expression
class LambdaExpressionExample {

    static LivingThings OmnivoreObject = () -> {
        System.out.println("Omnivore can breathe");
    };
}

// Functional interface with parameters
interface Addition {
    int add(int a, int b);
}

// Functional interface with one parameter
interface Square {
    int square(int n);
}

// Functional interface returning String
interface Greeting {
    String greet(String name);
}

public class LambdaExpression {

    public static void main(String[] args) {

        // 1. Using a normal class
        Carnivore tiger = new Carnivore();
        tiger.canBreathe();

        // 2. Using an anonymous class
        AnonymousClassExample.HerbivoreObject.canBreathe();

        // 3. Using a lambda expression
        LambdaExpressionExample.OmnivoreObject.canBreathe();

        // Lambda with parameters
        Addition sum = (a, b) -> a + b;
        System.out.println("Sum = " + sum.add(10, 20));

        // Lambda with one parameter
        Square sq = n -> n * n;
        System.out.println("Square of 5 = " + sq.square(5));

        // Lambda returning String
        Greeting greeting = name -> "Hello " + name;
        System.out.println(greeting.greet("Anup"));

        // Lambda with multiple statements
        Addition multiplyThenAdd = (a, b) -> {
            int result = a * b;
            return result + 10;
        };
        System.out.println(
            "Multiply then add result = "
            + multiplyThenAdd.add(4, 5)
        );

        // Thread using lambda
        Thread t = new Thread(() ->
            System.out.println("Thread executed using lambda")
        );
        t.start();
    }
}
