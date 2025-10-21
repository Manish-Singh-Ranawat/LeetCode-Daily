// Maximum Frequency of an Element After Performing Operations I - https://leetcode.com/problems/maximum-frequency-of-an-element-after-performing-operations-i/?envType=daily-question&envId=2025-10-21

// You are given an integer array nums and two integers k and numOperations.

// You must perform an operation numOperations times on nums, where in each operation you:
// - Select an index i that was not selected in any previous operations.
// - Add an integer in the range [-k, k] to nums[i].

// Return the maximum possible frequency of any element in nums after performing the operations.

// Input: nums = [1,4,5], k = 1, numOperations = 2
// Output: 2
// Explanation: We can achieve a maximum frequency of two by:
// Adding 0 to nums[1]. nums becomes [1, 4, 5].
// Adding -1 to nums[2]. nums becomes [1, 4, 4].

import java.util.Arrays;

public class Oct21__MaximumFrequencyOfAnElementAfterPerformingOperationsI {
    public static int maxFrequency(int[] nums, int k, int ops) {
        int mx = Arrays.stream(nums).max().getAsInt();
        int n = mx + k + 1;
        int[] f = new int[n];
        for (int x : nums)
            f[x]++;
        int[] pre = new int[n];
        pre[0] = f[0];
        for (int i = 1; i < n; i++)
            pre[i] = pre[i - 1] + f[i];
        int ans = 0;
        for (int t = 0; t < n; t++) {
            if (f[t] == 0 && ops == 0)
                continue;
            int l = Math.max(0, t - k), r = Math.min(n - 1, t + k);
            int tot = pre[r] - (l > 0 ? pre[l - 1] : 0);
            int adj = tot - f[t];
            int val = f[t] + Math.min(ops, adj);
            ans = Math.max(ans, val);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 4, 5 };
        int k = 1;
        int ops = 2;
        System.out.println(maxFrequency(nums, k, ops));
        // 2
    }
}
