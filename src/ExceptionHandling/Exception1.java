//package ExceptionHandling;

public class Exception1 {

    public static void main(String[] args) {
        Exception1 ex = new Exception1();

        try {
            ex.method1();
        } catch (ArithmeticException e) {
            System.out.println("Caught ArithmeticException: " + e.getMessage());
        }

        ex.nullPointerDemo();
        ex.arrayIndexDemo();
        ex.numberFormatDemo();
    }

    private void method1() {
        method2();
    }

    private void method2() {
        int data = 50 / 0; // ArithmeticException
        System.out.println(data);
    }

    private void nullPointerDemo() {
        try {
            String str = null;
            System.out.println(str.length());
        } catch (NullPointerException e) {
            System.out.println("Caught NullPointerException");
        }
    }

    private void arrayIndexDemo() {
        try {
            int[] arr = {10, 20, 30};
            System.out.println(arr[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught ArrayIndexOutOfBoundsException");
        }
    }

    private void numberFormatDemo() {
        try {
            int num = Integer.parseInt("ABC");
            System.out.println(num);
        } catch (NumberFormatException e) {
            System.out.println("Caught NumberFormatException");
        }
    }
}
