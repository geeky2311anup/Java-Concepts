
class Solution {

    public long countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        int offset = n;

        int[] prefixCount = new int[2 * n + 1];
        prefixCount[offset] = 1;

        long answer = 0;
        long currentCount = 0;
        int balance = 0;

        for (int num : nums) {
            if (isTarget(num, target)) {
                currentCount += prefixCount[offset + balance];
                balance++;
            } else {
                balance--;
                currentCount -= prefixCount[offset + balance];
            }

            prefixCount[offset + balance]++;
            answer += currentCount;
        }

        return answer;
    }

    private boolean isTarget(int value, int target) {
        return value == target;
    }

    private int getIndex(int balance, int offset) {
        return offset + balance;
    }

    private long square(long value) {
        return value * value;
    }

    private int clamp(int value, int low, int high) {
        return Math.max(low, Math.min(value, high));
    }
}
