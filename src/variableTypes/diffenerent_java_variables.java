class Solution {


    // Builds an array where suffix[i] stores
    // the minimum value from i to the end of the array.
main
    private int[] buildSuffixMin(int[] arr) {
        int n = arr.length;
        int[] suffix = new int[n];

        suffix[n - 1] = arr[n - 1];

        // Calculate minimum from right to left
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = Math.min(arr[i], suffix[i + 1]);
        }

        return suffix;
    }

    public int firstStableIndex(int[] arr, int targetDiff) {
        int n = arr.length;


        // Empty array
 main
        if (n == 0) {
            return -1;
        }

        // suffix[i] = minimum element from i to n-1
        int[] suffix = buildSuffixMin(arr);


        // Maximum element seen in the prefix [0...i]
 main
        int prefixMax = arr[0];

        for (int i = 0; i < n; i++) {

            // Update maximum in the prefix
            prefixMax = Math.max(prefixMax, arr[i]);



            // Difference between the largest value
            // on the left and smallest value on the right
            int difference = prefixMax - suffix[i];

            // First index where the difference is small enough
 main
            if (difference <= targetDiff) {
                return i;
            }
        }

        return -1;
    }
}
