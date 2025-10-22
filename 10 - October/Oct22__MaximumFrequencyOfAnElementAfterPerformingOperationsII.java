// Maximum Frequency of an Element After Performing Operations II - https://leetcode.com/problems/maximum-frequency-of-an-element-after-performing-operations-ii/description/?envType=daily-question&envId=2025-10-22

// You are given an integer array nums and two integers k and numOperations.

// You must perform an operation numOperations times on nums, where in each operation you:
// - Select an index i that was not selected in any previous operations.
// - Add an integer in the range [-k, k] to nums[i].

// Return the maximum possible frequency of any element in nums after performing the operations.

// Input: nums = [1,4,5], k = 1, numOperations = 2
// Output: 2
// Explanation: We can achieve a maximum frequency of two by:
// Adding 0 to nums[1], after which nums becomes [1, 4, 5].
// Adding -1 to nums[2], after which nums becomes [1, 4, 4].

import java.util.Map;
import java.util.TreeMap;

public class Oct22__MaximumFrequencyOfAnElementAfterPerformingOperationsII {
    public static int maxFrequency(int[] nums, int k, int ops) {
        Map<Integer, Integer> freqMap = new TreeMap<>();
        Map<Integer, Integer> diffMap = new TreeMap<>();
        for (int x : nums) {
            freqMap.put(x, freqMap.getOrDefault(x, 0) + 1);
            int l = Math.max(0, x - k);
            int r = x + k;
            diffMap.put(l, diffMap.getOrDefault(l, 0) + 1);
            diffMap.put(r + 1, diffMap.getOrDefault(r + 1, 0) - 1);
            diffMap.put(x, diffMap.getOrDefault(x, 0));
        }
        int ans = 0;
        int sum = 0;
        for (Map.Entry<Integer, Integer> it : diffMap.entrySet()) {
            sum += it.getValue();
            int adj = sum - freqMap.getOrDefault(it.getKey(), 0);
            int val = freqMap.getOrDefault(it.getKey(), 0) + Math.min(ops, adj);
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
