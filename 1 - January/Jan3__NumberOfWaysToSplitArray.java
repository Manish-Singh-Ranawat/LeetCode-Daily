// Number of Ways to Split Array - https://leetcode.com/problems/number-of-ways-to-split-array/description/?envType=daily-question&envId=2025-01-03

// You are given a 0-indexed integer array nums of length n.

// nums contains a valid split at index i if the following are true:
// ~ The sum of the first i + 1 elements is greater than or equal to the sum of the last n - i - 1 elements.
// ~ There is at least one element to the right of i. That is, 0 <= i < n - 1.

// Return the number of valid splits in nums.

// Input: nums = [10,4,-8,7]
// Output: 2
// Explanation: 
// There are three ways of splitting nums into two non-empty parts:
// - Split nums at index 0. Then, the first part is [10], and its sum is 10. The second part is [4,-8,7], and its sum is 3. Since 10 >= 3, i = 0 is a valid split.
// - Split nums at index 1. Then, the first part is [10,4], and its sum is 14. The second part is [-8,7], and its sum is -1. Since 14 >= -1, i = 1 is a valid split.
// - Split nums at index 2. Then, the first part is [10,4,-8], and its sum is 6. The second part is [7], and its sum is 7. Since 6 < 7, i = 2 is not a valid split.
// Thus, the number of valid splits in nums is 2.

public class Jan3__NumberOfWaysToSplitArray {
    public static int waysToSplitArray(int[] nums) {
        int n = nums.length;
        long totalSum = 0;
        for (int i = 0; i < n; i++) {
            totalSum += (long) nums[i];
        }
        int count = 0;
        long curSum = 0;
        for (int i = 0; i < n - 1; i++) {
            curSum += (long) nums[i];
            if (curSum >= totalSum - curSum) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = { 10, 4, -8, 7 };
        System.out.println(waysToSplitArray(nums));
        // 2
    }
}
