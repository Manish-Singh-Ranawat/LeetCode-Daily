// Partition Equal Subset Sum - https://leetcode.com/problems/partition-equal-subset-sum/submissions/1599051931/?envType=daily-question&envId=2025-04-07

// Given an integer array nums, return true if you can partition the array into two subsets such that the sum of the elements in both subsets is equal or false otherwise.

// Input: nums = [1,5,11,5]
// Output: true
// Explanation: The array can be partitioned as [1, 5, 5] and [11].

public class April7__PartitionEqualSubsetSum {
    public static boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; i++)
            sum += nums[i];
        return (sum % 2) == 0 ? subsetSumToK(n, sum / 2, nums) : false;
    }

    private static boolean subsetSumToK(int n, int k, int arr[]) {
        if (k == 0)
            return true;
        boolean[] dp = new boolean[k + 1];
        dp[0] = true;
        if (arr[0] <= k)
            dp[arr[0]] = true;
        for (int idx = 1; idx < n; idx++) {
            boolean[] temp = new boolean[k + 1];
            temp[0] = true;
            for (int target = 1; target <= k; target++) {
                boolean notTake = dp[target];
                boolean take = target >= arr[idx] ? dp[target - arr[idx]] : false;
                temp[target] = take || notTake;
            }
            dp = temp;
        }
        return dp[k];
    }

    public static void main(String[] args) {
       int[] nums = {1,5,11,5};
       System.out.println(canPartition(nums));
       // true
    }
}