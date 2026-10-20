import java.util.*;

class Solution {

    // Checks whether the opening and closing brackets match
    private boolean isMatching(char open, char close) {
        return (open == '(' && close == ')') ||
               (open == '[' && close == ']') ||
               (open == '{' && close == '}');
    }

    public boolean isValid(String s) {
        char[] stack = new char[s.length()];
        int top = -1;

        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);

            // Push opening brackets onto the stack
            if (current == '(' || current == '[' || current == '{') {
                stack[++top] = current;
                continue;
            }

            // A closing bracket cannot match an empty stack
            if (top == -1) {
                return false;
            }

            // Pop the most recent opening bracket
            char last = stack[top--];

            // Check whether the bracket pair is valid
            if (!isMatching(last, current)) {
                return false;
            }
        }

        // Valid only when every opening bracket has been closed
        return top == -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.isValid("()"));       // true
        System.out.println(solution.isValid("()[]{}"));   // true
        System.out.println(solution.isValid("(]"));       // false
        System.out.println(solution.isValid("({[]})"));   // true
        System.out.println(solution.isValid("((("));      // false
    }
}
