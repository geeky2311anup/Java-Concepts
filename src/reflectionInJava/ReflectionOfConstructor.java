import java.lang.reflect.Constructor;
class Pet{
    public String name;
    private String food;
    public Pet(String name, String food){
        this.name = name;
        this.food = food;
    }
    public void walk(){
        System.out.println(name + " is walking");
    }
}

public class ReflectionOfConstructor{
    public static void main(String args[]) throws Exception{
        Class petClass = Pet.class;
        Constructor[] constructors = petClass.getConstructors();
        for(Constructor constructor:constructors){
            System.out.println("Constructor Name: " + constructor.getName());
            System.out.println("Parameter Count: " + constructor.getParameterCount());
            System.out.println("**********");
        }
    }
}