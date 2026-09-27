class Solution {
    public int maxPalindromes(String text, int minLength) {
        int len = text.length();
        int totalPalindromes = 0;
        int lastMatchedEnd = -1;

        for (int idx = 0; idx < len; idx++) {
            // Check both odd-length (offset = 0) and even-length (offset = 1) palindrome centers
            for (int offset = 0; offset <= 1; offset++) {
                int left = idx;
                int right = idx + offset;

                while (left >= 0 && right < len && text.charAt(left) == text.charAt(right)) {
                    int windowSize = right - left + 1;

                    if (windowSize >= minLength) {
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
