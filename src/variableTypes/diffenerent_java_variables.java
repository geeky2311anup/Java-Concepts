```java
class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int size = nums.length;
        int[] suffixMin = new int[size];

        suffixMin[size - 1] = nums[size - 1];

        for (int pos = size - 2; pos >= 0; pos--) {
            suffixMin[pos] = Math.min(nums[pos], suffixMin[pos + 1]);
        }

        int maxSeen = Integer.MIN_VALUE;

        for (int pos = 0; pos < size; pos++) {
            maxSeen = Math.max(maxSeen, nums[pos]);

            if (maxSeen - suffixMin[pos] <= k) {
                return pos;
            }
        }

        return -1;
    }
}
```

This keeps the **same O(n) time and O(n) space complexity**, but changes the naming and implementation style.
