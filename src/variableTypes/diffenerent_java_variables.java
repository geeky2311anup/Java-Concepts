
import java.util.Arrays;

public class SolutionTest {

    public static void main(String[] args) {

        // Create an instance of the Solution class
        Solution sol = new Solution();

        System.out.println("========== FIRST STABLE INDEX TESTING ==========\n");

        // Test 1: General case with an unsorted array
        // Checks whether the method identifies the first valid position.
        runTest(sol, new int[]{5, 3, 8, 2, 6}, 3);

        // Test 2: Valid index at the beginning of the array
        // Checks whether the first element itself satisfies the condition.
        runTest(sol, new int[]{10, 2, 3, 4}, 10);

        // Test 3: No valid index exists
        // Verifies the method's behavior when no position satisfies the target.
        runTest(sol, new int[]{1, 100, 1, 100}, 5);

        // Test 4: Array containing negative numbers
        // Checks handling of negative values during comparison.
        runTest(sol, new int[]{-5, -1, -3}, 2);

        // Test 5: Single-element array
        // Tests the minimum possible array size.
        runTest(sol, new int[]{42}, 0);

        // Test 6: Already sorted array
        // Checks the behavior when elements are in increasing order.
        runTest(sol, new int[]{1, 2, 3, 4, 5}, 2);

        // Test 7: Reverse sorted array
        // Verifies correctness when elements are in decreasing order.
        runTest(sol, new int[]{9, 7, 5, 3, 1}, 4);

        // Test 8: Array containing duplicate elements
        // Checks whether repeated values affect the result.
        runTest(sol, new int[]{4, 4, 4, 4, 4}, 0);

        // Test 9: All elements are negative
        // Tests comparisons when the entire array contains negative values.
        runTest(sol, new int[]{-10, -20, -30, -40}, 5);

        // Test 10: Array containing only two elements
        // Checks behavior for a very small input.
        runTest(sol, new int[]{3, 8}, 5);

        // Test 11: Large difference between consecutive elements
        // Ensures that large variations in values are handled correctly.
        runTest(sol, new int[]{1000, 10, 500, 20}, 100);

        // Test 12: Two identical elements
        // Checks duplicate handling in the smallest repeated-value array.
        runTest(sol, new int[]{7, 7}, 0);

        // Test 13: Array containing zeros
        // Verifies that zero values do not cause incorrect comparisons.
        runTest(sol, new int[]{0, 0, 5, 10}, 3);

        // Test 14: Mixed positive and negative values
        // Tests comparisons across different signs.
        runTest(sol, new int[]{-8, 4, -2, 7, 0}, 6);

        // Test 15: All elements have the same value
        // Checks behavior when there is no variation in array elements.
        runTest(sol, new int[]{12, 12, 12, 12}, 10);

        // Test 16: Strictly increasing array
        // Tests whether the method works correctly with ascending values.
        runTest(sol, new int[]{2, 5, 9, 14, 20, 30}, 8);

        // Test 17: Strictly decreasing array
        // Checks the method against descending values.
        runTest(sol, new int[]{50, 40, 30, 20, 10}, 15);

        // Test 18: Larger array with mixed values
        // Tests the implementation on a relatively larger input.
        runTest(sol, new int[]{15, 3, 22, 8, 17, 5, 30, 11}, 12);

        // Test 19: Target value is zero
        // Checks whether zero is handled correctly as the target.
        runTest(sol, new int[]{-3, 0, 3, 6}, 0);

        // Test 20: Repeated negative values and zero
        // Tests duplicate negative values along with a non-negative value.
        runTest(sol, new int[]{-5, -5, -2, -2, 0}, 4);

        System.out.println("\n========== ALL TEST CASES EXECUTED ==========");
    }

    /**
     * Executes a single test case and displays its input and result.
     *
     * @param sol    Instance of the Solution class
     * @param arr    Input integer array
     * @param target Target value used by firstStableIndex()
     */
    private static void runTest(Solution sol, int[] arr, int target) {

        // Invoke the method being tested
        int result = sol.firstStableIndex(arr, target);

        // Display the input and corresponding output
        System.out.println("---------------------------------------------");
        System.out.println("Input Array       : " + Arrays.toString(arr));
        System.out.println("Target Value      : " + target);
        System.out.println("First Stable Index: " + result);
    }
}
