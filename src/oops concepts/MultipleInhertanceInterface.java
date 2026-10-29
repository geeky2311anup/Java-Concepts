
class Solution {

    public int maxPalindromes(String text, int minLength) {
        int n = text.length();
        int count = 0;
        int lastEnd = -1;

        for (int center = 0; center < n; center++) {

            // Check both odd-length and even-length palindromes
            for (int type = 0; type < 2; type++) {
                int left = center;
                int right = center + type;

                while (left >= 0 && right < n
                        && text.charAt(left) == text.charAt(right)) {

                    int length = right - left + 1;

                    if (length >= minLength) {
                        // Choose only non-overlapping palindromes
                        if (left > lastEnd) {
                            count++;
                            lastEnd = right;
                        }
                        break;
                    }

                    left--;
                    right++;
                }
            }
        }

        return count;
    }

    private boolean isPalindrome(String text, int left, int right) {
        while (left < right) {
            if (text.charAt(left++) != text.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}
