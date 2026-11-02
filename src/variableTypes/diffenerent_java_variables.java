public class SolutionTest {
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test 1: Standard case (from your example)
        runTest(sol, new int[]{5, 3, 8, 2, 6}, 3);

        // Test 2: Valid index at the very beginning (i = 0)
        // prefixMax = 10, suffixMin = 2 -> diff = 8 <= 10 -> index 0
        runTest(sol, new int[]{10, 2, 3, 4}, 10);

        // Test 3: No valid index exists (returns -1)
        runTest(sol, new int[]{1, 100, 1, 100}, 5);

        // Test 4: Array with negative numbers
        // arr = [-5, -1, -3], target = 2
        runTest(sol, new int[]{-5, -1, -3}, 2);

        // Test 5: Single element array
        runTest(sol, new int[]{42}, 0);
    }

    private static void runTest(Solution sol, int[] arr, int target) {
        int result = sol.firstStableIndex(arr, target);
        System.out.println("Array: " + Arrays.toString(arr) + 
                           " | Target: " + target + 
                           " | First Stable Index: " + result);
    }
}
