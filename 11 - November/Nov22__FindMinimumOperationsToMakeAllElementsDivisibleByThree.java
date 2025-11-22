// Find Minimum Operations to Make All Elements Divisible by Three - https://leetcode.com/problems/find-minimum-operations-to-make-all-elements-divisible-by-three/description/?envType=daily-question&envId=2025-11-22

// You are given an integer array nums. In one operation, you can add or subtract 1 from any element of nums.

// Return the minimum number of operations to make all elements of nums divisible by 3.

// Input: nums = [1,2,3,4]
// Output: 3
// Explanation: All array elements can be made divisible by 3 using 3 operations:
// - Subtract 1 from 1.
// - Add 1 to 2.
// - Subtract 1 from 4.

public class Nov22__FindMinimumOperationsToMakeAllElementsDivisibleByThree {
    public static int minimumOperations(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            int rem = num % 3;
            ans += Math.min(rem, 3 - rem);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4 };
        System.out.println(minimumOperations(nums));
        // 3
    }
}
