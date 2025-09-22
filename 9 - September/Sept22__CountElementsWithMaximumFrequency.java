// Count Elements With Maximum Frequency - https://leetcode.com/problems/count-elements-with-maximum-frequency/description/?envType=daily-question&envId=2025-09-22

// You are given an array nums consisting of positive integers.

// Return the total frequencies of elements in nums such that those elements all have the maximum frequency.

// The frequency of an element is the number of occurrences of that element in the array.

// Input: nums = [1,2,2,3,1,4]
// Output: 4
// Explanation: The elements 1 and 2 have a frequency of 2 which is the maximum frequency in the array.
// So the number of elements in the array with maximum frequency is 4.

import java.util.Map;
import java.util.HashMap;

public class Sept22__CountElementsWithMaximumFrequency {

    public static int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        int ans = 0;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            int freq = map.get(num);
            if (freq > max) {
                max = freq;
                ans = freq;
            } else if (freq == max) {
                ans += freq;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 2, 3, 1, 4 };
        System.out.println(maxFrequencyElements(nums));
        // 4
    }
}
