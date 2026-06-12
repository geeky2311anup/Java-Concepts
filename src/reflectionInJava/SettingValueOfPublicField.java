import java.util.Arrays;

class Solution {
    /**
     * Calculates the minimum cost to buy all candies where for every 3 candies 
     * purchased, the cheapest one among the three is free.
     * * Time Complexity: O(N log N) due to dual-pivot quicksort.
     * Space Complexity: O(1) or O(log N) depending on the quicksort call stack.
     */
    public int minimumCost(int[] prices) {
        // Guard clause for safety
        if (prices == null || prices.length == 0) {
            return 0;
        }

        Arrays.sort(prices);
        int minimumTotalCost = 0;
        int index = prices.length - 1;

        // Process batches of 3 greedily from most expensive to cheapest
        while (index >= 1) {
            minimumTotalCost += prices[index];     // Most expensive in batch (Paid)
            minimumTotalCost += prices[index - 1]; // Second most expensive in batch (Paid)
            index -= 3;                            // Third item is free; skip it entirely
        }

        // Clean up remaining elements if array size is not a multiple of 3
        while (index >= 0) {
            minimumTotalCost += prices[index];
            index--;
        }

        return minimumTotalCost;
    }
}
