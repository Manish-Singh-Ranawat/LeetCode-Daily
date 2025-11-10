// Minimum Operations to Convert All Elements to Zero - https://leetcode.com/problems/minimum-operations-to-convert-all-elements-to-zero/description/?envType=daily-question&envId=2025-11-10

// You are given an array nums of size n, consisting of non-negative integers. Your task is to apply some (possibly zero) operations on the array so that all elements become 0.

// In one operation, you can select a subarray [i, j] (where 0 <= i <= j < n) and set all occurrences of the minimum non-negative integer in that subarray to 0.

// Return the minimum number of operations required to make all elements in the array 0.

// Input: nums = [3,1,2,1]
// Output: 3
// Explanation:
// Select subarray [1,3] (which is [1,2,1]), where the minimum non-negative integer is 1. Setting all occurrences of 1 to 0 results in [3,0,2,0].
// Select subarray [2,2] (which is [2]), where the minimum non-negative integer is 2. Setting all occurrences of 2 to 0 results in [3,0,0,0].
// Select subarray [0,0] (which is [3]), where the minimum non-negative integer is 3. Setting all occurrences of 3 to 0 results in [0,0,0,0].
// Thus, the minimum number of operations required is 3.

import java.util.Stack;

public class Nov10__MinimumOperationsToConvertAllElementsToZero {
    public static int minOperations(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int res = 0;
        for (int a : nums) {
            while (!st.isEmpty() && st.peek() > a)
                st.pop();
            if (a == 0)
                continue;
            if (st.isEmpty() || st.peek() < a) {
                res++;
                st.push(a);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = { 3, 1, 2, 1 };
        System.out.println(minOperations(nums));
        // 3
    }
}
