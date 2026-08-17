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

    public void showDetails() {
        System.out.println("Name : " + name);
        System.out.println("Food : " + food);
    }
}

public class ReflectionOfConstructor {

    public static void main(String[] args) throws Exception {

        Class<?> petClass = Pet.class;

        System.out.println("Class Name : " + petClass.getName());
        System.out.println("Class Type : " + petClass.getSimpleName());

        // Get all constructors including private constructors
        Constructor<?>[] constructors =
                petClass.getDeclaredConstructors();

        System.out.println("\n===== Constructor Information =====");

        for (Constructor<?> constructor : constructors) {

            System.out.println("Constructor Name : "
                    + constructor.getName());

            System.out.println("Parameter Count  : "
                    + constructor.getParameterCount());

            System.out.print("Parameter Types  : ");

            Class<?>[] parameters =
                    constructor.getParameterTypes();

            if (parameters.length == 0) {
                System.out.print("None");
            } else {
                for (Class<?> type : parameters) {
                    System.out.print(type.getSimpleName() + " ");
                }
            }

            System.out.println();

            System.out.println("Modifier         : "
                    + Modifier.toString(
                            constructor.getModifiers()));

            System.out.println("--------------------------------");
        }

        // Create object using a public constructor
        System.out.println("\n===== Public Constructor =====");

        Constructor<?> publicConstructor =
                petClass.getConstructor(
                        String.class,
                        String.class);

        Pet pet1 = (Pet) publicConstructor.newInstance(
                "Tom", "Fish");

        pet1.walk();
        pet1.showDetails();

        // Create object using the default constructor
        System.out.println("\n===== Default Constructor =====");

        Constructor<?> defaultConstructor =
                petClass.getConstructor();

        Pet pet3 = (Pet) defaultConstructor.newInstance();

        pet3.walk();
        pet3.showDetails();

        // Access private constructor
        System.out.println("\n===== Private Constructor =====");

        Constructor<?> privateConstructor =
                petClass.getDeclaredConstructor(int.class);

        privateConstructor.setAccessible(true);

        Pet pet2 = (Pet) privateConstructor.newInstance(101);

        pet2.walk();
        pet2.showDetails();
    }
}
