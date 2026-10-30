
import java.util.*;

class Solution {

    // Determines whether a character is an opening bracket
    private boolean isOpening(char ch) {
        return ch == '(' || ch == '[' || ch == '{';
    }

    // Returns the corresponding closing bracket
    private char getClosing(char ch) {
        if (ch == '(') return ')';
        if (ch == '[') return ']';
        return '}';
    }

    // Checks whether both brackets form a valid pair
    private boolean isMatching(char open, char close) {
        return getClosing(open) == close;
    }

    public boolean isValid(String s) {
        char[] stack = new char[s.length()];
        int top = -1;

        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);

            // Store opening brackets for future matching
            if (isOpening(current)) {
                stack[++top] = current;
            } else {

                // No opening bracket is available to match
                if (top < 0) {
                    return false;
                }

                char previous = stack[top--];

                // Verify the bracket sequence
                if (!isMatching(previous, current)) {
                    return false;
                }
            }
        }

        // All opening brackets must have corresponding closing brackets
        return top == -1;
    }

    public static void main(String[] args) {
        Solution obj = new Solution();

        String[] testCases = {
            "()",
            "()[]{}",
            "(]",
            "({[]})",
            "(((",
            "([)]",
            "{[()]}",
            "}"
        };

        for (String test : testCases) {
            System.out.println(test + " -> " + obj.isValid(test));
        }
    }
}

/*
Moral / Key Learning:

1. Stack follows LIFO (Last In First Out), which makes it
   suitable for handling nested brackets.

2. Every opening bracket must be closed by its corresponding
   closing bracket.

3. The most recently opened bracket must be closed first.

4. A closing bracket with an empty stack indicates an invalid
   sequence.

5. Different bracket types cannot be interchanged.
   For example, ([)] is invalid.

6. At the end of traversal, the stack must be empty.
   Otherwise, some opening brackets remain unmatched.

7. Using a character array as a stack avoids the overhead
   of creating a separate Stack object.

Time Complexity: O(n)
- Every character is processed exactly once.

Space Complexity: O(n)
- In the worst case, all characters are opening brackets.
*/
