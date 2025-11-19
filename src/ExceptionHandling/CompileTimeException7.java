// compiletime exceptions are checked exceptions that are checked at compile time by the compiler.
// if not handled properly, the code will not compile.
public class CompileTimeException7 {
    public static void main(String[] args) {
        method1();
    }
    public static void method1() throws ClassNotFoundException {
        throw new ClassNotFoundException();// this will cause compile time error because ClassNotFoundException is a checked exception  
    }
    
}
