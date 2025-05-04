// Number of Equivalent Domino Pairs - https://leetcode.com/problems/number-of-equivalent-domino-pairs/?envType=daily-question&envId=2025-05-04

// Given a list of dominoes, dominoes[i] = [a, b] is equivalent to dominoes[j] = [c, d] if and only if either (a == c and b == d), or (a == d and b == c) - that is, one domino can be rotated to be equal to another domino.

// Return the number of pairs (i, j) for which 0 <= i < j < dominoes.length, and dominoes[i] is equivalent to dominoes[j].

// Input: dominoes = [[1,2],[1,2],[1,1],[1,2],[2,2]]
// Output: 3

import java.util.HashMap;

public class May4__NumberOfEquivalentDominoPairs {
    public static int numEquivDominoPairs(int[][] dominoes) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (int[] d : dominoes) {
            int val = d[0] > d[1] ? 10 * d[0] + d[1] : 10 * d[1] + d[0];
            ans += map.getOrDefault(val, 0);
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] dominoes = { { 1, 2 }, { 1, 2 }, { 1, 1 }, { 1, 2 }, { 2, 2 } };
        System.out.println(numEquivDominoPairs(dominoes));
        // 3
    }
}
