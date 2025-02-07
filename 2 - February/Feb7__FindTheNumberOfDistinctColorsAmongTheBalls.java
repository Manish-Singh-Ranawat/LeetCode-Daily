// Find the Number of Distinct Colors Among the Balls - https://leetcode.com/problems/find-the-number-of-distinct-colors-among-the-balls/description/?envType=daily-question&envId=2025-02-07

// You are given an integer limit and a 2D array queries of size n x 2.

// There are limit + 1 balls with distinct labels in the range [0, limit]. Initially, all balls are uncolored. For every query in queries that is of the form [x, y], you mark ball x with the color y. After each query, you need to find the number of distinct colors among the balls.

// Return an array result of length n, where result[i] denotes the number of distinct colors after ith query.

// Note that when answering a query, lack of a color will not be considered as a color.

// Input: limit = 4, queries = [[1, 4], [2, 5], [1, 3], [3, 4]]
// Output: [1, 2, 2, 3]

// Explanation:
// After query 0, ball 1 has color 4.
// After query 1, ball 1 has color 4, and ball 2 has color 5.
// After query 2, ball 1 has color 3, and ball 2 has color 5.
// After query 3, ball 1 has color 3, ball 2 has color 5, and ball 3 has color 4.

import java.util.Arrays;
import java.util.HashMap;

public class Feb7__FindTheNumberOfDistinctColorsAmongTheBalls {
    public static int[] queryResults(int limit, int[][] queries) {
        HashMap<Integer, Integer> ballColorMap = new HashMap<>();
        HashMap<Integer, Integer> colorFrequencyMap = new HashMap<>();
        int n = queries.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            int ballId = queries[i][0];
            int newColor = queries[i][1];
            if (ballColorMap.containsKey(ballId)) {
                int oldColor = ballColorMap.get(ballId);
                int oldColorCount = colorFrequencyMap.get(oldColor);
                if (oldColorCount == 1)
                    colorFrequencyMap.remove(oldColor);
                else
                    colorFrequencyMap.put(oldColor, oldColorCount - 1);
            }
            ballColorMap.put(ballId, newColor);
            colorFrequencyMap.put(newColor, colorFrequencyMap.getOrDefault(newColor, 0) + 1);
            result[i] = colorFrequencyMap.size();
        }
        return result;
    }

    public static void main(String[] args) {
        int limit = 4;
        int[][] queries = { { 1, 4 }, { 2, 5 }, { 1, 3 }, { 3, 4 } };
        System.out.println(Arrays.toString(queryResults(limit, queries)));
        // [1, 2, 2, 3]
    }
}
