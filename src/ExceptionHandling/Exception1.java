//package ExceptionHandling;

public class Exception1 {
    public static void main(String [] args){
        Exception1 ex = new Exception1();
        ex.method1();

    }
    private void method1(){
        method2();
    }
    private void method2(){
        int data = 50/0; // Arithmetic Exception
}
}
