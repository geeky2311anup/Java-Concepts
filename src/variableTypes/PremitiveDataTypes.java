
class Solution {

    /*
     * dp[index][k][open]
     *
     * index : Current position being processed.
     * k     : Number of line segments still to be selected.
     * open  : 1 if a segment is currently open, otherwise 0.
     *
     * dp[index][k][open] stores the number of valid ways
     * to complete the selection from the current state.
     *
     * A value of -1 means that the state has not been computed.
     */
    private long[][][] dp;

    // Modulo is used to keep the number of ways within the limit.
    private static final long MOD = 1_000_000_007L;


    /*
     * Recursive DP function.
     *
     * We process positions from left to right and decide whether
     * to start a segment, extend an existing segment, close it,
     * or leave the current position unused.
     *
     * Parameters:
     * index : Current position in the range [0, n - 1].
     * open  : Indicates whether a segment is currently open.
     * k     : Number of segments that still need to be completed.
     * n     : Total number of positions.
     *
     * Returns the number of valid ways to complete the selection.
     */
    private int solve(int index, int open, int k, int n) {

        /*
         * BASE CASE 1:
         * If no segments remain to be selected, the requirement
         * has been satisfied. There is one valid way to finish:
         * do not select any additional segments.
         */
        if (k == 0) {
            return 1;
        }

        /*
         * BASE CASE 2:
         * If we have reached the end of the range but still need
         * to select more segments, no valid completion is possible.
         */
        if (index == n) {
            return 0;
        }

        /*
         * MEMOIZATION:
         * If this state has already been solved, reuse its result.
         * This avoids exploring the same state repeatedly.
         */
        if (dp[index][k][open] != -1) {
            return (int) dp[index][k][open];
        }

        // Accumulates the number of valid choices from this state.
        long count = 0;


        /*
         * CASE 1: A segment is currently OPEN.
         *
         * We have two possible decisions:
         *
         * 1. Close the current segment.
         *    One segment is completed, so k decreases by one.
         *    We remain at the same index because this position
         *    can be reconsidered as the beginning of a new segment
         *    or left unused.
         *
         * 2. Extend the current segment.
         *    The current position is included in the segment,
         *    and we move forward while keeping the segment open.
         */
        if (open == 1) {

            // Finish the current segment.
            long close = solve(index, 0, k - 1, n);

            // Include the current position in the open segment.
            long extend = solve(index + 1, 1, k, n);

            // Combine both mutually exclusive choices.
            count = (close + extend) % MOD;

        } else {

            /*
             * CASE 2: No segment is currently OPEN.
             *
             * Again, there are two possible decisions:
             *
             * 1. Start a new segment at the current position.
             *    The segment becomes open, and we advance.
             *
             * 2. Skip the current position.
             *    No segment is started, and we advance.
             *
             * Both decisions are explored independently.
             */

            // Start selecting a new segment.
            long start = solve(index + 1, 1, k, n);

            // Leave this position unused.
            long skip = solve(index + 1, 0, k, n);

            // Add the number of ways from both choices.
            count = (start + skip) % MOD;
        }

        /*
         * STORE THE RESULT:
         * Save the computed answer for this state so that future
         * calls with identical parameters can reuse it.
         */
        dp[index][k][open] = count;

        // Return the computed number of ways.
        return (int) count;
    }


    /*
     * Main function called by the platform.
     *
     * n : Number of available positions.
     * k : Exact number of line segments to select.
     */
    public int numberOfSets(int n, int k) {

        /*
         * Allocate the memoization table.
         *
         * First dimension : n + 1 possible index values.
         * Second dimension: k + 1 remaining-segment values.
         * Third dimension : 2 states (closed or open).
         */
        dp = new long[n + 1][k + 1][2];

        /*
         * Initialize every state to -1.
         * This distinguishes uncomputed states from states
         * whose correct answer is zero.
         */
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                java.util.Arrays.fill(dp[i][j], -1);
            }
        }

        /*
         * Initial state:
         *
         * index = 0 : Start from the first position.
         * open  = 0 : No segment has been started.
         * k         : All requested segments remain to be selected.
         */
        return solve(0, 0, k, n);
    }
}
