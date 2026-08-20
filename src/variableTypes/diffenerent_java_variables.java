class Solution {
    public List<Integer> findMissingElements(int[] numbers) {

        List<Integer> result = new ArrayList<>();

        if (numbers == null || numbers.length <= 1) {
            return result;
        }

        boolean[] present = new boolean[101];
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        for (int value : numbers) {
            present[value] = true;

            low = Math.min(low, value);
            high = Math.max(high, value);
        }

        for (int value = low; value <= high; value++) {
            if (!present[value]) {
                result.add(value);
            }
        }

        return result;
    }
}
