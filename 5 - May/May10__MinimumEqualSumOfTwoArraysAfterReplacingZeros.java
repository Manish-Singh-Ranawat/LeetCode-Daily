// Minimum Equal Sum of Two Arrays After Replacing Zeros - https://leetcode.com/problems/minimum-equal-sum-of-two-arrays-after-replacing-zeros/?envType=daily-question&envId=2025-05-10

// You are given two arrays nums1 and nums2 consisting of positive integers.

// You have to replace all the 0's in both arrays with strictly positive integers such that the sum of elements of both arrays becomes equal.

// Return the minimum equal sum you can obtain, or -1 if it is impossible.

// Input: nums1 = [3,2,0,1,0], nums2 = [6,5,0]
// Output: 12
// Explanation: We can replace 0's in the following way:
// - Replace the two 0's in nums1 with the values 2 and 4. The resulting array is nums1 = [3,2,2,1,4].
// - Replace the 0 in nums2 with the value 1. The resulting array is nums2 = [6,5,1].
// Both arrays have an equal sum of 12. It can be shown that it is the minimum sum we can obtain.

public class May10__MinimumEqualSumOfTwoArraysAfterReplacingZeros {
    public static long minSum(int[] nums1, int[] nums2) {
        long sum1 = 0, sum2 = 0;
        long zero1 = 0, zero2 = 0;
        for (int num : nums1) {
            sum1 += num;
            if (num == 0) {
                sum1++;
                zero1++;
            }
        }
        for (int num : nums2) {
            sum2 += num;
            if (num == 0) {
                sum2++;
                zero2++;
            }
        }
        if ((zero1 == 0 && sum2 > sum1) || (zero2 == 0 && sum1 > sum2)) {
            return -1;
        }
        return Math.max(sum1, sum2);
    }

    public static void main(String[] args) {
        int[] nums1 = { 3, 2, 0, 1, 0 };
        int[] nums2 = { 6, 5, 0 };
        System.out.println(minSum(nums1, nums2));
        // 12
    }
}
