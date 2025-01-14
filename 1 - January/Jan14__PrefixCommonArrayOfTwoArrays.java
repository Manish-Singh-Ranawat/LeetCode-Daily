// Find the Prefix Common Array of Two Arrays - https://leetcode.com/problems/find-the-prefix-common-array-of-two-arrays/?envType=daily-question&envId=2025-01-14

// You are given two 0-indexed integer permutations A and B of length n.

// A prefix common array of A and B is an array C such that C[i] is equal to the count of numbers that are present at or before the index i in both A and B.

// Return the prefix common array of A and B.

// A sequence of n integers is called a permutation if it contains all integers from 1 to n exactly once.

// Input: A = [1,3,2,4], B = [3,1,2,4]
// Output: [0,2,3,4]
// Explanation: At i = 0: no number is common, so C[0] = 0.
// At i = 1: 1 and 3 are common in A and B, so C[1] = 2.
// At i = 2: 1, 2, and 3 are common in A and B, so C[2] = 3.
// At i = 3: 1, 2, 3, and 4 are common in A and B, so C[3] = 4.

public class Jan14__PrefixCommonArrayOfTwoArrays {
    public static int[] findThePrefixCommonArray(int[] A, int[] B) {
        long maskA = 0L;
        long maskB = 0L;
        int n = A.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            maskA = maskA | (1L << (A[i] - 1));
            maskB = maskB | (1L << (B[i] - 1));
            long commonMask = maskA & maskB;
            ans[i] = Long.bitCount(commonMask);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] A = { 1, 3, 2, 4 };
        int[] B = { 3, 1, 2, 4 };
        int[] res = findThePrefixCommonArray(A, B);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
        // 0 2 3 4
    }
}
