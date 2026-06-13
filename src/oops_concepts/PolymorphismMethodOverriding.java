class Parent {
    // Overridable instance method
    public void show() {
        System.out.println("Parent show method");
    }

    // Static method (Subject to Method Hiding, not overriding)
    public static void staticMethod() {
        System.out.println("Static method inside Parent");
    }
}

class Child extends Parent {
    // Overriding the show method
    @Override
    public void show() {  
        System.out.println("Child show method");
    }

    // Child-specific method
    public void display() {
        System.out.println("Child specific display method");
    }

    // Hiding the parent's static method
    public static void staticMethod() {
        System.out.println("Static method inside Child");
    }
}

public class PolymorphismDemo {
    public static void main(String[] args) {
        
        // ==========================================
        // 1. UPCASTING (Runtime Polymorphism)
        // ==========================================
        Parent obj = new Child(); 
        
        // Calls Child's version because methods are resolved at RUNTIME based on the object type
        obj.show();  

        // obj.display(); 
        // ERROR: The compiler only looks at the Reference type (Parent), and display() doesn't exist there.

        
        // ==========================================
        // 2. DOWNCASTING (Accessing Child Methods)
        // ==========================================
        // To fix the error above, we safely verify the type and downcast back to Child
        if (obj instanceof Child) {
            Child castedObj = (Child) obj; 
            castedObj.display(); // Works fine now!
        }


        // ==========================================
        // 3. METHOD HIDING (Static Methods)
        // ==========================================
        // Static methods are resolved at COMPILE TIME based on the reference type
        obj.staticMethod(); // Calls Parent's static method because 'obj' is a Parent reference
        
        Child obj2 = new Child();
        obj2.staticMethod(); // Calls Child's static method
    }
}
