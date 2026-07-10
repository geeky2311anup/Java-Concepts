 class Solution {

    public int pairSum(ListNode head) {



        List<Integer> nodeValues = new ArrayList<>();



        ListNode walker = head;

        while (walker != null) {

            nodeValues.add(walker.val);

            walker = walker.next;

        }



        int answer = 0;

        int size = nodeValues.size();



        for (int i = 0; i < size / 2; i++) {

            int twinSum = nodeValues.get(i) + nodeValues.get(size - i - 1);

            answer = Math.max(answer, twinSum);

        }



        return answer;

    }

}





