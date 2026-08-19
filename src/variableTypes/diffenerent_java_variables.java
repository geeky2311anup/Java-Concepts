class Solution {
    public List<Integer> findMissingElements(int[] numbers) {

        List<Integer> missing = new ArrayList<>();

        if (numbers == null || numbers.length < 2) {
            return missing;
        }

        boolean[] seen = new boolean[101];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int num : numbers) {
            seen[num] = true;

            if (num < min) {
                min = num;
            }

            if (num > max) {
                max = num;
            }
        }

        // Check every value in the range
        for (int current = min; current < max + 1; current++) {
            if (!seen[current]) {
                missing.add(current);
            }
        }

        return missing;
    }
}
