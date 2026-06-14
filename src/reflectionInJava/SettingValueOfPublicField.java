class Solution {
    public int pairSum(ListNode head) {
        if (head == null) return 0;

        // Phase 1: Compute absolute length of the node chain
        int listLength = 0;
        ListNode structuralCursor = head;
        while (structuralCursor != null) {
            listLength++;
            structuralCursor = structuralCursor.next;
        }

        // Phase 2: Allocate a native primitive array block
        int[] scalarBuffer = new int[listLength];
        structuralCursor = head;
        int targetIdx = 0;
        
        while (structuralCursor != null) {
            scalarBuffer[targetIdx++] = structuralCursor.val;
            structuralCursor = structuralCursor.next;
        }

        int highestTwinPairSum = 0;
        int midpointBoundary = listLength / 2;

        // Phase 3: Direct bracket offset index calculations
        for (int index = 0; index < midpointBoundary; index++) {
            int matchingTwinSum = scalarBuffer[index] + scalarBuffer[listLength - 1 - index];
            if (matchingTwinSum > highestTwinPairSum) {
                highestTwinPairSum = matchingTwinSum;
            }
        }

        return highestTwinPairSum;
    }
}
