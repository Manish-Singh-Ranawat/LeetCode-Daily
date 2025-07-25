// Maximum Unique Subarray Sum After Deletion - https://leetcode.com/problems/maximum-unique-subarray-sum-after-deletion/description/?envType=daily-question&envId=2025-07-25

// You are given an integer array nums.

// You are allowed to delete any number of elements from nums without making it empty. After performing the deletions, select a subarray of nums such that:
// 1 -  All elements in the subarray are unique.
// 2 - The sum of the elements in the subarray is maximized.

// Return the maximum sum of such a subarray.

// Input: nums = [1,2,3,4,5]
// Output: 15
// Explanation: Select the entire array without deleting any element to obtain the maximum sum.

import java.util.HashSet;
import java.util.Set;

public class July25__MaximumUniqueSubarraySumAfterDeletion {
    public static int maxSum(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num >= 0 && !set.contains(num)) {
                sum += num;
                set.add(num);
            }
            max = Math.max(max, num);
        }
        return max < 0 ? max : sum;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5 };
        System.out.println(maxSum(nums));
        // 15
    }
}
