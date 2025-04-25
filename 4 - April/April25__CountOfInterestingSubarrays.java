// Count of Interesting Subarrays - https://leetcode.com/problems/count-of-interesting-subarrays/description/?envType=daily-question&envId=2025-04-25

// You are given a 0-indexed integer array nums, an integer modulo, and an integer k.

// Your task is to find the count of subarrays that are interesting.

// A subarray nums[l..r] is interesting if the following condition holds:
// - Let cnt be the number of indices i in the range [l, r] such that nums[i] % modulo == k. Then, cnt % modulo == k.

// Return an integer denoting the count of interesting subarrays.

// Note: A subarray is a contiguous non-empty sequence of elements within an array.

// Input: nums = [3,2,4], modulo = 2, k = 1
// Output: 3
// Explanation: In this example the interesting subarrays are: 
// The subarray nums[0..0] which is [3]. 
// - There is only one index, i = 0, in the range [0, 0] that satisfies nums[i] % modulo == k. 
// - Hence, cnt = 1 and cnt % modulo == k.  
// The subarray nums[0..1] which is [3,2].
// - There is only one index, i = 0, in the range [0, 1] that satisfies nums[i] % modulo == k.  
// - Hence, cnt = 1 and cnt % modulo == k.
// The subarray nums[0..2] which is [3,2,4]. 
// - There is only one index, i = 0, in the range [0, 2] that satisfies nums[i] % modulo == k. 
// - Hence, cnt = 1 and cnt % modulo == k. 
// It can be shown that there are no other interesting subarrays. So, the answer is 3.

import java.util.HashMap;
import java.util.List;

public class April25__CountOfInterestingSubarrays {
    public static long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        int n = nums.size();
        HashMap<Integer, Integer> map = new HashMap<>();
        long res = 0;
        int prefix = 0;
        map.put(0, 1);
        for (int i = 0; i < n; i++) {
            prefix += nums.get(i) % modulo == k ? 1 : 0;
            res += map.getOrDefault((prefix - k + modulo) % modulo, 0);
            map.put(prefix % modulo, map.getOrDefault(prefix % modulo, 0) + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        List<Integer> nums = List.of(3, 2, 4);
        int modulo = 2;
        int k = 1;
        System.out.println(countInterestingSubarrays(nums, modulo, k));
        // 3
    }
}
