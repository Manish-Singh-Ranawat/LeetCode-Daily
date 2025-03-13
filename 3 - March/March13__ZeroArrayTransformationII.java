// Zero Array Transformation II - https://leetcode.com/problems/zero-array-transformation-ii/description/?envType=daily-question&envId=2025-03-13

// You are given an integer array nums of length n and a 2D array queries where queries[i] = [li, ri, vali].

// Each queries[i] represents the following action on nums:
// - Decrement the value at each index in the range [li, ri] in nums by at most vali.
// - The amount by which each value is decremented can be chosen independently for each index.

// A Zero Array is an array with all its elements equal to 0.

// Return the minimum possible non-negative value of k, such that after processing the first k queries in sequence, nums becomes a Zero Array. If no such k exists, return -1.

// Input: nums = [2,0,2], queries = [[0,2,1],[0,2,1],[1,1,3]]
// Output: 2
// Explanation:
// - For i = 0 (l = 0, r = 2, val = 1):
// Decrement values at indices [0, 1, 2] by [1, 0, 1] respectively.
// The array will become [1, 0, 1].
// - For i = 1 (l = 0, r = 2, val = 1):
// Decrement values at indices [0, 1, 2] by [1, 0, 1] respectively.
// The array will become [0, 0, 0], which is a Zero Array. Therefore, the minimum value of k is 2.

public class March13__ZeroArrayTransformationII {
    public static int minZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] diff = new int[n + 1];
        int sum = 0;
        int k = 0;
        for (int i = 0; i < n; i++) {
            while (sum + diff[i] < nums[i]) {
                k++;
                if (k > queries.length)
                    return -1;
                int l = queries[k - 1][0];
                int r = queries[k - 1][1];
                int val = queries[k - 1][2];
                if (r >= i) {
                    diff[Math.max(l, i)] += val;
                    diff[r + 1] -= val;
                }
            }
            sum += diff[i];
        }
        return k;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 0, 2 };
        int[][] queries = { { 0, 2, 1 }, { 0, 2, 1 }, { 1, 1, 3 } };
        System.out.println(minZeroArray(nums, queries));
        // 2
    }
}
