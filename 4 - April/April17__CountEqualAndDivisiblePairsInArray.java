//  Count Equal and Divisible Pairs in an Array - https://leetcode.com/problems/count-equal-and-divisible-pairs-in-an-array/?envType=daily-question&envId=2025-04-17

// Given a 0-indexed integer array nums of length n and an integer k, return the number of pairs (i, j) where 0 <= i < j < n, such that nums[i] == nums[j] and (i * j) is divisible by k.

// Input: nums = [3,1,2,2,2,1,3], k = 2
// Output: 4
// Explanation:
// There are 4 pairs that meet all the requirements:
// - nums[0] == nums[6], and 0 * 6 == 0, which is divisible by 2.
// - nums[2] == nums[3], and 2 * 3 == 6, which is divisible by 2.
// - nums[2] == nums[4], and 2 * 4 == 8, which is divisible by 2.
// - nums[3] == nums[4], and 3 * 4 == 12, which is divisible by 2.

public class April17__CountEqualAndDivisiblePairsInArray {
    public static int countPairs(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] == nums[j] && (i * j) % k == 0)
                    count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = { 3, 1, 2, 2, 2, 1, 3 };
        int k = 2;
        System.out.println(countPairs(nums, k));
        // 4
    }
}
