import java.lang.reflect.*;

class Pet {
    public String name = "Tom";
    private int age = 5;

    public Pet() {}

    public Pet(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void walk() {
        System.out.println("Pet is walking");
    }

    private void sleep() {
        System.out.println("Pet is sleeping");
    }
}

public class ReflectionDemo {
    public static void main(String[] args) throws Exception {

        Class<?> petClass = Pet.class;

        System.out.println("=== PUBLIC FIELDS ===");
        Field[] publicFields = petClass.getFields();
        for (Field field : publicFields) {
            System.out.println("Name : " + field.getName());
            System.out.println("Type : " + field.getType().getSimpleName());
            System.out.println("--------------------");
        }

        System.out.println("\n=== ALL DECLARED FIELDS ===");
        Field[] declaredFields = petClass.getDeclaredFields();
        for (Field field : declaredFields) {
            System.out.println("Name : " + field.getName());
            System.out.println("Type : " + field.getType().getSimpleName());
            System.out.println("Modifiers : " +
                    Modifier.toString(field.getModifiers()));
            System.out.println("--------------------");
        }

        System.out.println("\n=== CONSTRUCTORS ===");
        Constructor<?>[] constructors = petClass.getDeclaredConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor);
        }

        System.out.println("\n=== METHODS ===");
        Method[] methods = petClass.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println("Method : " + method.getName());
            System.out.println("Return Type : " +
                    method.getReturnType().getSimpleName());
            System.out.println("--------------------");
        }

        System.out.println("\n=== ACCESSING PRIVATE FIELD ===");
        Pet pet = new Pet();

        Field ageField = petClass.getDeclaredField("age");
        ageField.setAccessible(true);

        System.out.println("Original Age: " + ageField.get(pet));

        ageField.set(pet, 10);
        System.out.println("Updated Age: " + ageField.get(pet));

        System.out.println("\n=== INVOKING PRIVATE METHOD ===");
        Method sleepMethod = petClass.getDeclaredMethod("sleep");
        sleepMethod.setAccessible(true);
        sleepMethod.invoke(pet);
    }
}
