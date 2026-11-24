
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        int pivot = s.indexOf('^');

        long leftTorque = 0;
        long rightTorque = 0;

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            // Ignore empty positions and the pivot
            if (ch == '=' || ch == '^') {
                continue;
            }

            int weight = ch - '0';
            int distance = Math.abs(i - pivot);

            long torque = (long) weight * distance;

            if (i < pivot) {
                leftTorque += torque;
            } else {
                rightTorque += torque;
            }
        }

        if (leftTorque > rightTorque) {
            System.out.println("left");
        } 
        else if (rightTorque > leftTorque) {
            System.out.println("right");
        } 
        else {
            System.out.println("balance");
        }
    }
}
