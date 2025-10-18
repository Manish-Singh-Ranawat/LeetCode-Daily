// Maximum Number of Distinct Elements After Operations - https://leetcode.com/problems/maximum-number-of-distinct-elements-after-operations/description/?envType=daily-question&envId=2025-10-18

// You are given an integer array nums and an integer k.

// You are allowed to perform the following operation on each element of the array at most once:
// - Add an integer in the range [-k, k] to the element.

// Return the maximum possible number of distinct elements in nums after performing the operations.

// Input: nums = [1,2,2,3,3,4], k = 2
// Output: 6
// Explanation: nums changes to [-1, 0, 1, 2, 3, 4] after performing operations on the first four elements.

import java.util.Arrays;

public class Oct18__MaximumNumberOfDistinctElementsAfterOperations {
    public static int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);
        int cnt = 0;
        int prev = Integer.MIN_VALUE;
        for (int num : nums) {
            int curr = Math.min(Math.max(num - k, prev + 1), num + k);
            if (curr > prev) {
                cnt++;
                prev = curr;
            }
        }
        return cnt;
    }


    public static void main(String[] args) {
        int k = 2;
        int[] nums = {1,2,2,3,3,4};
        System.out.println(maxDistinctElements(nums, k));
        // 6
    }
}
