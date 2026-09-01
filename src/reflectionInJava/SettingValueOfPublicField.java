class Solution {
    public int pairSum(ListNode head) {
        List<Integer> values = new ArrayList<>();

        for (ListNode node = head; node != null; node = node.next) {
            values.add(node.val);
        }

        int i = 0;
        int j = values.size() - 1;
        int answer = Integer.MIN_VALUE;

        while (i < j) {
            int sum = values.get(i) + values.get(j);

            if (sum > answer) {
                answer = sum;
            }

            i++;
            j--;
        }

        return answer;
    }
}
