// Bitwise ORs of Subarrays - https://leetcode.com/problems/bitwise-ors-of-subarrays/description/?envType=daily-question&envId=2025-07-31

// Given an integer array arr, return the number of distinct bitwise ORs of all the non-empty subarrays of arr.

// The bitwise OR of a subarray is the bitwise OR of each integer in the subarray. The bitwise OR of a subarray of one integer is that integer.

// A subarray is a contiguous non-empty sequence of elements within an array.

// Input: arr = [1,1,2]
// Output: 3
// Explanation: The possible subarrays are [1], [1], [2], [1, 1], [1, 2], [1, 1, 2].
// These yield the results 1, 1, 2, 1, 3, 3.
// There are 3 unique values, so the answer is 3.

import java.util.HashSet;

public class July31__BitwiseORsOfSubarrays {
    public static int subarrayBitwiseORs(int[] arr) {
        HashSet<Integer> ans = new HashSet<>();
        HashSet<Integer> prev = new HashSet<>();
        for (int a : arr) {
            HashSet<Integer> cur = new HashSet<>();
            for (int it : prev) {
                cur.add(it | a);
            }
            cur.add(a);
            ans.addAll(cur);
            prev = cur;
        }
        return ans.size();
    }

    public static void main(String[] args) {
        int[] arr = { 1, 1, 2 };
        System.out.println(subarrayBitwiseORs(arr));
        // 3
    }
}
