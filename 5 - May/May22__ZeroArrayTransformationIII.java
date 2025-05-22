// Zero Array Transformation III - https://leetcode.com/problems/zero-array-transformation-iii/description/?envType=daily-question&envId=2025-05-22

// You are given an integer array nums of length n and a 2D array queries where queries[i] = [li, ri].

// Each queries[i] represents the following action on nums:
// - Decrement the value at each index in the range [li, ri] in nums by at most 1.
// - The amount by which the value is decremented can be chosen independently for each index.

// A Zero Array is an array with all its elements equal to 0.

// Return the maximum number of elements that can be removed from queries, such that nums can still be converted to a zero array using the remaining queries. If it is not possible to convert nums to a zero array, return -1.

// Input: nums = [2,0,2], queries = [[0,2],[0,2],[1,1]]
// Output: 1
// Explanation:
// After removing queries[2], nums can still be converted to a zero array.
// Using queries[0], decrement nums[0] and nums[2] by 1 and nums[1] by 0.
// Using queries[1], decrement nums[0] and nums[2] by 1 and nums[1] by 0.

import java.util.Arrays;
import java.util.PriorityQueue;

public class May22__ZeroArrayTransformationIII {
    public static int maxRemoval(int[] nums, int[][] queries) {
        int n = nums.length;
        int q = queries.length;
        Arrays.sort(queries, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int[] diff = new int[n + 1];
        int sum = 0;
        int j = 0;
        for (int i = 0; i < n; i++) {
            sum += diff[i];
            while (j < q && queries[j][0] == i) {
                pq.offer(queries[j][1]);
                j++;
            }
            while (nums[i] > sum && !pq.isEmpty() && pq.peek() >= i) {
                sum++;
                diff[pq.poll() + 1] -= 1;
            }
            if (nums[i] > sum)
                return -1;
        }
        return pq.size();
    }

    public static void main(String[] args) {
        int[] nums = { 2, 0, 2 };
        int[][] queries = { { 0, 2 }, { 0, 2 }, { 1, 1 } };
        System.out.println(maxRemoval(nums, queries));
        // 1
    }
}
