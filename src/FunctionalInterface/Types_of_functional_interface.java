```java
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.function.Function;
import java.util.function.Predicate;

public class TypesOfFunctionalInterface {

    public static void main(String[] args) {

        // ==================================================
        // 1. CONSUMER
        // Takes input but returns nothing
        // Method: accept()
        // ==================================================

        Consumer<String> consumer = (str) -> {
            System.out.println("Input provided: " + str);
        };

        consumer.accept("Hello Consumer");


        Consumer<Integer> squarePrinter = (num) -> {
            System.out.println("Square = " + (num * num));
        };

        squarePrinter.accept(8);


        // ==================================================
        // 2. SUPPLIER
        // Takes no input but returns output
        // Method: get()
        // ==================================================

        Supplier<Double> supplier = () -> {
            return 1.234;
        };

        System.out.println("Supplier Output: " + supplier.get());


        Supplier<String> greetingSupplier = () -> {
            return "Welcome to Java Functional Interfaces";
        };

        System.out.println(greetingSupplier.get());


        // ==================================================
        // 3. FUNCTION
        // Takes input and returns output
        // Method: apply()
        // ==================================================

        Function<String, Integer> stringLength = (str) -> {
            return str.length();
        };

        System.out.println(
            "Length of input string: " + stringLength.apply("Hello Java")
        );


        Function<Integer, String> binaryConverter = (num) -> {
            return Integer.toBinaryString(num);
        };

        System.out.println(
            "Binary of 25: " + binaryConverter.apply(25)
        );


        // ==================================================
        // 4. PREDICATE
        // Takes input and returns boolean
        // Method: test()
        // ==================================================

        Predicate<Integer> isEven = (num) -> {
            return num % 2 == 0;
        };

        System.out.println(
            "Is 12345 even? " + isEven.test(12345)
        );


        Predicate<String> isNotEmpty = (str) -> {
            return !str.isEmpty();
        };

        System.out.println(
            "Is string not empty? " + isNotEmpty.test("Java")
        );
    }
}
```

### Easy way to remember

| Functional Interface | Input | Output    | Method     |
| -------------------- | ----- | --------- | ---------- |
| `Consumer<T>`        | ✅     | ❌         | `accept()` |
| `Supplier<T>`        | ❌     | ✅         | `get()`    |
| `Function<T, R>`     | ✅     | ✅         | `apply()`  |
| `Predicate<T>`       | ✅     | `boolean` | `test()`   |

### One important correction

Your custom `FunctionFunctionalInterface<R,T>` is valid, but Java's standard `Function` is written as:

```java
Function<T, R>
```

where:

* `T` = **input type**
* `R` = **return type**

For example:

```java
Function<String, Integer> length = str -> str.length();
```

means:

**String → Integer**

Similarly:

```java
Function<Integer, String> binary = num -> Integer.toBinaryString(num);
```

means:

**Integer → String**
