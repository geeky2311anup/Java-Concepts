import java.lang.reflect.Field;
class Pet{
    public String name;
    private String food;
    public void walk(){
        System.out.println(name + " is walking");
    }
}

public class SettingValueOfPublicField{
    public static void main(String args[]) throws Exception{
        Pet pet = new Pet();
        Class petClass = Pet.class;
        Field nameField = petClass.getDeclaredField("name");
        Field foodField = petClass.getDeclaredField("food");
        nameField.set(pet, "Buddy");
        foodField.setAccessible(true); // to access private field
        foodField.set(pet, "Bone");
        System.out.println("Pet Name: " + nameField.get(pet));
        System.out.println("Pet Food: " + foodField.get(pet));
        pet.walk();
    }
}