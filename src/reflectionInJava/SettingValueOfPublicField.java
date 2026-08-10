class Solution {
    public int pairSum(ListNode head) {
        List<Integer> nums = new ArrayList<>();

        while (head != null) {
            nums.add(head.val);
            head = head.next;
        }

        int left = 0;
        int right = nums.size() - 1;
        int maxSum = 0;

        while (left < right) {
            maxSum = Math.max(maxSum, nums.get(left) + nums.get(right));
            left++;
            right--;
        }

        return maxSum;
    }
}
