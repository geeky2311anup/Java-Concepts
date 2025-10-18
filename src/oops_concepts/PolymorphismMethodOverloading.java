class Calculate{
    public int add(int a,int b){
        return a+b;
    }
    public int add(int a,int b,int c){
        return a+b+c;
    }
    public String add(String a,String b){
        return a+b;
    }
    public Calculate(){
    
    }
}
public class PolymorphismMethodOverloading{
    public static void main(String[] args){
        Calculate calc = new Calculate();
        System.out.println(calc.add(5, 10));
        System.out.println(calc.add(5, 10, 15));
        System.out.println(calc.add("Hello, ", "World!"));
    }
}