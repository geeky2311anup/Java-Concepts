import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

class Pet {
    public String name;
    private String food;

    public Pet() {
        this.name = "Unknown";
        this.food = "None";
    }

    public Pet(String name) {
        this.name = name;
        this.food = "Milk";
    }

    public Pet(String name, String food) {
        this.name = name;
        this.food = food;
    }

    private Pet(int id) {
        this.name = "Pet-" + id;
        this.food = "Special Food";
    }

    public void walk() {
        System.out.println(name + " is walking");
    }
}

public class ReflectionOfConstructor {

    public static void main(String[] args) throws Exception {

        Class<?> petClass = Pet.class;

        // Display all constructors
        Constructor<?>[] constructors = petClass.getDeclaredConstructors();

        System.out.println("===== Constructor Information =====");

        for (Constructor<?> constructor : constructors) {

            System.out.println("Constructor Name : " + constructor.getName());

            System.out.println("Parameter Count  : " + constructor.getParameterCount());

            System.out.print("Parameter Types  : ");
            Class<?>[] parameters = constructor.getParameterTypes();

            if (parameters.length == 0) {
                System.out.print("None");
            } else {
                for (Class<?> p : parameters) {
                    System.out.print(p.getSimpleName() + " ");
                }
            }

            System.out.println();

            System.out.println("Modifier         : "
                    + Modifier.toString(constructor.getModifiers()));

            System.out.println("--------------------------------");
        }

        // Creating object using public constructor
        System.out.println("\n===== Creating Object Using Reflection =====");

        Constructor<?> publicConstructor =
                petClass.getConstructor(String.class, String.class);

        Pet pet1 = (Pet) publicConstructor.newInstance("Tom", "Fish");

        pet1.walk();

        // Creating object using private constructor
        System.out.println("\n===== Accessing Private Constructor =====");

        Constructor<?> privateConstructor =
                petClass.getDeclaredConstructor(int.class);

        privateConstructor.setAccessible(true);

        Pet pet2 = (Pet) privateConstructor.newInstance(101);

        pet2.walk();
    }
}
