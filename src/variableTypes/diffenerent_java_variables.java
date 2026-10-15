
import java.util.Arrays;

class Solution {

    /*
     * Builds a suffix-minimum array.
     *
     * suffix[i] stores the minimum element
     * from index i to the end of the array.
     *
     * Example:
     * arr    = [5, 3, 8, 2, 6]
     * suffix = [2, 2, 2, 2, 6]
     */
    private int[] buildSuffixMin(int[] arr) {
        int n = arr.length;

        int[] suffix = new int[n];

        // The last suffix contains only the last element.
        suffix[n - 1] = arr[n - 1];

        // Build suffix minimums from right to left.
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = Math.min(arr[i], suffix[i + 1]);
        }

        return suffix;
    }

    /*
     * Finds the first index i such that:
     *
     * max(arr[0 ... i]) - min(arr[i ... n-1])
     * <= targetDiff
     *
     * Returns:
     * - The first valid index, if one exists.
     * - -1 if no valid index exists.
     */
    public int firstStableIndex(int[] arr, int targetDiff) {
        int n = arr.length;

        // Handle an empty array.
        if (n == 0) {
            return -1;
        }

        // Precompute the minimum value for every suffix.
        int[] suffix = buildSuffixMin(arr);

        // Maximum element in the prefix [0 ... i].
        int prefixMax = Integer.MIN_VALUE;

        // Traverse the array from left to right.
        for (int i = 0; i < n; i++) {

            // Update the maximum of the current prefix.
            prefixMax = Math.max(prefixMax, arr[i]);

            // Minimum of the suffix starting at i.
            int suffixMin = suffix[i];

            // Calculate the difference using long
            // to avoid integer overflow.
            long difference = (long) prefixMax - suffixMin;

            // Return the earliest index satisfying the condition.
            if (difference <= targetDiff) {
                return i;
            }
        }

        // No valid index was found.
        return -1;
    }

    // Test the implementation.
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] arr = {5, 3, 8, 2, 6};
        int targetDiff = 3;

        System.out.println(
            "Array: " + Arrays.toString(arr)
        );

        System.out.println(
            "Target difference: " + targetDiff
        );

        System.out.println(
            "First stable index: "
            + solution.firstStableIndex(arr, targetDiff)
        );
    }
}
