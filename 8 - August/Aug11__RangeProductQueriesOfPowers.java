// Range Product Queries of Powers - https://leetcode.com/problems/range-product-queries-of-powers/description/?envType=daily-question&envId=2025-08-11

// Given a positive integer n, there exists a 0-indexed array called powers, composed of the minimum number of powers of 2 that sum to n. The array is sorted in non-decreasing order, and there is only one way to form the array.

// You are also given a 0-indexed 2D integer array queries, where queries[i] = [lefti, righti]. Each queries[i] represents a query where you have to find the product of all powers[j] with lefti <= j <= righti.

// Return an array answers, equal in length to queries, where answers[i] is the answer to the ith query. Since the answer to the ith query may be too large, each answers[i] should be returned modulo 109 + 7.

// Input: n = 15, queries = [[0,1],[2,2],[0,3]]
// Output: [2,4,64]
// Explanation:
// For n = 15, powers = [1,2,4,8]. It can be shown that powers cannot be a smaller size.
// Answer to 1st query: powers[0] * powers[1] = 1 * 2 = 2.
// Answer to 2nd query: powers[2] = 4.
// Answer to 3rd query: powers[0] * powers[1] * powers[2] * powers[3] = 1 * 2 * 4 * 8 = 64.
// Each answer modulo 109 + 7 yields the same answer, so [2,4,64] is returned.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Aug11__RangeProductQueriesOfPowers {
    public static int[] productQueries(int n, int[][] queries) {
        int mod = (int) 1e9 + 7;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                list.add((1 << i) % mod);
            }
        }
        int q = queries.length;
        int[] ans = new int[q];
        for (int i = 0; i < q; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            long cur = 1;
            for (int j = l; j <= r; j++)
                cur = (cur * list.get(j)) % mod;
            ans[i] = (int) cur;
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 15;
        int[][] queries = { { 0, 1 }, { 2, 2 }, { 0, 3 } };
        System.out.println(Arrays.toString(productQueries(n, queries)));
        // [2, 4, 64]
    }
}
