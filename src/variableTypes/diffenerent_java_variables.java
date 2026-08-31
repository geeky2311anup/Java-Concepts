class Solution {
    public List<Integer> findMissingElements(int[] numbers) {
        List<Integer> result = new ArrayList<>();

        if (numbers == null || numbers.length <= 1) {
            return result;
        }

        int low = numbers[0];
        int high = numbers[0];

        boolean[] present = new boolean[101];

        for (int value : numbers) {
            present[value] = true;

            low = Math.min(low, value);
            high = Math.max(high, value);
        }

        for (int value = low + 1; value < high; value++) {
            if (!present[value]) {
                result.add(value);
            }
        }

        return result;
    }
}
