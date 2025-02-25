// Number of Sub-arrays With Odd Sum - https://leetcode.com/problems/number-of-sub-arrays-with-odd-sum/description/?envType=daily-question&envId=2025-02-25

// Given an array of integers arr, return the number of subarrays with an odd sum.

// Since the answer can be very large, return it modulo 109 + 7.

// Input: arr = [1,3,5]
// Output: 4
// Explanation: All subarrays are [[1],[1,3],[1,3,5],[3],[3,5],[5]]
// All sub-arrays sum are [1,4,9,3,8,5].
// Odd sums are [1,9,3,5] so the answer is 4.

public class Feb25__NumberOfSubarraysWithOddSum {
    public static int numOfSubarrays(int[] arr) {
        int n = arr.length;
        int MOD = (int) 1e9 + 7;
        int prefixSum = 0;
        int evenCount = 0;
        int oddCount = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            prefixSum += arr[i];
            if (prefixSum % 2 == 1) {
                ans += evenCount + 1;
                oddCount++;
            } else {
                ans += oddCount;
                evenCount++;
            }
            ans %= MOD;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 3, 5 };
        System.out.println(numOfSubarrays(arr));
        // 4
    }
}
