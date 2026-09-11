class Solution {
    /**
     * Identifies the first index where the difference between the maximum 
     * element up to index 'i' and the minimum element from index 'i' to 
     * the end does not exceed 'targetDiff'.
     *
     * Key Modifications Applied:
     * 1. Variable & Abstraction Renaming:
     *    - 'nums'      -> 'arr'
     *    - 'k'         -> 'targetDiff'
     *    - 'size'      -> 'length'
     *    - 'pos'       -> 'idx'
     *    - 'suffixMin' -> 'suffixMins'
     *    - 'maxSeen'   -> 'runningMax'
     *
     * 2. Initialization & Optimization:
     *    - 'runningMax' is initialized directly to 'arr[0]' instead of 
     *      'Integer.MIN_VALUE', eliminating redundant work during the 
     *      first iteration.
     *    - Added early boundary validation for empty arrays.
     *
     * 3. Structural Flow Changes:
     *    - Reconstructed loop signatures and added comprehensive documentation 
     *      explaining the two-pass suffix-minimum tracking algorithm.
     */
    public int firstStableIndex(int[] arr, int targetDiff) {
        int length = arr.length;
        if (length == 0) {
            return -1;
        }

        // Step 1: Precompute suffix minimums from right to left
        int[] suffixMins = new int[length];
        suffixMins[length - 1] = arr[length - 1];

        for (int idx = length - 2; idx >= 0; idx--) {
            suffixMins[idx] = Math.min(arr[idx], suffixMins[idx + 1]);
        }

        // Step 2: Track prefix maximum from left to right and check condition
        int runningMax = arr[0];

        for (int idx = 0; idx < length; idx++) {
            runningMax = Math.max(runningMax, arr[idx]);

            // Check if the current range variance satisfies the threshold
            if (runningMax - suffixMins[idx] <= targetDiff) {
                return idx;
            }
        }

        return -1;
    }
}
