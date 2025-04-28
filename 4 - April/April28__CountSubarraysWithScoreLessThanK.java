// Count Subarrays With Score Less Than K - https://leetcode.com/problems/count-subarrays-with-score-less-than-k/description/?envType=daily-question&envId=2025-04-28

// The score of an array is defined as the product of its sum and its length.
// - For example, the score of [1, 2, 3, 4, 5] is (1 + 2 + 3 + 4 + 5) * 5 = 75.

// Given a positive integer array nums and an integer k, return the number of non-empty subarrays of nums whose score is strictly less than k.

// A subarray is a contiguous sequence of elements within an array.

// Input: nums = [2,1,4,3,5], k = 10
// Output: 6
// Explanation:
// The 6 subarrays having scores less than 10 are:
// - [2] with score 2 * 1 = 2.
// - [1] with score 1 * 1 = 1.
// - [4] with score 4 * 1 = 4.
// - [3] with score 3 * 1 = 3. 
// - [5] with score 5 * 1 = 5.
// - [2,1] with score (2 + 1) * 2 = 6.
// Note that subarrays such as [1,4] and [4,3,5] are not considered because their scores are 10 and 36 respectively, while we need scores strictly less than 10.

public class April28__CountSubarraysWithScoreLessThanK {
    public static long countSubarrays(int[] nums, long k) {
        int n = nums.length;
        int l = 0;
        int r = 0;
        long sum = 0;
        long count = 0;
        while (r < n) {
            sum += nums[r];
            while (l <= r && sum * (r - l + 1) >= k) {
                sum -= nums[l];
                l++;
            }
            count += (r - l + 1);
            r++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 1, 4, 3, 5 };
        long k = 10;
        System.out.println(countSubarrays(nums, k));
        // 6
    }
}
