
import java.util.Arrays;

public class SolutionTest {
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test 1: Standard case
        runTest(sol, new int[]{5, 3, 8, 2, 6}, 3);

        // Test 2: Valid index at the beginning
        runTest(sol, new int[]{10, 2, 3, 4}, 10);

        // Test 3: No valid index exists
        runTest(sol, new int[]{1, 100, 1, 100}, 5);

        // Test 4: Array with negative numbers
        runTest(sol, new int[]{-5, -1, -3}, 2);

        // Test 5: Single element array
        runTest(sol, new int[]{42}, 0);

        // Test 6: Already sorted array
        runTest(sol, new int[]{1, 2, 3, 4, 5}, 2);

        // Test 7: Reverse sorted array
        runTest(sol, new int[]{9, 7, 5, 3, 1}, 4);

        // Test 8: Array containing duplicate elements
        runTest(sol, new int[]{4, 4, 4, 4, 4}, 0);

        // Test 9: All negative elements
        runTest(sol, new int[]{-10, -20, -30, -40}, 5);

        // Test 10: Two elements
        runTest(sol, new int[]{3, 8}, 5);

        // Test 11: Large difference between elements
        runTest(sol, new int[]{1000, 10, 500, 20}, 100);

        // Test 12: Two identical elements
        runTest(sol, new int[]{7, 7}, 0);

        // Test 13: Array containing zeros
        runTest(sol, new int[]{0, 0, 5, 10}, 3);

        // Test 14: Mixed positive and negative values
        runTest(sol, new int[]{-8, 4, -2, 7, 0}, 6);

        // Test 15: All elements are equal
        runTest(sol, new int[]{12, 12, 12, 12}, 10);

        // Test 16: Strictly increasing values
        runTest(sol, new int[]{2, 5, 9, 14, 20, 30}, 8);

        // Test 17: Strictly decreasing values
        runTest(sol, new int[]{50, 40, 30, 20, 10}, 15);

        // Test 18: Larger array
        runTest(sol, new int[]{15, 3, 22, 8, 17, 5, 30, 11}, 12);

        // Test 19: Target is zero
        runTest(sol, new int[]{-3, 0, 3, 6}, 0);

        // Test 20: Array with repeated negative values
        runTest(sol, new int[]{-5, -5, -2, -2, 0}, 4);
    }

    private static void runTest(Solution sol, int[] arr, int target) {
        int result = sol.firstStableIndex(arr, target);

        System.out.println(
            "Array: " + Arrays.toString(arr) +
            " | Target: " + target +
            " | First Stable Index: " + result
        );
    }
}
