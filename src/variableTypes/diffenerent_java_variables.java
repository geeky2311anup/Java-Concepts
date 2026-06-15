package variableTypes;

import java.util.Arrays;

/**
 * A comprehensive demonstration of all variable classifications in Java,
 * illustrating scopes, mutation boundaries, and memory behaviors.
 */
public class JavaVariableMastery {

    // 1. STATIC (CLASS) VARIABLE
    // Stored in the Metaspace (Method Area). Shared by all class instances.
    public static int classSharedCounter = 100;

    // 2. INSTANCE VARIABLE
    // Stored on the Heap inside the object. Unique to each object instance.
    public String instanceStateName = "DefaultState";

    // 3. COMPILE-TIME FINAL VARIABLE
    // Must be initialized immediately. Value is substituted directly at compile time.
    public final double PI_CONSTANT = 3.141592653589793;

    // 4. BLANK FINAL VARIABLE (Blank Constant)
    // Initialized exactly once inside constructors. Allows instance-specific constants.
    public final int uniqueInstanceId;

    // Constructor to bind the blank final variable safely
    public JavaVariableMastery(int assignedId) {
        this.uniqueInstanceId = assignedId; // Allowed exactly once
    }

    // 5. PARAMETER VARIABLE
    // Variables passed into a method signature. Scoped strictly inside this execution block.
    public void executeCalculation(int inputFactor, int multiplier) {
        
        // 6. LOCAL VARIABLE
        // Stored on the Thread Stack. Allocated upon method entry, destroyed upon exit.
        int computationalResult = inputFactor * multiplier;
        
        System.out.println("Processing local variables: " + computationalResult);
    }

    public void demonstrateShadowing() {
        // Local variable name shadowing an instance variable name
        String instanceStateName = "LocalOverride";
        
        System.out.println("Shadowed Name (Local Context): " + instanceStateName);
        System.out.println("Actual Instance Variable (via 'this'): " + this.instanceStateName);
    }

    public static void main(String[] args) {
        // Initialize two separate objects to monitor memory isolation
        JavaVariableMastery workerAlpha = new JavaVariableMastery(1001);
        JavaVariableMastery workerBeta = new JavaVariableMastery(1002);

        System.out.println("=== 1. Instance vs Class Variables ===");
        workerAlpha.instanceStateName = "AlphaActive";
        workerBeta.instanceStateName = "BetaActive";
        
        // Notice mutating workerAlpha does NOT touch workerBeta
        System.out.println("Alpha Instance Variable: " + workerAlpha.instanceStateName);
        System.out.println("Beta Instance Variable: " + workerBeta.instanceStateName);

        // Class variables are shared universally across all references
        JavaVariableMastery.classSharedCounter = 500;
        System.out.println("Class Variable accessed via Class Name: " + JavaVariableMastery.classSharedCounter);

        System.out.println("\n=== 2. Blank Final Constraints ===");
        System.out.println("Worker Alpha ID (Constant): " + workerAlpha.uniqueInstanceId);
        System.out.println("Worker Beta ID (Constant): " + workerBeta.uniqueInstanceId);
        // workerAlpha.uniqueInstanceId = 9999; // COMPILE ERROR: Cannot reassign final variable

        System.out.println("\n=== 3. Name Shadowing Mechanics ===");
        workerAlpha.demonstrateShadowing();

        System.out.println("\n=== 4. Parameter Execution ===");
        workerAlpha.executeCalculation(10, 5);
    }
}
