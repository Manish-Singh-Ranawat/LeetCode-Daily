// Minimum Operations to Make Array Sum Divisible by K - https://leetcode.com/problems/minimum-operations-to-make-array-sum-divisible-by-k/?envType=daily-question&envId=2025-11-29

// You are given an integer array nums and an integer k. You can perform the following operation any number of times:
// - Select an index i and replace nums[i] with nums[i] - 1.

// Return the minimum number of operations required to make the sum of the array divisible by k.

// Input: nums = [3,9,7], k = 5
// Output: 4
// Explanation: Perform 4 operations on nums[1] = 9. Now, nums = [3, 5, 7].
// The sum is 15, which is divisible by 5.

public class Nov29__MinimumOperationsToMakeArraySumDivisibleByK {
    public static int minOperations(int[] nums, int k) {
        int sum = 0;
        for (int num : nums)
            sum += num;
        return sum % k;
    }

    public static void main(String[] args) {
        int[] nums = { 3, 9, 7 };
        int k = 5;
        System.out.println(minOperations(nums, k));
        // 4
    }
}
