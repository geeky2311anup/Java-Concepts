class Solution {

    private int getMax(int first, int second) {
        return first > second ? first : second;
    }

    public int pairSum(ListNode head) {

        List<Integer> values = new ArrayList<>();
        ListNode current = head;

        while (current != null) {
            values.add(current.val);
            current = current.next;
        }

        int n = values.size();
        int maxTwin = 0;

        for (int left = 0; left < n / 2; left++) {
            int right = n - left - 1;
            int sum = values.get(left) + values.get(right);
            maxTwin = getMax(maxTwin, sum);
        }

        return maxTwin;
    }
}
