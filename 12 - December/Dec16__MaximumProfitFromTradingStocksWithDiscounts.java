// Maximum Profit from Trading Stocks with Discounts - https://leetcode.com/problems/maximum-profit-from-trading-stocks-with-discounts/description/?envType=daily-question&envId=2025-12-16

// You are given an integer n, representing the number of employees in a company. Each employee is assigned a unique ID from 1 to n, and employee 1 is the CEO. You are given two 1-based integer arrays, present and future, each of length n, where:
// - present[i] represents the current price at which the ith employee can buy a stock today.
// - future[i] represents the expected price at which the ith employee can sell the stock tomorrow.

// The company's hierarchy is represented by a 2D integer array hierarchy, where hierarchy[i] = [ui, vi] means that employee ui is the direct boss of employee vi.

// Additionally, you have an integer budget representing the total funds available for investment.

// However, the company has a discount policy: if an employee's direct boss purchases their own stock, then the employee can buy their stock at half the original price (floor(present[v] / 2)).

// Return the maximum profit that can be achieved without exceeding the given budget.

// Note:
// - You may buy each stock at most once.
// - You cannot use any profit earned from future stock prices to fund additional investments and must buy only from budget.

// Input: n = 2, present = [1,2], future = [4,3], hierarchy = [[1,2]], budget = 3
// Output: 5
// Explanation:
// Employee 1 buys the stock at price 1 and earns a profit of 4 - 1 = 3.
// Since Employee 1 is the direct boss of Employee 2, Employee 2 gets a discounted price of floor(2 / 2) = 1.
// Employee 2 buys the stock at price 1 and earns a profit of 3 - 1 = 2.
// The total buying cost is 1 + 1 = 2 <= budget. Thus, the maximum total profit achieved is 3 + 2 = 5.

import java.util.ArrayList;
import java.util.List;

public class Dec16__MaximumProfitFromTradingStocksWithDiscounts {

    public static int maxProfit(int n, int[] present, int[] future, int[][] hierarchy, int budget) {
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < n; i++)
            g.add(new ArrayList<>());
        for (int[] e : hierarchy)
            g.get(e[0] - 1).add(e[1] - 1);
        return dfs(0, present, future, g, budget).dp0[budget];
    }

    private static Result dfs(int u, int[] present, int[] future, List<List<Integer>> g, int budget) {
        int cost = present[u];
        int dCost = present[u] / 2;
        int[] dp0 = new int[budget + 1];
        int[] dp1 = new int[budget + 1];
        int[] subProfit0 = new int[budget + 1];
        int[] subProfit1 = new int[budget + 1];
        int uSize = cost;
        for (int v : g.get(u)) {
            Result child = dfs(v, present, future, g, budget);
            uSize += child.size;
            for (int i = budget; i >= 0; i--) {
                for (int sub = 0; sub <= Math.min(child.size, i); sub++) {
                    subProfit0[i] = Math.max(subProfit0[i], subProfit0[i - sub] + child.dp0[sub]);
                    subProfit1[i] = Math.max(subProfit1[i], subProfit1[i - sub] + child.dp1[sub]);
                }
            }
        }
        for (int i = 0; i <= budget; i++) {
            dp0[i] = subProfit0[i];
            dp1[i] = subProfit0[i];
            if (i >= dCost) {
                dp1[i] = Math.max(
                        dp1[i],
                        subProfit1[i - dCost] + future[u] - dCost);
            }
            if (i >= cost)
                dp0[i] = Math.max(dp0[i], subProfit1[i - cost] + future[u] - cost);
        }
        return new Result(dp0, dp1, uSize);
    }

    public static void main(String[] args) {
        int n = 2;
        int[] present = { 1, 2 };
        int[] future = { 4, 3 };
        int[][] hierarchy = { { 1, 2 } };
        int budget = 3;
        System.out.println(maxProfit(n, present, future, hierarchy, budget));
        // Expected output: 5
    }
}

class Result {
    int[] dp0;
    int[] dp1;
    int size;

    Result(int[] dp0, int[] dp1, int size) {
        this.dp0 = dp0;
        this.dp1 = dp1;
        this.size = size;
    }
}
