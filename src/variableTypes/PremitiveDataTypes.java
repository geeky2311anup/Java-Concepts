
class Solution {
    // dp[index][k][open] stores the number of ways to select
    // the remaining k segments starting from the current index.
    private long[][][] dp;

    // Modulo value to prevent integer overflow.
    private static final long MOD = 1_000_000_007L;

    private int solve(int index, int open, int k, int n) {

        // All required segments have been selected successfully.
        if (k == 0) {
            return 1;
        }

        // No positions remain, but some segments are still required.
        if (index == n) {
            return 0;
        }

        // Return the previously calculated result if available.
        if (dp[index][k][open] != -1) {
            return (int) dp[index][k][open];
        }

        long count = 0;

        if (open == 1) {
            // Case 1: A segment is currently open.
            // Option A: Close the current segment.
            // This completes one segment, so decrease k.
            long close = solve(index, 0, k - 1, n);

            // Option B: Extend the current segment.
            // Move to the next position while keeping it open.
            long extend = solve(index + 1, 1, k, n);

            count = (close + extend) % MOD;

        } else {
            // Case 2: No segment is currently open.

            // Option A: Start a new segment at this position.
            long start = solve(index + 1, 1, k, n);

            // Option B: Skip this position and continue searching.
            long skip = solve(index + 1, 0, k, n);

            count = (start + skip) % MOD;
        }

        // Save the result to avoid recomputing this state.
        dp[index][k][open] = count;

        return (int) count;
    }

    public int numberOfSets(int n, int k) {

        // Initialize the memoization array.
        // Dimensions:
        // n + 1 -> current position
        // k + 1 -> number of segments remaining
        // 2     -> segment state (open or closed)
        dp = new long[n + 1][k + 1][2];

        // -1 indicates that a state has not been calculated yet.
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                java.util.Arrays.fill(dp[i][j], -1);
            }
        }

        // Begin at index 0 with no open segment
        // and all k segments still to be selected.
        return solve(0, 0, k, n);
    }
}
