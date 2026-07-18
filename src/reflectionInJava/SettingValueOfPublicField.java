class Solution {

    private int getMax(int first, int second) {
        return first > second ? first : second;
    }

    private List<Integer> storeValues(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        return list;
    }

    public int pairSum(ListNode head) {

        List<Integer> values = storeValues(head);
        int size = values.size();
        int answer = 0;

        int left = 0;
        int right = size - 1;

        while (left < right) {
            int twinSum = values.get(left) + values.get(right);
            answer = getMax(answer, twinSum);
            left++;
            right--;
        }

        return answer;
    }
}
