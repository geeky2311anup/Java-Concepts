import java.io.IOException;
import java.io.InterruptedIOException;

public class HandelingException9 {

    public static void main(String[] args) {

        try {
            method1(-10);
        } catch (ClassNotFoundException exceptionObj) {
            System.out.println("ClassNotFoundException handled successfully.");
        } catch (InterruptedException exceptionObj) {
            System.out.println("InterruptedException handled successfully.");
        }

        try {
            method2();
        } catch (IOException e) {
            System.out.println("IOException handled successfully.");
        }
    }

    public static void method1(int val)
            throws ClassNotFoundException, InterruptedException {

        if (val < 0) {
            throw new ClassNotFoundException();
        } else if (val == 0) {
            throw new InterruptedException();
        } else {
            System.out.println("No Exception");
        }
    }

    public static void method2() throws IOException {
        throw new IOException("Sample IO Exception");
    }

    public static void displayMessage() {
        System.out.println("Program execution completed.");
    }
}
