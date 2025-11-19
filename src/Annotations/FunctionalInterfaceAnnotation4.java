@FunctionalInterface
interface Bird{
    public boolean fly();
    //public void eat();  only one abstract method is allowed in functional interface
}
class Eagle implements Bird{
    @Override
    public boolean fly(){
        return true;
    }
}

public class FunctionalInterfaceAnnotation4 {
    public static void main(String[] args) {
        Eagle eagle = new Eagle();
        System.out.println("Can eagle fly? " + eagle.fly());
    }  
}
