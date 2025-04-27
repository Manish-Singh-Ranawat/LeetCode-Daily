// Count Subarrays of Length Three With a Condition - https://leetcode.com/problems/count-subarrays-of-length-three-with-a-condition/?envType=daily-question&envId=2025-04-27

// Given an integer array nums, return the number of subarrays of length 3 such that the sum of the first and third numbers equals exactly half of the second number.

// Input: nums = [1,2,1,4,1]
// Output: 1
// Explanation: Only the subarray [1,4,1] contains exactly 3 elements where the sum of the first and third numbers equals half the middle number.

public class April27__CountSubarraysOfLengthThreeWithCondition {
    public static int countSubarrays(int[] nums) {
        int n = nums.length;
        int count = 0;
        for (int i = 0; i < n - 2; i++) {
            if ((nums[i] + nums[i + 2]) * 2 == nums[i + 1])
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 1, 4, 1 };
        System.out.println(countSubarrays(nums));
        // 1
    }
}
