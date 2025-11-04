// Find X-Sum of All K-Long Subarrays I - https://leetcode.com/problems/find-x-sum-of-all-k-long-subarrays-i/description/?envType=daily-question&envId=2025-11-04

// You are given an array nums of n integers and two integers k and x.

// The x-sum of an array is calculated by the following procedure:
// - Count the occurrences of all elements in the array.
// - Keep only the occurrences of the top x most frequent elements. If two elements have the same number of occurrences, the element with the bigger value is considered more frequent.
// - Calculate the sum of the resulting array.

// Note that if an array has less than x distinct elements, its x-sum is the sum of the array.

// Return an integer array answer of length n - k + 1 where answer[i] is the x-sum of the subarray nums[i..i + k - 1].

// Input: nums = [1,1,2,2,3,4,2,3], k = 6, x = 2
// Output: [6,10,12]
// Explanation:
// For subarray [1, 1, 2, 2, 3, 4], only elements 1 and 2 will be kept in the resulting array. Hence, answer[0] = 1 + 1 + 2 + 2.
// For subarray [1, 2, 2, 3, 4, 2], only elements 2 and 4 will be kept in the resulting array. Hence, answer[1] = 2 + 2 + 2 + 4. Note that 4 is kept in the array since it is bigger than 3 and 1 which occur the same number of times.
// For subarray [2, 2, 3, 4, 2, 3], only elements 2 and 3 are kept in the resulting array. Hence, answer[2] = 2 + 2 + 2 + 3 + 3.

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Nov4__FindXSumOfAllKLongSubarraysI {
    public static int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] result = new int[n - k + 1];
        Map<Integer, Integer> map = new HashMap<>();
        int l = 0;
        int r = 0;
        while (r < n) {
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);
            if (r - l + 1 == k) {
                result[l] = calculateTopXSum(map, x);
                map.put(nums[l], map.get(nums[l]) - 1);
                if (map.get(nums[l]) == 0)
                    map.remove(nums[l]);
                l++;
            }
            r++;
        }
        return result;
    }

    private static int calculateTopXSum(Map<Integer, Integer> map, int x) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> (a[0] == b[0]) ? a[1] - b[1] : a[0] - b[0]);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int freq = entry.getValue();
            int val = entry.getKey();
            pq.offer(new int[] { freq, val });
            if (pq.size() > x) {
                pq.poll();
            }
        }
        int sum = 0;
        while (!pq.isEmpty()) {
            int[] pair = pq.poll();
            sum += pair[0] * pair[1];
        }
        return sum;
    }

    public static void main(String[] args) {
        int k = 6;
        int x = 2;
        int[] nums = { 1, 1, 2, 2, 3, 4, 2, 3 };
        System.out.println(Arrays.toString(findXSum(nums, k, x)));
        // [6, 10, 12]
    }
}
