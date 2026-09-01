class Solution {
    public List<Integer> findMissingElements(int[] numbers) {
        List<Integer> missing = new ArrayList<>();

        if (numbers == null || numbers.length < 2) {
            return missing;
        }

        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;

        boolean[] seen = new boolean[101];

        for (int num : numbers) {
            seen[num] = true;

            if (num < minValue) {
                minValue = num;
            }

            if (num > maxValue) {
                maxValue = num;
            }
        }

        int current = minValue + 1;

        while (current < maxValue) {
            if (!seen[current]) {
                missing.add(current);
            }
            current++;
        }

        return missing;
    }
}
