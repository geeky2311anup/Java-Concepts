class Solution {
    public List<Integer> findMissingElements(int[] numbers) {

        List<Integer> missing = new ArrayList<>();

        if (numbers == null || numbers.length < 2) {
            return missing;
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        // Find the minimum and maximum values
        // and mark every value that occurs.
        boolean[] seen = new boolean[101];

        for (int num : numbers) {
            seen[num] = true;

            if (num < min) {
                min = num;
            }

            if (num > max) {
                max = num;
            }
        }

        // Every number between min and max should be present.
        // If it was not seen, add it to the answer.
        for (int num = min + 1; num < max; num++) {
            if (!seen[num]) {
                missing.add(num);
            }
        }

        return missing;
    }
}
