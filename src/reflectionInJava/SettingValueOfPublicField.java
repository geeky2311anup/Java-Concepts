class Solution {
    public int minimumCost(int[] prices) {
        // Sort prices in ascending order so we can process
        // the most expensive candies first.
        Arrays.sort(prices);

        int minimumTotalCost = 0;
        int candyCount = 0;

        // Traverse from the largest price to the smallest.
        for (int index = prices.length - 1; index >= 0; index--) {
            candyCount++;

            /*
             * Offer:
             * For every 3 candies purchased, the cheapest one is free.
             * Since we are processing in descending order,
             * every 3rd candy in this traversal represents
             * the free candy and should not be added to the cost.
             */
            if (candyCount % 3 != 0) {
                minimumTotalCost += prices[index];
            }
        }

        return minimumTotalCost;
    }
}
