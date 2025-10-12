class A{
    public void motivation(){
        System.out.println("never give up");
    }
}
class B{
    public void motivation(){
        System.out.println("never demotivate");
    }
}
class c extends A,B{
    //give error because java does not support multiple inheritance using class
    //but support multiple inheritance using interface
}
public class MultipleInheritance{
    public static void main(String[] args){
        c obj = new c();
        obj.motivation(); //give error because of ambiguity
    }
}