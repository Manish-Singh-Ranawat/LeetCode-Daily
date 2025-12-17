// Best Time to Buy and Sell Stock V - https://leetcode.com/problems/best-time-to-buy-and-sell-stock-v/description/?envType=daily-question&envId=2025-12-17

// You are given an integer array prices where prices[i] is the price of a stock in dollars on the ith day, and an integer k.

// You are allowed to make at most k transactions, where each transaction can be either of the following:
// - Normal transaction: Buy on day i, then sell on a later day j where i < j. You profit prices[j] - prices[i].
// - Short selling transaction: Sell on day i, then buy back on a later day j where i < j. You profit prices[i] - prices[j].

// Note that you must complete each transaction before starting another. Additionally, you can't buy or sell on the same day you are selling or buying back as part of a previous transaction.

// Return the maximum total profit you can earn by making at most k transactions.

// Input: prices = [1,7,9,8,2], k = 2
// Output: 14
// Explanation:
// We can make $14 of profit through 2 transactions:
// A normal transaction: buy the stock on day 0 for $1 then sell it on day 2 for $9.
// A short selling transaction: sell the stock on day 3 for $8 then buy back on day 4 for $2.

public class Dec17__BestTimeToBuyAndSellStockV {
    public static long maximumProfit(int[] prices, int k) {
        int n = prices.length;
        long[][] dp = new long[k + 1][3];
        for (int j = 1; j <= k; j++) {
            dp[j][1] = -prices[0];
            dp[j][2] = prices[0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = k; j > 0; j--) {
                dp[j][0] = Math.max(dp[j][0], Math.max(dp[j][1] + prices[i], dp[j][2] - prices[i]));
                dp[j][1] = Math.max(dp[j][1], dp[j - 1][0] - prices[i]);
                dp[j][2] = Math.max(dp[j][2], dp[j - 1][0] + prices[i]);
            }
        }

        return dp[k][0];
    }

    public static void main(String[] args) {
        int[] prices = { 1, 7, 9, 8, 2 };
        int k = 2;
        System.out.println(maximumProfit(prices, k));
        // 14
    }
}
