
class Solution {
    public boolean isValid(String s) {
        char[] stack = new char[s.length()];
        int top = -1;

        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);

            if (current == '(' || current == '[' || current == '{') {
                stack[++top] = current;
                continue;
            }

            if (top == -1) {
                return false;
            }

            char last = stack[top--];

            if (current == ')' && last != '(') {
                return false;
            }

            if (current == ']' && last != '[') {
                return false;
            }

            if (current == '}' && last != '{') {
                return false;
            }
        }

        return top == -1;
    }
}
