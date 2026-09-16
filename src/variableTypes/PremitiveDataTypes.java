class Solution {
    private long[][][] memo;
    private static final long MOD = 1000000007L;

    private int dfs(int pos, int state, int remaining, int n) {
        if (remaining == 0) {
            return 1;
        }

        if (pos >= n) {
            return 0;
        }

        if (memo[pos][remaining][state] != -1) {
            return (int) memo[pos][remaining][state];
        }

        long ways;

        if (state == 1) {
            long close = dfs(pos, 0, remaining - 1, n);
            long extend = dfs(pos + 1, 1, remaining, n);
            ways = (close + extend) % MOD;
        } else {
            long begin = dfs(pos + 1, 1, remaining, n);
            long skip = dfs(pos + 1, 0, remaining, n);
            ways = (begin + skip) % MOD;
        }

        memo[pos][remaining][state] = ways;
        return (int) ways;
    }

    public int numberOfSets(int n, int k) {
        memo = new long[n + 1][k + 1][2];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                memo[i][j][0] = -1;
                memo[i][j][1] = -1;
            }
        }

        return dfs(0, 0, k, n);
    }
}
