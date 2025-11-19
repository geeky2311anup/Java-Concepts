

public class ClassCastException2 {
    public static void main(String[] args) {
        Object obj = 0;
        System.out.println((String)obj); // This will throw ClassCastException at runtime
    }
}
