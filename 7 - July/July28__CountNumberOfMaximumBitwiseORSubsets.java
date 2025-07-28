// Count Number of Maximum Bitwise-OR Subsets - https://leetcode.com/problems/count-number-of-maximum-bitwise-or-subsets/description/?envType=daily-question&envId=2025-07-28

// Given an integer array nums, find the maximum possible bitwise OR of a subset of nums and return the number of different non-empty subsets with the maximum bitwise OR.

// An array a is a subset of an array b if a can be obtained from b by deleting some (possibly zero) elements of b. Two subsets are considered different if the indices of the elements chosen are different.

// The bitwise OR of an array a is equal to a[0] OR a[1] OR ... OR a[a.length - 1] (0-indexed).

// Input: nums = [3,1]
// Output: 2
// Explanation: The maximum possible bitwise OR of a subset is 3. There are 2 subsets with a bitwise OR of 3: [3], [3,1]

public class July28__CountNumberOfMaximumBitwiseORSubsets {
    public static int countMaxOrSubsets(int[] nums) {
        int n = nums.length;
        int max = nums[0];
        for (int i = 1; i < n; i++) {
            max |= nums[i];
        }
        return helper(0, nums, 0, max);
    }

    private static int helper(int i, int[] nums, int or, int max) {
        if (i == nums.length) {
            return (or == max) ? 1 : 0;
        }
        return helper(i + 1, nums, or | nums[i], max) +
                helper(i + 1, nums, or, max);
    }

    public static void main(String[] args) {
        int[] nums = {3, 1};
        System.out.println(countMaxOrSubsets(nums));
        // 2
    }
}
