
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read the size of the multiplication table and target number
        int n = sc.nextInt();
        int x = sc.nextInt();

        int count = 0;

        // Check every row to find cells containing x
        for (int i = 1; i <= n; i++) {

            // A valid pair must satisfy i * j = x
            // Therefore, x must be divisible by i
            if (x % i == 0) {

                // Calculate the corresponding column
                int j = x / i;

                // Ensure the column lies within the table
                if (j >= 1 && j <= n) {
                    count++;
                }
            }
        }

        // Print the total number of cells containing x
        System.out.println(count);

        sc.close();
    }
}
