class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] minFromRight = new int[n];

        minFromRight[n - 1] = nums[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            minFromRight[i] = Math.min(minFromRight[i + 1], nums[i]);
        }

        int largest = nums[0];

        for (int i = 0; i < n; i++) {
            if (nums[i] > largest) {
                largest = nums[i];
            }

            int difference = largest - minFromRight[i];

            if (difference <= k) {
                return i;
            }
        }

        return -1;
    }
}
