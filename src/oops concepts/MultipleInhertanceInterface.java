class Solution {
    public int maxPalindromes(String s, int k) {
        int n = s.length();
        int result = 0;
        int previousEnd = -1;

        for (int center = 0; center < n; center++) {
            int[][] ranges = {
                {center - 1, center},
                {center, center}
            };

            for (int[] range : ranges) {
                int left = range[0];
                int right = range[1];

                while (left >= 0 && right < n) {
                    if (s.charAt(left) != s.charAt(right)) {
                        break;
                    }

                    if (right - left + 1 >= k) {
                        if (left > previousEnd) {
                            result++;
                            previousEnd = right;
                        }
                        break;
                    }

                    left--;
                    right++;
                }
            }
        }

        return result;
    }
}
