class Solution {

    private int[] buildSuffixMin(int[] arr) {
        int n = arr.length;
        int[] suffix = new int[n];

        suffix[n - 1] = arr[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = Math.min(arr[i], suffix[i + 1]);
        }

        return suffix;
    }

    public int firstStableIndex(int[] arr, int targetDiff) {
        int n = arr.length;

        if (n == 0) {
            return -1;
        }

        int[] suffix = buildSuffixMin(arr);
        int prefixMax = arr[0];

        for (int i = 0; i < n; i++) {
            prefixMax = Math.max(prefixMax, arr[i]);

            int difference = prefixMax - suffix[i];

            if (difference <= targetDiff) {
                return i;
            }
        }

        return -1;
    }
}
