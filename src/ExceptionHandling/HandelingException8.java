public class HandelingException8 {
    public static void main(String[] args){
        try{
            method1();
        }
        catch(ClassNotFoundException exceptionObj){
            System.out.println("ClassNotFoundException handled successfully.");
        }
    }
    public static void method1() throws ClassNotFoundException{
        throw new ClassNotFoundException();// this will cause compile time error because ClassNotFoundException is a checked exception
    }
}
