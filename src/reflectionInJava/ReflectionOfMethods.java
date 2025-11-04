import java.lang.reflect.Method;

class Eagle{
    public String breed;
    private boolean canSwim;
    public void fly(){
        System.out.println("it can fly");
    }
    private Integer legs(){
        return 2;
    }
}
public class ReflectionOfMethods{
    public static void main(String args[]){
           Class<Eagle> EagleClass = Eagle.class;
           Method[] methods = EagleClass.getMethods(); // All public methods including inherited
           // if you want private methods also you will need to use getDeclaredMethods()
           for(Method method : methods){
            System.out.println(method.getName());
            System.out.println(method.getReturnType());
            System.out.println(method.getDeclaringClass());
            System.out.println("*********");
            
           }
           

    }
}