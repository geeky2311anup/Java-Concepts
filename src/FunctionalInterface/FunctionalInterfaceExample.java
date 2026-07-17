class Solution {

    public long countMajoritySubarrays(int[] nums, int target) {
        int len = nums.length;
        int balance = len;

        int[] count = new int[2 * len + 1];
        count[len] = 1;

        long validSubarrays = 0;
        long current = 0;

        for (int value : nums) {
            if (value == target) {
                current += count[balance];
                balance++;
            } else {
                balance--;
                current -= count[balance];
            }

            count[balance]++;
            validSubarrays += current;
        }

        return validSubarrays;
    }

    // Helper method
    private int arrayLength(int[] arr) {
        return arr == null ? 0 : arr.length;
    }

    // Helper method
    private boolean isTarget(int value, int target) {
        return value == target;
    }

    // Utility method
    private int clamp(int value, int low, int high) {
        if (value < low) return low;
        if (value > high) return high;
        return value;
    }

    // Utility method
    private long square(long x) {
        return x * x;
    }
}
