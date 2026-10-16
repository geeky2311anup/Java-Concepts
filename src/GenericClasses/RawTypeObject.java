class Animal<T>{
    T type;
    public void setType(T type){
        this.type = type;
    }
}

public class RawTypeObject{
    public static void main(String[] args){
        Animal<String> dog = new Animal<>();//generic object
        dog.setType("lebrador");
        System.out.println(dog.type);
        Animal BigCat = new Animal();//its raw type object because we have not specified any data type
        BigCat.setType("Tiger");
        System.out.println(BigCat.type);
    }
}

class Animal<T> {
    T type;

    // Constructor
    public Animal() {
    }

    // Setter
    public void setType(T type) {
        this.type = type;
    }

    // Getter
    public T getType() {
        return type;
    }

    // Display information
    public void display() {
        System.out.println("Animal type: " + type);

        if (type != null) {
            System.out.println(
                "Data type: " + type.getClass().getSimpleName()
            );
        }
    }
}

public class RawTypeObject {
    public static void main(String[] args) {

        // 1. Generic object using String
        System.out.println("===== Generic Object: String =====");

        Animal<String> dog = new Animal<>();
        dog.setType("Labrador");

        String dogType = dog.getType();
        System.out.println("Dog: " + dogType);
        dog.display();

        // dog.setType(100); // Compile-time error

        System.out.println();

        // 2. Generic object using Integer
        System.out.println("===== Generic Object: Integer =====");

        Animal<Integer> cat = new Animal<>();
        cat.setType(10);

        Integer catType = cat.getType();
        System.out.println("Cat value: " + catType);
        cat.display();

        System.out.println();

        // 3. Generic object using Double
        System.out.println("===== Generic Object: Double =====");

        Animal<Double> dolphin = new Animal<>();
        dolphin.setType(25.5);

        System.out.println("Dolphin value: " + dolphin.getType());
        dolphin.display();

        System.out.println();

        // 4. Raw type object
        System.out.println("===== Raw Type Object =====");

        Animal bigCat = new Animal();
        bigCat.setType("Tiger");

        Object tigerType = bigCat.getType();
        System.out.println("Big cat: " + tigerType);
        bigCat.display();

        // Raw types bypass generic type checking.
        bigCat.setType(100);

        System.out.println("Updated big cat: " + bigCat.getType());
        bigCat.display();

        System.out.println();

        // 5. Runtime type-casting problem
        System.out.println("===== Runtime Type Safety =====");

        Animal rawAnimal = new Animal();
        rawAnimal.setType(123);

        try {
            // Compiles with a warning but fails at runtime.
            String value = (String) rawAnimal.getType();
            System.out.println(value);
        } catch (ClassCastException e) {
            System.out.println("Exception: " + e);
        }

        System.out.println();

        // 6. Generic type safety
        System.out.println("===== Generic Type Safety =====");

        Animal<String> lion = new Animal<>();
        lion.setType("Lion");

        String lionType = lion.getType();
        System.out.println("Lion: " + lionType);

        // lion.setType(123); // Compile-time error

        System.out.println("Generics prevent incompatible values.");
    }
}
