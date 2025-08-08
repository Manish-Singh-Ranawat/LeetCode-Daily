// Soup Servings - https://leetcode.com/problems/soup-servings/description/?envType=daily-question&envId=2025-08-08

// You have two soups, A and B, each starting with n mL. On every turn, one of the following four serving operations is chosen at random, each with probability 0.25 independent of all previous turns:
// - pour 100 mL from type A and 0 mL from type B
// - pour 75 mL from type A and 25 mL from type B
// - pour 50 mL from type A and 50 mL from type B
// - pour 25 mL from type A and 75 mL from type B

// Note:
// - There is no operation that pours 0 mL from A and 100 mL from B.
// - The amounts from A and B are poured simultaneously during the turn.
// - If an operation asks you to pour more than you have left of a soup, pour all that remains of that soup.

// The process stops immediately after any turn in which one of the soups is used up.

// Return the probability that A is used up before B, plus half the probability that both soups are used up in the same turn. Answers within 10-5 of the actual answer will be accepted.

// Input: n = 50
// Output: 0.62500
// Explanation: 
// If we perform either of the first two serving operations, soup A will become empty first.
// If we perform the third operation, A and B will become empty at the same time.
// If we perform the fourth operation, B will become empty first.
// So the total probability of A becoming empty first plus half the probability that A and B become empty at the same time, is 0.25 * (1 + 1 + 0.5 + 0) = 0.625.

import java.util.HashMap;
import java.util.Map;

public class Aug8__SoupServings {
    public static double soupServings(int n) {
        int m = (int) Math.ceil(n / 25.0);
        Map<Integer, Map<Integer, Double>> dp = new HashMap<>();
        dp.put(0, new HashMap<>());
        dp.get(0).put(0, 0.5);
        for (int k = 1; k <= m; k++) {
            dp.put(k, new HashMap<>());
            dp.get(0).put(k, 1.0);
            dp.get(k).put(0, 0.0);
            for (int j = 1; j <= k; j++) {
                dp.get(j).put(k, calculateDP(j, k, dp));
                dp.get(k).put(j, calculateDP(k, j, dp));
            }
            if (dp.get(k).get(k) > 1 - 1e-5) {
                return 1;
            }
        }
        return dp.get(m).get(m);
    }

    private static double calculateDP(int i, int j, Map<Integer, Map<Integer, Double>> dp) {
        return (dp.get(Math.max(0, i - 4)).get(j)
                + dp.get(Math.max(0, i - 3)).get(j - 1)
                + dp.get(Math.max(0, i - 2)).get(Math.max(0, j - 2))
                + dp.get(i - 1).get(Math.max(0, j - 3))) / 4;
    }

    public static void main(String[] args) {
        int n = 50;
        System.out.println(soupServings(n)); 
    }
}
