// Find Lucky Integer in an Array - https://leetcode.com/problems/find-lucky-integer-in-an-array/description/?envType=daily-question&envId=2025-07-05

// Given an array of integers arr, a lucky integer is an integer that has a frequency in the array equal to its value.

// Return the largest lucky integer in the array. If there is no lucky integer return -1.

// Input: arr = [2,2,3,4]
// Output: 2
// Explanation: The only lucky number in the array is 2 because frequency[2] == 2.

import java.util.HashMap;
import java.util.Map;

public class July5__FindLuckyIntegerInArray {
    public static int findLucky(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr)
            map.put(num, map.getOrDefault(num, 0) + 1);
        int ans = -1;
        for (Map.Entry<Integer, Integer> it : map.entrySet()) {
            if (it.getKey() == it.getValue())
                ans = Math.max(it.getKey(), ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 2, 3, 4 };
        System.out.println(findLucky(arr));
        // 2
    }
}
