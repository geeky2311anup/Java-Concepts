class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int leftA = rec1[0];
        int bottomA = rec1[1];
        int rightA = rec1[2];
        int topA = rec1[3];

        int leftB = rec2[0];
        int bottomB = rec2[1];
        int rightB = rec2[2];
        int topB = rec2[3];

        boolean horizontal = Math.max(leftA, leftB) < Math.min(rightA, rightB);
        boolean vertical = Math.max(bottomA, bottomB) < Math.min(topA, topB);

        return horizontal && vertical;
    }
}
