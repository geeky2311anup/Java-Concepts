class Print {
    Object value;

    public Object getValue() {
        return value;
    }

    public Print(Object value) {
        this.value = value;
    }
}

public class GenericUsingTypeCasting {
    public static void main(String[] args) {

        Print p1 = new Print(100);
        Print p2 = new Print("Hello World");
        Print p3 = new Print(45.67);
        Print p4 = new Print(true);

        // Type Casting
        int num = (Integer) p1.getValue();
        String str = (String) p2.getValue();
        double decimal = (Double) p3.getValue();
        boolean flag = (Boolean) p4.getValue();

        System.out.println("Integer Value : " + num);
        System.out.println("String Value  : " + str);
        System.out.println("Double Value  : " + decimal);
        System.out.println("Boolean Value : " + flag);
    }
}
