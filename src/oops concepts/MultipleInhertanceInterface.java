This is an excellent, comprehensive cheat sheet on Java interfaces! It covers a massive amount of ground from foundational syntax to modern features like Sealed Interfaces and Records.

To make this documentation truly complete for advanced usage and technical interviews, we need to inject the missing advanced paradigms, edge-case design patterns, and JVM level behaviors.

Here is the structured continuation to append directly to your notes.

---

```java
========================================
PRIVATE INTERFACE METHODS (JAVA 9)
========================================

Interfaces can contain private and private static 
methods to prevent code duplication across multiple 
default or static methods.

interface DatabaseConnector {

    default void connectMySql() {
        logConnection("MySQL");
        // Connection logic
    }

    default void connectPostgres() {
        logConnection("PostgreSQL");
        // Connection logic
    }

    // Helper method hidden from implementing classes
    private void logConnection(String dbType) {
        System.out.println("Initiating connection to " + dbType);
    }
}

Purpose: 
Encapsulates shared logic within the interface without 
exposing it as part of the public API.

========================================
FUNCTIONAL INTERFACE INHERITANCE RULES
========================================

An interface is still a Functional Interface if it 
overrides methods from java.lang.Object. These do 
not count toward the single abstract method (SAM) limit.

@FunctionalInterface
interface SmartTransformer {
    void transform(); // The single abstract method (SAM)

    // Overriding Object methods does NOT break @FunctionalInterface
    @Override
    boolean equals(Object obj); 
    
    @Override
    String toString();
}

Rule: 
Abstract methods that match public methods in java.lang.Object 
are ignored by the functional interface validation compiler check.

========================================
THE EVOLUTION OF INTERFACE METADATA
========================================

How Java handles interfaces behind the scenes has changed 
drastically to preserve backward binary compatibility.

Prior to Java 8:
Interfaces were pure structural blueprints. Compiling an 
interface generated only abstract class definitions in the 
bytecode.

Java 8 and Beyond:
To support `default` and `static` methods without breaking 
older compiled JARs, the JVM introduced a special bytecode 
instruction: `invokevirtual` for instance methods was 
complemented with optimizations to look up default implementations 
inside interface tables (ITables) at runtime.

========================================
INTERFACES AND THE DIAMOND PROBLEM (PART II)
========================================

What happens if a class inherits conflicting signatures 
from BOTH an Abstract Class and an Interface?

interface Walkable {
    default void move() {
        System.out.println("Walking...");
    }
}

abstract class Robot {
    public void move() {
        System.out.println("Robot rolling...");
    }
}

class Android extends Robot implements Walkable {
    // No compile error! 
}

Rule: "Class Wins" Rule
In Java, class implementations always take precedence over 
interface default methods. An explicit override in `Android` 
is not required here; calling `new Android().move()` outputs 
"Robot rolling...".

========================================
SPI (SERVICE PROVIDER INTERFACE) PATTERN
========================================

Interfaces act as decoupling boundaries for pluggable 
architectures using Java's built-in `ServiceLoader`.

1. Define Interface (In a core library)
package com.api;
public interface PaymentGateway {
    void process(double amount);
}

2. Implement Interface (In an external plugin JAR)
package com.provider;
public class PayPalGateway implements com.api.PaymentGateway {
    public void process(double amount) { /* PayPal logic */ }
}

3. Consumer discovers implementations dynamically:
ServiceLoader<PaymentGateway> loader = ServiceLoader.load(PaymentGateway.class);
for (PaymentGateway gateway : loader) {
    gateway.process(100.0); // Automatically picks up PayPalGateway
}

Real-World Usage:
How `java.sql.Driver` discovers JDBC drivers (MySQL, PostgreSQL) 
automatically without explicit imports.

========================================
COMPOSITE FUNCTIONAL INTERFACES
========================================

Built-in functional interfaces can be chained together using 
default tracking methods like `andThen()`, `compose()`, and `and()`.

1. Predicate Chaining (Logical AND)
Predicate<String> isLong = s -> s.length() > 5;
Predicate<String> containsA = s -> s.contains("a");
Predicate<String> combined = isLong.and(containsA);

2. Function Chaining (Mathematical Composition)
Function<Integer, Integer> multiply = x -> x * 2;
Function<Integer, Integer> square = x -> x * x;

// multiply first, then square: (5 * 2)^2 = 100
Function<Integer, Integer> pipeline = multiply.andThen(square); 

// square first, then multiply: (5^2) * 2 = 50
Function<Integer, Integer> inversePipeline = multiply.compose(square); 

========================================
FUNCTIONAL INTERFACING PRIMITIVE SPECIALIZATIONS
========================================

Standard functional interfaces like `Function<T, R>` handle objects. 
Using them with primitives causes severe performance loss due to 
auto-boxing and unboxing (`int` <-> `Integer`).

Bad (High Memory/CPU Overhead):
Function<Integer, Integer> doubleIt = x -> x * 2; // Boxes every value

Good (High Performance Primitive Specialized):
IntUnaryOperator doubleItPrimitive = x -> x * 2; // No boxing occurs

Key Primitive Counterparts:
-------------------------------------------------------
Standard Type       Primitive Equivalent
-------------------------------------------------------
Predicate<T>        IntPredicate, LongPredicate, DoublePredicate
Consumer<T>         IntConsumer, LongConsumer, DoubleConsumer
Supplier<T>         IntSupplier, LongSupplier, DoubleSupplier
Function<T, R>      IntFunction<R>, ToIntFunction<T>, IntToLongFunction

```
