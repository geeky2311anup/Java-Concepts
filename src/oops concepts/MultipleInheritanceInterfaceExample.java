interface A{
    public void swim();
}
interface B{
    public void fly();
}
class C implements A,B{
    public void swim(){
        System.out.println("swimming");
    }
    public void fly(){
        System.out.println("flying");
    }
}
public class MultipleInheritanceInterfaceExample{
    public static void main(String[] args){
        C obj = new C();
        obj.fly();
        obj.swim();
    }
}
