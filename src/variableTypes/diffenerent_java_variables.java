class Solution {
    public List<Integer> findMissingElements(int[] numbers) {

        boolean[] visited = new boolean[101];
        List<Integer> result = new ArrayList<>();

        if (numbers == null || numbers.length == 0) {
            return result;
        }

        int low = numbers[0];
        int high = numbers[0];

        // Mark visited numbers and find min/max
        for (int value : numbers) {
            visited[value] = true;
            low = Math.min(low, value);
            high = Math.max(high, value);
        }

        // Collect missing numbers between min and max
        for (int value = low; value <= high; value++) {
            if (!visited[value]) {
                result.add(value);
            }
        }

        return result;
    }
}
