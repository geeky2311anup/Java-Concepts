//HERE are the different types of variables in Java
public class diffenerent_java_variables {
    // Instance variable
    int instanceVar;

    // Static variable
    static int staticVar;

    // Local variable
    public void method() {
        int localVar = 5;
    }

    // Final variable
    final int finalVar = 10;
    public static void main(String[] args) {
        diffenerent_java_variables obj = new diffenerent_java_variables();
        obj.instanceVar = 1;
        System.out.println("Instance Variable: " + obj.instanceVar);

        diffenerent_java_variables.staticVar = 2;
        System.out.println("Static Variable: " + diffenerent_java_variables.staticVar);

        // Local variable
        obj.method();
        // System.out.println("Local Variable: " + localVar); // This will cause an error

        System.out.println("Final Variable: " + obj.finalVar);
    }   