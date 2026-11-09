
class Solution {

    /*
     * 3D DP (Memoization):
     *
     * dp[index][k][open]
     *
     * index : Current position being processed.
     * k     : Number of segments still to be completed.
     * open  : 1 means a segment is currently active,
     *         0 means no segment is currently active.
     *
     * Each state represents a unique combination of these
     * three parameters.
     *
     * -1 indicates that the state has not been calculated yet.
     */
    private long[][][] dp;

    // Modulo value to prevent integer overflow.
    private static final long MOD = 1_000_000_007L;


    /*
     * Recursive DP function with memoization.
     *
     * At every position, we decide whether to:
     * 1. Start a new segment.
     * 2. Extend an existing segment.
     * 3. Close the current segment.
     * 4. Skip the current position.
     *
     * The function returns the total number of valid ways
     * to select exactly k segments from the remaining positions.
     */
    private int solve(int index, int open, int k, int n) {

        // If all required segments are completed,
        // we have found one valid combination.
        if (k == 0) {
            return 1;
        }

        // No positions are left, but some segments are still required.
        if (index == n) {
            return 0;
        }

        // Return the previously calculated result if available.
        if (dp[index][k][open] != -1) {
            return (int) dp[index][k][open];
        }

        // Stores the total ways obtained from different choices.
        long count = 0;


        /*
         * CASE 1: A segment is already OPEN.
         *
         * We have two choices:
         *
         * A. CLOSE:
         *    Complete the current segment.
         *    Decrease k because one segment has been completed.
         *
         * B. EXTEND:
         *    Include the current position in the existing segment.
         *    Move to the next position without changing k.
         */
        if (open == 1) {

            // Close the current segment.
            // The current index is reconsidered in the closed state.
            long close = solve(index, 0, k - 1, n);

            // Extend the current segment to the next position.
            long extend = solve(index + 1, 1, k, n);

            // Both choices represent different valid possibilities.
            count = (close + extend) % MOD;

        } else {

            /*
             * CASE 2: No segment is currently OPEN.
             *
             * We have two choices:
             *
             * A. START:
             *    Start a new segment from the current position.
             *    Move forward with open = 1.
             *
             * B. SKIP:
             *    Do not use the current position.
             *    Move forward while keeping open = 0.
             */

            // Start a new segment at the current position.
            long start = solve(index + 1, 1, k, n);

            // Ignore the current position and move ahead.
            long skip = solve(index + 1, 0, k, n);

            // Total ways = ways by starting + ways by skipping.
            count = (start + skip) % MOD;
        }


        /*
         * MEMOIZATION:
         *
         * Store the calculated result for the current state.
         * If the same state is encountered again, we can directly
         * return its stored result instead of solving recursively.
         */
        dp[index][k][open] = count;

        return (int) count;
    }


    /*
     * Main function:
     * Calculates the number of ways to draw exactly k
     * non-overlapping line segments using n positions.
     */
    public int numberOfSets(int n, int k) {

        // Allocate the 3D DP array.
        dp = new long[n + 1][k + 1][2];

        /*
         * Initially, mark all states as unvisited.
         *
         * A value of -1 means not calculated.
         * A value of 0 means calculated but no valid ways exist.
         */
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                java.util.Arrays.fill(dp[i][j], -1);
            }
        }

        /*
         * Starting DP state:
         *
         * index = 0 : Begin from the first position.
         * open  = 0 : No segment is currently active.
         * k         : All k segments need to be selected.
         */
        return solve(0, 0, k, n);
    }
}
