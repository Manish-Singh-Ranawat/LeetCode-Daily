// Minimum Operations to Make Array Elements Zero - https://leetcode.com/problems/minimum-operations-to-make-array-elements-zero/description/?envType=daily-question&envId=2025-09-06

// You are given a 2D array queries, where queries[i] is of the form [l, r]. Each queries[i] defines an array of integers nums consisting of elements ranging from l to r, both inclusive.

// In one operation, you can:
// - Select two integers a and b from the array.
// - Replace them with floor(a / 4) and floor(b / 4).

// Your task is to determine the minimum number of operations required to reduce all elements of the array to zero for each query. Return the sum of the results for all queries.

// Input: queries = [[1,2],[2,4]]
// Output: 3
// Explanation:
// For queries[0]:
// The initial array is nums = [1, 2].
// In the first operation, select nums[0] and nums[1]. The array becomes [0, 0].
// The minimum number of operations required is 1.
// For queries[1]:
// The initial array is nums = [2, 3, 4].
// In the first operation, select nums[0] and nums[2]. The array becomes [0, 3, 1].
// In the second operation, select nums[1] and nums[2]. The array becomes [0, 0, 0].
// The minimum number of operations required is 2.
// The output is 1 + 2 = 3.

public class Sept6__MinimumOperationsToMakeArrayElementsZero {
    public static long minOperations(int[][] queries) {
        long ans = 0;
        for (int[] q : queries) {
            long l = (long) q[0];
            long r = (long) q[1];
            long steps = solve(l, r);
            ans += (steps + 1) / 2;
        }
        return ans;
    }

    private static long solve(long l, long r) {
        long steps = 0;
        long L = 1;
        long d = 1;
        while (L <= r) {
            long R = 4 * L - 1;
            long start = Math.max(l, L);
            long end = Math.min(r, R);
            if (start <= end) {
                steps += (end - start + 1) * d;
            }
            d++;
            L = 4 * L;
        }
        return steps;
    }

    public static void main(String[] args) {
        int[][] queries = { { 1, 2 }, { 2, 4 } };
        System.out.println(minOperations(queries));
        // 3
    }
}
