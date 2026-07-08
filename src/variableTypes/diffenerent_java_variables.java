package variableTypes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JavaVariableMastery {

    /* ===========================
       STATIC VARIABLES
       =========================== */

    public static int classSharedCounter = 100;

    public static final String APPLICATION_NAME = "Variable Mastery";

    static {
        System.out.println("Static Block Executed Once");
    }

    /* ===========================
       INSTANCE VARIABLES
       =========================== */

    public String instanceStateName = "DefaultState";

    public final double PI_CONSTANT = 3.141592653589793;

    public final int uniqueInstanceId;

    // Default value examples
    int defaultInt;
    double defaultDouble;
    boolean defaultBoolean;
    String defaultString;

    // Transient variable
    transient String temporaryPassword = "12345";

    // Volatile variable
    volatile boolean isRunning = true;

    {
        System.out.println("Instance Initialization Block");
    }

    public JavaVariableMastery(int assignedId) {
        this.uniqueInstanceId = assignedId;
    }

    /* ===========================
       PARAMETER & LOCAL VARIABLES
       =========================== */

    public void executeCalculation(int inputFactor, int multiplier) {

        int computationalResult = inputFactor * multiplier;

        System.out.println("Result : " + computationalResult);
    }

    /* ===========================
       SHADOWING
       =========================== */

    public void demonstrateShadowing() {

        String instanceStateName = "Local Variable";

        System.out.println(instanceStateName);

        System.out.println(this.instanceStateName);
    }

    /* ===========================
       FINAL REFERENCE VARIABLE
       =========================== */

    public void finalReferenceExample() {

        final List<String> fruits = new ArrayList<>();

        fruits.add("Apple");
        fruits.add("Mango");
        fruits.add("Orange");

        // fruits = new ArrayList<>(); // Compile Error

        System.out.println(fruits);
    }

    /* ===========================
       LOOP VARIABLES
       =========================== */

    public void loopVariables() {

        for (int i = 1; i <= 5; i++) {
            System.out.println("Loop Variable : " + i);
        }
    }

    /* ===========================
       ENHANCED FOR LOOP
       =========================== */

    public void enhancedForLoop() {

        int[] numbers = {10, 20, 30, 40};

        for (int number : numbers) {
            System.out.println(number);
        }
    }

    /* ===========================
       EFFECTIVELY FINAL VARIABLE
       =========================== */

    public void lambdaExample() {

        int bonus = 100;

        List<Integer> list = Arrays.asList(1, 2, 3);

        list.forEach(x -> System.out.println(x + bonus));

        // bonus = 200; // Compile Error
    }

    /* ===========================
       var (Java 10+)
       =========================== */

    public void varExample() {

        var age = 25;
        var name = "Anup";
        var salary = 55000.50;

        System.out.println(age);
        System.out.println(name);
        System.out.println(salary);
    }

    /* ===========================
       DEFAULT VALUES
       =========================== */

    public void showDefaultValues() {

        System.out.println("Default int      : " + defaultInt);
        System.out.println("Default double   : " + defaultDouble);
        System.out.println("Default boolean  : " + defaultBoolean);
        System.out.println("Default String   : " + defaultString);
    }

    /* ===========================
       VARIABLE SCOPE
       =========================== */

    public void scopeExample() {

        int outer = 10;

        if (outer > 5) {
            int inner = 20;
            System.out.println("Inner : " + inner);
        }

        System.out.println("Outer : " + outer);

        // System.out.println(inner); // Compile Error
    }

    /* ===========================
       NULL REFERENCE
       =========================== */

    public void nullReferenceExample() {

        String text = null;

        System.out.println(text);

        // System.out.println(text.length()); // NullPointerException
    }

    /* ===========================
       STATIC METHOD
       =========================== */

    public static void staticMethodExample() {

        System.out.println(classSharedCounter);
        System.out.println(APPLICATION_NAME);
    }

    /* ===========================
       MAIN METHOD
       =========================== */

    public static void main(String[] args) {

        JavaVariableMastery alpha = new JavaVariableMastery(1001);
        JavaVariableMastery beta = new JavaVariableMastery(1002);

        alpha.instanceStateName = "Alpha";
        beta.instanceStateName = "Beta";

        System.out.println(alpha.instanceStateName);
        System.out.println(beta.instanceStateName);

        classSharedCounter = 500;

        System.out.println(classSharedCounter);

        System.out.println(alpha.uniqueInstanceId);
        System.out.println(beta.uniqueInstanceId);

        alpha.demonstrateShadowing();

        alpha.executeCalculation(10, 5);

        alpha.finalReferenceExample();

        alpha.loopVariables();

        alpha.enhancedForLoop();

        alpha.lambdaExample();

        alpha.varExample();

        alpha.showDefaultValues();

        alpha.scopeExample();

        alpha.nullReferenceExample();

        staticMethodExample();

        System.out.println("Transient : " + alpha.temporaryPassword);

        System.out.println("Volatile : " + alpha.isRunning);

        System.out.println(APPLICATION_NAME);

        Child child = new Child();
        child.display();
    }
}

/* ===========================================
   VARIABLE HIDING (Inheritance)
   =========================================== */

class Parent {

    int value = 100;
}

class Child extends Parent {

    int value = 200;

    void display() {

        System.out.println(value);

        System.out.println(super.value);
    }
}
