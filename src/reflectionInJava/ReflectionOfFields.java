import java.lang.reflect.Field;
class Pet{
    public String name;
    public void walk(){
        System.out.println("Pet is walking");
    }
}

public class ReflectionOfFields{
    public static void main(String args[]) throws Exception{
        Class petClass = Pet.class;
        Field[] fields = petClass.getFields();// to get all public fields including inherited
        // if you want private fields also you will need to use getDeclaredFields()
        for(Field field:fields){
            System.out.println("Field Name: "+field.getName());
            System.out.println("Field Type: "+field.getType());
            System.out.println("**********");   
        }
    }
}