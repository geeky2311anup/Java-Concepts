/*
 * Chat Data: Super Keyword and Constructors in Java
 * 
 * Question: 
 * - Is super a constructor?
 * - If this.value can store value1 in parent's value then why we need super?
 * 
 * Answer:
 */

// Example 1: Is super a constructor?
// NO! super is NOT a constructor. It's a KEYWORD that:
// - super() = Calls the parent class constructor
// - super.field = Accesses parent class field  
// - super.method() = Calls parent class method
// - super is always used within child constructor or method

class Parent {
    String name;
    public Parent(String name) {
        this.name = name;
    }
}

class Child extends Parent {
    public Child(String value1) {
        super(value1);  // ← This CALLS parent's constructor
        // super itself is not a constructor!
    }
}

// Example 2: Why do we need super() if this.value can store values?

// Scenario 1: Parent HAS a constructor
class BankAccount {
    String value;
    
    public BankAccount(String value) {  // Parent REQUIRES a parameter
        this.value = value;
        System.out.println("Parent initialized with: " + value);
    }
}

class SavingsAccount extends BankAccount {
    public SavingsAccount(String value1) {
        super(value1);  // ← REQUIRED! Must call parent constructor first
        // this.value = value1;  // ← This alone won't work without super()!
        
        // If you remove super(value1), you get compilation error:
        // "constructor BankAccount cannot be applied to given types"
    }
}

// Scenario 2: Parent has NO constructor (default)
class SimpleParent {
    String value;  // No constructor = Java provides default constructor
}

class SimpleChild extends SimpleParent {
    public SimpleChild(String value1) {
        // super(); is called automatically (default constructor)
        this.value = value1;  // ✅ This works!
    }
}

// Key Differences Summary:
/*
 * Parent Class Type          | Need explicit super()? | Reason
 * ========================== | ===================== | ==============================
 * No constructor            | ❌ No                 | Default constructor exists
 * Has constructor w/ params | ✅ Yes                | Must call correct constructor
 * Has no-argument constructor| ❌ No                 | super() called automatically
 */

// Real-world example demonstrating the necessity of super()
class Vehicle {
    private String brand;
    private int year;
    
    public Vehicle(String brand, int year) {  // Requires parameters!
        this.brand = brand;
        this.year = year;
        System.out.println("Vehicle created: " + brand + " (" + year + ")");
    }
    
    public void displayInfo() {
        System.out.println("Brand: " + brand + ", Year: " + year);
    }
}

class Car extends Vehicle {
    private int doors;
    
    public Car(String brandName, int manufacturingYear, int numberOfDoors) {
        super(brandName, manufacturingYear);  // ✅ MUST call parent constructor!
        this.doors = numberOfDoors;
        
        // Without super(), this would fail because:
        // 1. Java automatically tries to call super() with no arguments
        // 2. But Vehicle class doesn't have a no-argument constructor
        // 3. Compilation error occurs before this.doors assignment
    }
    
    public void displayCarInfo() {
        super.displayInfo();  // Call parent method
        System.out.println("Doors: " + doors);
    }
}

// Example showing WHERE super() is called
class DemoParent {
    public DemoParent() {
        System.out.println("1. Parent constructor executing");
    }
}

class DemoChild extends DemoParent {
    public DemoChild() {
        // super(); ← Java automatically puts this HERE as FIRST line!
        System.out.println("2. Child constructor executing");
    }
}

public class SuperKeywordExamples {
    public static void main(String[] args) {
        System.out.println("=== Car Example ===");
        Car myCar = new Car("Toyota", 2023, 4);
        myCar.displayCarInfo();
        
        System.out.println("\n=== Demo Example ===");
        DemoChild demo = new DemoChild();
        
        // Output shows super() is called INSIDE child constructor:
        // 1. Parent constructor executing
        // 2. Child constructor executing
    }
}

/*
 * Summary:
 * 
 * 1. super() is NOT a constructor - it's a keyword that CALLS constructors
 * 
 * 2. super() ensures proper object initialization chain:
 *    - Parent object must be properly initialized before child
 *    - If parent has parameterized constructor, super(args) is mandatory
 *    - this.field = value only assigns to fields, doesn't initialize parent
 * 
 * 3. Constructor execution order:
 *    - super() call (must be first line)
 *    - Parent constructor executes completely
 *    - Then child constructor continues
 * 
 * 4. When parent has parameterized constructor, super() with arguments is 
 *    mandatory because Java can't automatically call it with no arguments!
 */
