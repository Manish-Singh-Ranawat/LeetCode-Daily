// Find N Unique Integers Sum up to Zero - https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero/?envType=daily-question&envId=2025-09-07

// Given an integer n, return any array containing n unique integers such that they add up to 0.

// Input: n = 5
// Output: [-7,-1,1,3,4]
// Explanation: These arrays also are accepted [1, 2, 0, -2, -1], [-5,-1,1,2,3] , [-3,-1,2,-2,4].

import java.util.Arrays;

public class Sept7__FindNUniqueIntegersSumUpToZero {
    public static int[] sumZero(int n) {
        int[] ans = new int[n];
        for (int i = 0; i < n / 2; i++) {
            ans[i] = i + 1;
            ans[n - i - 1] = -(i + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(Arrays.toString(sumZero(n)));
        // [1, 2, 0, -2, -1]
    }
}
