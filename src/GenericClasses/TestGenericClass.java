public class TestGenericClass{
    public static void main(String[] args){
    Print obj = new Print(100);
    boolean flag = ((int)obj.value == 100); // here in generic using type casting we can pass any data type in
    //constructor but its stored in object type so while comparing we need to type cast it to original data type
    //but in generic class we dont need to type cast it to original data type, its stored in its original data type
    System.out.println(flag);
    }
}