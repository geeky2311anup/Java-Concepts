class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {

        /*
         * Rectangle format:
         *
         * [x1, y1, x2, y2]
         *
         * (x1, y1) -> bottom-left corner
         * (x2, y2) -> top-right corner
         */

        int x1 = rec1[0];
        int y1 = rec1[1];
        int x2 = rec1[2];
        int y2 = rec1[3];

        int a1 = rec2[0];
        int b1 = rec2[1];
        int a2 = rec2[2];
        int b2 = rec2[3];


        /*
         * Find the common horizontal portion.
         *
         * The overlapping part starts at the
         * larger left boundary.
         */
        int commonLeft = Math.max(x1, a1);

        /*
         * The overlapping part ends at the
         * smaller right boundary.
         */
        int commonRight = Math.min(x2, a2);

        // Positive width means the rectangles
        // actually overlap horizontally.
        int width = commonRight - commonLeft;
        boolean hasWidth = width > 0;


        /*
         * Find the common vertical portion.
         *
         * The overlapping part starts at the
         * higher bottom boundary.
         */
        int commonBottom = Math.max(y1, b1);

        /*
         * The overlapping part ends at the
         * lower top boundary.
         */
        int commonTop = Math.min(y2, b2);

        // Positive height means the rectangles
        // actually overlap vertically.
        int height = commonTop - commonBottom;
        boolean hasHeight = height > 0;


        /*
         * Both width and height must be positive.
         *
         * If either one is zero, the rectangles
         * only touch at an edge or corner.
         */
        return hasWidth && hasHeight;
    }
}

/*
 * ============================
 * INTUITION
 * ============================
 *
 * Two rectangles overlap only when they have:
 *
 * 1. Some common width
 * 2. Some common height
 *
 * Common width:
 *
 * max(x1, a1) < min(x2, a2)
 *
 * Common height:
 *
 * max(y1, b1) < min(y2, b2)
 *
 *
 * We use '<' instead of '<=' because touching
 * at an edge is NOT considered an overlap.
 *
 *
 * Example:
 *
 * rec1 = [0, 0, 2, 2]
 * rec2 = [1, 1, 3, 3]
 *
 * common width  = 2 - 1 = 1
 * common height = 2 - 1 = 1
 *
 * Both are positive, so the rectangles overlap.
 *
 *
 * ============================
 * COMPLEXITY
 * ============================
 *
 * Time:  O(1)
 * Space: O(1)
 */
