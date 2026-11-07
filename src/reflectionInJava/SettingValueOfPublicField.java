
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read table size and target number
        int n = sc.nextInt();
        int x = sc.nextInt();

        int count = 0;

        // Check every possible row
        for (int i = 1; i <= n; i++) {

            // Check whether x is divisible by the current row
            if (x % i == 0) {

                // Calculate the corresponding column
                int j = x / i;

                // Ensure the column lies within the table
                if (j >= 1 && j <= n) {
                    count++;
                }
            }
        }

        // Print total occurrences of x
        System.out.println(count);

        sc.close();
    }
}
