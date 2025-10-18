class Print<T>{
    T value;
    public Print(T value){
        this.value = value;
    }
    public void display(){
        System.out.println("Value: " + value);
    }
}
class ColorPrint extends Print<String>{
    public String color;
    public ColorPrint(String value, String color){
        super(value);//calling parent class constructor and passing value to it no need to use this.value=value;
        this.color = color;
    }
    public void displayColor(){
        System.out.println("Value: " + value + ", Color: " + color);
    }   
}
public class InheritanceInNonGenericSubclass{
    public static void main(String[] args){
        ColorPrint cp = new ColorPrint("Hello", "Red");
        cp.display(); // From parent generic class
        cp.displayColor(); // From child non-generic subclass
    }
}   