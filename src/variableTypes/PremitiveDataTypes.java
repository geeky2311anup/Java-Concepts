
class Solution {
    private long[][][] dp;
    private static final long MOD = 1_000_000_007L;

    private int solve(int index, int open, int k, int n) {
        if (k == 0) {
            return 1;
        }

        if (index == n) {
            return 0;
        }

        if (dp[index][k][open] != -1) {
            return (int) dp[index][k][open];
        }

        long count;

        if (open == 1) {
            // Close the current segment or extend it.
            count = solve(index, 0, k - 1, n);
            count = (count + solve(index + 1, 1, k, n)) % MOD;
        } else {
            // Start a new segment or skip this position.
            count = solve(index + 1, 1, k, n);
            count = (count + solve(index + 1, 0, k, n)) % MOD;
        }

        return (int) (dp[index][k][open] = count);
    }

    public int numberOfSets(int n, int k) {
        dp = new long[n + 1][k + 1][2];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                java.util.Arrays.fill(dp[i][j], -1);
            }
        }

        return solve(0, 0, k, n);
    }
}
