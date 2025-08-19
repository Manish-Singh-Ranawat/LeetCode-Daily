// Number of Zero-Filled Subarrays - https://leetcode.com/problems/number-of-zero-filled-subarrays/description/?envType=daily-question&envId=2025-08-19

// Given an integer array nums, return the number of subarrays filled with 0.

// A subarray is a contiguous non-empty sequence of elements within an array.

// Input: nums = [1,3,0,0,2,0,0,4]
// Output: 6
// Explanation: 
// There are 4 occurrences of [0] as a subarray.
// There are 2 occurrences of [0,0] as a subarray.
// There is no occurrence of a subarray with a size more than 2 filled with 0. Therefore, we return 6.

public class Aug19__NumberOfZeroFilledSubarrays {
    public static long zeroFilledSubarray(int[] nums) {
        long ans = 0;
        long streak = 0;
        for (int num : nums) {
            streak = num == 0 ? streak + 1 : 0;
            ans += streak;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 3, 0, 0, 2, 0, 0, 4 };
        System.out.println(zeroFilledSubarray(nums)); 
        // 6
    }
}
