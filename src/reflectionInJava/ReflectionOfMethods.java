import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

class Eagle {
    public String breed = "Golden Eagle";
    private boolean canSwim = false;

    public void fly() {
        System.out.println("It can fly");
    }

    public void eat() {
        System.out.println("Eating...");
    }

    private Integer legs() {
        return 2;
    }

    private void secret() {
        System.out.println("Private Method Invoked");
    }
}

public class ReflectionOfMethods {
    public static void main(String[] args) throws Exception {

        Class<Eagle> eagleClass = Eagle.class;

        System.out.println("========== Public Methods ==========");
        Method[] methods = eagleClass.getMethods();

        for (Method method : methods) {
            System.out.println("Name       : " + method.getName());
            System.out.println("ReturnType : " + method.getReturnType().getSimpleName());
            System.out.println("Class      : " + method.getDeclaringClass().getSimpleName());
            System.out.println("Modifier   : " + Modifier.toString(method.getModifiers()));
            System.out.println("------------------------------");
        }

        System.out.println("\n========== Declared Methods ==========");
        Method[] declaredMethods = eagleClass.getDeclaredMethods();

        for (Method method : declaredMethods) {
            System.out.println(method.getName());
        }

        System.out.println("\n========== Public Fields ==========");
        Field[] fields = eagleClass.getFields();

        for (Field field : fields) {
            System.out.println(field.getName());
            System.out.println(field.getType().getSimpleName());
            System.out.println("------------------------------");
        }

        System.out.println("\n========== Declared Fields ==========");
        Field[] declaredFields = eagleClass.getDeclaredFields();

        for (Field field : declaredFields) {
            System.out.println(field.getName());
            System.out.println(field.getType().getSimpleName());
            System.out.println("Modifier : " + Modifier.toString(field.getModifiers()));
            System.out.println("------------------------------");
        }

        Eagle eagle = new Eagle();

        System.out.println("\n========== Invoke Private Method ==========");
        Method privateMethod = eagleClass.getDeclaredMethod("secret");
        privateMethod.setAccessible(true);
        privateMethod.invoke(eagle);

        Method legsMethod = eagleClass.getDeclaredMethod("legs");
        legsMethod.setAccessible(true);
        int legs = (Integer) legsMethod.invoke(eagle);
        System.out.println("Legs = " + legs);

        System.out.println("\n========== Access Private Field ==========");
        Field swimField = eagleClass.getDeclaredField("canSwim");
        swimField.setAccessible(true);

        System.out.println("Before : " + swimField.getBoolean(eagle));

        swimField.setBoolean(eagle, true);

        System.out.println("After  : " + swimField.getBoolean(eagle));

        System.out.println("\n========== Access Public Field ==========");
        Field breedField = eagleClass.getField("breed");
        System.out.println("Breed : " + breedField.get(eagle));

        breedField.set(eagle, "Bald Eagle");
        System.out.println("Updated Breed : " + breedField.get(eagle));
    }
}
