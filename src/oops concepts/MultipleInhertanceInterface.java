class Solution {
    public int maxPalindromes(String text, int minLength) {
        int len = text.length();
        int totalPalindromes = 0;
        int lastMatchedEnd = -1;

        // Try every index as a palindrome center
        for (int idx = 0; idx < len; idx++) {
            // offset = 0: odd-length, offset = 1: even-length
            for (int offset = 0; offset <= 1; offset++) {
                int left = idx;
                int right = idx + offset;

                // Expand while characters match
                while (left >= 0 && right < len
                        && text.charAt(left) == text.charAt(right)) {

                    int windowSize = right - left + 1;

                    // Found a palindrome of the required length
                    if (windowSize >= minLength) {
                        // Select non-overlapping palindromes
                        if (left > lastMatchedEnd) {
                            totalPalindromes++;
                            lastMatchedEnd = right;
                        }
                        break;
                    }

                    left--;
                    right++;
                }
            }
        }

        return totalPalindromes;
    }
}
