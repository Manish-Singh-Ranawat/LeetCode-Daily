// Minimum Number of Increments on Subarrays to Form a Target Array - https://leetcode.com/problems/minimum-number-of-increments-on-subarrays-to-form-a-target-array/?envType=daily-question&envId=2025-10-30

// You are given an integer array target. You have an integer array initial of the same size as target with all elements initially zeros.

// In one operation you can choose any subarray from initial and increment each value by one.

// Return the minimum number of operations to form a target array from initial.

// The test cases are generated so that the answer fits in a 32-bit integer.

// Input: target = [1,2,3,2,1]
// Output: 3
// Explanation: We need at least 3 operations to form the target array from the initial array.
// [0,0,0,0,0] increment 1 from index 0 to 4 (inclusive).
// [1,1,1,1,1] increment 1 from index 1 to 3 (inclusive).
// [1,2,2,2,1] increment 1 at index 2.
// [1,2,3,2,1] target array is formed.

public class Oct30__MinimumNumberOfIncrementsOnSubarraysToFormTargetArray {
    public static int minNumberOperations(int[] target) {
        int n = target.length;
        int ans = target[0];
        for (int i = 1; i < n; i++)
            ans += Math.max(target[i] - target[i - 1], 0);
        return ans;
    }

    public static void main(String[] args) {
        int[] target = { 1, 2, 3, 2, 1 };
        System.out.println(minNumberOperations(target));
        // 3
    }
}
