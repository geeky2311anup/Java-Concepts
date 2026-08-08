class Solution {

    private List<Integer> convertToList(ListNode head) {
        List<Integer> nums = new ArrayList<>();

        while (head != null) {
            nums.add(head.val);
            head = head.next;
        }

        return nums;
    }

    private int pairValue(List<Integer> nums, int i, int j) {
        return nums.get(i) + nums.get(j);
    }

    public int pairSum(ListNode head) {

        List<Integer> nums = convertToList(head);

        int left = 0;
        int right = nums.size() - 1;
        int maxSum = 0;

        while (left < right) {

            maxSum = Math.max(maxSum, pairValue(nums, left, right));

            left++;
            right--;
        }

        return maxSum;
    }
}
