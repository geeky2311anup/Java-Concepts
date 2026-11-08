
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read dimensions of the multiplication table and target value
        int n = sc.nextInt();
        int x = sc.nextInt();

        int count = 0;

        // Iterate through all possible row indices
        for (int i = 1; i <= n; i++) {

            // For i * j = x, i must be a divisor of x
            if (x % i == 0) {

                // Find the required column index
                int j = x / i;

                // Check if the calculated column is within table boundaries
                if (j >= 1 && j <= n) {
                    count++; // Found one valid cell containing x
                }
            }
        }

        // Each valid (i, j) pair represents a separate cell
        System.out.println(count);

        sc.close();
    }
}
