// Maximum Difference Between Increasing Elements - https://leetcode.com/problems/maximum-difference-between-increasing-elements/description/?envType=daily-question&envId=2025-06-16

// Given a 0-indexed integer array nums of size n, find the maximum difference between nums[i] and nums[j] (i.e., nums[j] - nums[i]), such that 0 <= i < j < n and nums[i] < nums[j].

// Return the maximum difference. If no such i and j exists, return -1.

// Input: nums = [7,1,5,4]
// Output: 4
// Explanation: The maximum difference occurs with i = 1 and j = 2, nums[j] - nums[i] = 5 - 1 = 4. Note that with i = 1 and j = 0, the difference nums[j] - nums[i] = 7 - 1 = 6, but i > j, so it is not valid.

public class June16__MaximumDifferenceBetweenIncreasingElements {
    public static int maximumDifference(int[] nums) {
        int n = nums.length;
        int ans = -1;
        int min = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] > min)
                ans = Math.max(ans, nums[i] - min);
            else
                min = nums[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = { 7, 1, 5, 4 };
        System.out.println(maximumDifference(nums));
        // 4
    }
}
