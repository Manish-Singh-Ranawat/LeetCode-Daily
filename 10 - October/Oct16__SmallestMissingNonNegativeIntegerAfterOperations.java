// Smallest Missing Non-negative Integer After Operations - https://leetcode.com/problems/smallest-missing-non-negative-integer-after-operations/description/?envType=daily-question&envId=2025-10-16

// You are given a 0-indexed integer array nums and an integer value.

// In one operation, you can add or subtract value from any element of nums.
// - For example, if nums = [1,2,3] and value = 2, you can choose to subtract value from nums[0] to make nums = [-1,2,3].

// The MEX (minimum excluded) of an array is the smallest missing non-negative integer in it.
// - For example, the MEX of [-1,2,3] is 0 while the MEX of [1,0,3] is 2.

// Return the maximum MEX of nums after applying the mentioned operation any number of times.

// Input: nums = [1,-10,7,13,6,8], value = 5
// Output: 4
// Explanation: One can achieve this result by applying the following operations:
// - Add value to nums[1] twice to make nums = [1,0,7,13,6,8]
// - Subtract value from nums[2] once to make nums = [1,0,2,13,6,8]
// - Subtract value from nums[3] twice to make nums = [1,0,2,3,6,8]
// The MEX of nums is 4. It can be shown that 4 is the maximum MEX we can achieve.

public class Oct16__SmallestMissingNonNegativeIntegerAfterOperations {
    public static int findSmallestInteger(int[] nums, int value) {
        int[] remainderCount = new int[value];
        for (int num : nums) {
            int v = ((num % value) + value) % value;
            remainderCount[v]++;
        }
        int mex = 0;
        while (remainderCount[mex % value] > 0) {
            remainderCount[mex % value]--;
            mex++;
        }
        return mex;
    }

    public static void main(String[] args) {
        int value = 5;
        int[] nums = { 1, -10, 7, 13, 6, 8 };
        System.out.println(findSmallestInteger(nums, value));
        // 4
    }
}