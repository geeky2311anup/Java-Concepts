class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {

        int x1 = rec1[0];
        int y1 = rec1[1];
        int x2 = rec1[2];
        int y2 = rec1[3];

        int a1 = rec2[0];
        int b1 = rec2[1];
        int a2 = rec2[2];
        int b2 = rec2[3];

        // Check if there is a common width
        int commonLeft = Math.max(x1, a1);
        int commonRight = Math.min(x2, a2);

        // Check if there is a common height
        int commonBottom = Math.max(y1, b1);
        int commonTop = Math.min(y2, b2);

        boolean hasWidth = commonLeft < commonRight;
        boolean hasHeight = commonBottom < commonTop;

        return hasWidth && hasHeight;
    }
}
