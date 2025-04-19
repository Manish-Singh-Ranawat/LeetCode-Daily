// Count the Number of Fair Pairs - https://leetcode.com/problems/count-the-number-of-fair-pairs/description/?envType=daily-question&envId=2025-04-19

// Given a 0-indexed integer array nums of size n and two integers lower and upper, return the number of fair pairs.

// A pair (i, j) is fair if:
// - 0 <= i < j < n, and
// - lower <= nums[i] + nums[j] <= upper

// Input: nums = [0,1,7,4,4,5], lower = 3, upper = 6
// Output: 6
// Explanation: There are 6 fair pairs: (0,3), (0,4), (0,5), (1,3), (1,4), and (1,5).

import java.util.Arrays;

public class April19__CountTheNumberOfFairPairs {
    public static long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        return lowerBound(nums, upper + 1) - lowerBound(nums, lower);
    }

    private static long lowerBound(int[] nums, int value) {
        int left = 0;
        int right = nums.length - 1;
        long result = 0;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum < value) {
                result += (right - left);
                left++;
            } else {
                right--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = { 0, 1, 7, 4, 4, 5 };
        int lower = 3;
        int upper = 6;
        System.out.println(countFairPairs(nums, lower, upper));
        // 6
    }
}
