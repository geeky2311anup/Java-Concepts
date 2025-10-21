class Print<T>{
    T value;
    public Print(T value){
        this.value = value;
    }
    public void display(){
        System.out.println("Value: " + value);
    }
}

class ColorPrint<T> extends Print<T>{
    T childValue;
    public ColorPrint(T value,T childValue){
        super(value);
        this.childValue=childValue;
        
    }
public void displayChild(){
    System.out.println("parent value is "+value);
    System.out.println("child value is "+childValue);
}
}



public class InterfaceInGenericClass{
    public static void main(String[] args){
        Print<String> obj1 = new Print<>("this is string value directly from parent class");
        obj1.display();
        
        ColorPrint<String> childobj1 = new ColorPrint<>("this is parent value inherited in childclass","value for child class");
        System.out.println(childobj1.childValue);
        System.out.println(childobj1.value);
        childobj1.display();
       
    }
}

