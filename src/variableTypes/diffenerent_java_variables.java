class Solution {
    public List<Integer> findMissingElements(int[] numbers) {

        boolean[] visited = new boolean[101];
        List<Integer> result = new ArrayList<>();

        int low = numbers[0];
        int high = numbers[0];

        for (int i = 0; i < numbers.length; i++) {
            int value = numbers[i];
            visited[value] = true;

            if (value < low) {
                low = value;
            } else if (value > high) {
                high = value;
            }
        }

        for (int value = low; value <= high; value++) {
            if (visited[value] == false) {
                result.add(value);
            }
        }

        return result;
    }
}
