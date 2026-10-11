# LeetCode — Rectangle Overlap

## Intuition

A rectangle is represented by four coordinates:

`[x1, y1, x2, y2]`

- `(x1, y1)` is the bottom-left corner.
- `(x2, y2)` is the top-right corner.

Two rectangles overlap only if they share a region with **positive width and positive height**.

Imagine placing two rectangles on a coordinate plane. We need to check two independent conditions:

1. **Horizontal overlap:** Their x-coordinate ranges must intersect.
2. **Vertical overlap:** Their y-coordinate ranges must intersect.

If both conditions are satisfied, the rectangles overlap.

If the rectangles only touch along an edge or at a single corner, they do not count as overlapping.

## Approach

### Step 1: Extract the coordinates

For the first rectangle:

- `x1`, `y1`: bottom-left corner.
- `x2`, `y2`: top-right corner.

For the second rectangle:

- `a1`, `b1`: bottom-left corner.
- `a2`, `b2`: top-right corner.

### Step 2: Calculate the common horizontal interval

The common horizontal interval begins at the larger left boundary:

`commonLeft = max(x1, a1)`

It ends at the smaller right boundary:

`commonRight = min(x2, a2)`

Therefore:

`width = commonRight - commonLeft`

If `width > 0`, the rectangles overlap horizontally.

If `width == 0`, they touch at a vertical edge.

If `width < 0`, there is a horizontal gap.

### Step 3: Calculate the common vertical interval

The common vertical interval begins at the higher bottom boundary:

`commonBottom = max(y1, b1)`

It ends at the lower top boundary:

`commonTop = min(y2, b2)`

Therefore:

`height = commonTop - commonBottom`

If `height > 0`, the rectangles overlap vertically.

If `height == 0`, they touch at a horizontal edge.

If `height < 0`, there is a vertical gap.

### Step 4: Check both conditions

Return `true` only if:

- `width > 0`
- `height > 0`

Equivalently:

`return hasWidth && hasHeight;`

Both conditions must be true.

## Java Code

```java
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
         * Find the common horizontal interval.
         *
         * The overlap starts at the larger left
         * boundary and ends at the smaller right
         * boundary.
         */
        int commonLeft = Math.max(x1, a1);
        int commonRight = Math.min(x2, a2);

        int width = commonRight - commonLeft;

        // Positive width means horizontal overlap.
        boolean hasWidth = width > 0;

        /*
         * Find the common vertical interval.
         *
         * The overlap starts at the higher bottom
         * boundary and ends at the lower top
         * boundary.
         */
        int commonBottom = Math.max(y1, b1);
        int commonTop = Math.min(y2, b2);

        int height = commonTop - commonBottom;

        // Positive height means vertical overlap.
        boolean hasHeight = height > 0;

        /*
         * Both width and height must be positive.
         *
         * Edge or corner contact is not overlap.
         */
        return hasWidth && hasHeight;
    }
}
```

## Dry Run

Consider:

```text
rec1 = [0, 0, 2, 2]
rec2 = [1, 1, 3, 3]
```

<text color="secondary" size="sm">Step-by-step calculation</text>

| Variable | Calculation | Value |
|---|---|---:|
| `commonLeft` | `max(0, 1)` | 1 |
| `commonRight` | `min(2, 3)` | 2 |
| `width` | `2 - 1` | 1 |
| `hasWidth` | `1 > 0` | `true` |
| `commonBottom` | `max(0, 1)` | 1 |
| `commonTop` | `min(2, 3)` | 2 |
| `height` | `2 - 1` | 1 |
| `hasHeight` | `1 > 0` | `true` |

Final result:

```text
true && true = true
```

The rectangles share a square region from `(1, 1)` to `(2, 2)`, so they overlap.

## Edge Cases

### Case 1: Rectangles do not overlap

```text
rec1 = [0, 0, 1, 1]
rec2 = [2, 2, 3, 3]
```

The rectangles are separated.

The common width and height are not positive.

**Output:** `false`

### Case 2: Rectangles touch at an edge

```text
rec1 = [0, 0, 2, 2]
rec2 = [2, 0, 4, 2]
```

The first rectangle ends at `x = 2`, and the second begins at `x = 2`.

```text
width = 2 - 2 = 0
```

Because the width is zero, they share no positive-area region.

**Output:** `false`

### Case 3: Rectangles touch at a corner

```text
rec1 = [0, 0, 2, 2]
rec2 = [2, 2, 4, 4]
```

They share only the point `(2, 2)`.

Both the common width and common height are zero.

**Output:** `false`

### Case 4: One rectangle is completely inside another

```text
rec1 = [0, 0, 5, 5]
rec2 = [1, 1, 3, 3]
```

The second rectangle lies entirely inside the first.

Both common width and common height are positive.

**Output:** `true`

Containment is a valid overlap.

## Alternative Approach: Check Separation

Instead of calculating the intersection, we can check whether the rectangles are completely separated.

Two rectangles do not overlap if at least one condition is true:

- The first rectangle is entirely to the left of the second.
- The second rectangle is entirely to the left of the first.
- The first rectangle is entirely below the second.
- The second rectangle is entirely below the first.

```java
class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return rec1[0] < rec2[2]
            && rec2[0] < rec1[2]
            && rec1[1] < rec2[3]
            && rec2[1] < rec1[3];
    }
}
```

This version is shorter and is mathematically equivalent for valid rectangles with positive width and height.

## Complexity Analysis

**Time Complexity: `O(1)`**

We perform a fixed number of coordinate accesses, comparisons, and arithmetic operations. The runtime does not depend on the rectangle dimensions.

**Space Complexity: `O(1)`**

We use a constant number of integer and boolean variables. No additional data structures are required.

## Summary

- Find the intersection of the x-coordinate ranges.
- Find the intersection of the y-coordinate ranges.
- Both intersection dimensions must be strictly positive.
- Use `>` rather than `>=` so edge and corner contact are excluded.
- A rectangle completely inside another still counts as overlap.

**Key formula:**

`max(left boundaries) < min(right boundaries)`

Apply this independently to both the x- and y-coordinates.

The same principle is useful in collision detection, interval intersection, and checking whether two axis-aligned bounding boxes intersect.
