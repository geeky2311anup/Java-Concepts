// Reflection in Java
// To get a particular Class object, there are three ways:
// 1. Using Class.forName()
// 2. Using .class syntax
// 3. Using getClass()

import java.lang.reflect.Modifier;

final class Eagle {
    public String breed;
    private boolean canSwim;

    public void fly() {
        System.out.println("Eagle is flying");
    }
}

public class Reflection {
    public static void main(String[] args) {

        // Get the Class object
        Class<?> eagleClass = Eagle.class;

        // Basic information
        System.out.println("Class Name      : " + eagleClass.getName());
        System.out.println("Simple Name     : " + eagleClass.getSimpleName());
        System.out.println("Package Name    : " + eagleClass.getPackageName());
        System.out.println("Modifiers       : " + Modifier.toString(eagleClass.getModifiers()));

        // Print declared fields
        System.out.println("\nFields:");
        var fields = eagleClass.getDeclaredFields();
        for (var field : fields) {
            System.out.println(field.getName() + " : " + field.getType().getSimpleName());
        }

        // Print declared methods
        System.out.println("\nMethods:");
        var methods = eagleClass.getDeclaredMethods();
        for (var method : methods) {
            System.out.println(method.getName());
        }
    }
}
