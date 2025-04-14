// Count Good Triplets - https://leetcode.com/problems/count-good-triplets/description/?envType=daily-question&envId=2025-04-14

// Given an array of integers arr, and three integers a, b and c. You need to find the number of good triplets.

// A triplet (arr[i], arr[j], arr[k]) is good if the following conditions are true:
// -  0 <= i < j < k < arr.length
// - |arr[i] - arr[j]| <= a
// - |arr[j] - arr[k]| <= b
// - |arr[i] - arr[k]| <= c

// Where |x| denotes the absolute value of x.

// Return the number of good triplets.

// Input: arr = [3,0,1,1,9,7], a = 7, b = 2, c = 3
// Output: 4
// Explanation: There are 4 good triplets: [(3,0,1), (3,0,1), (3,1,1), (0,1,1)].

public class April14__CountGoodTriplets {
    public static int countGoodTriplets(int[] arr, int a, int b, int c) {
        int n = arr.length;
        int ans = 0;
        int[] prefixCnt = new int[1001];
        for (int j = 0; j < n; ++j) {
            for (int k = j + 1; k < n; ++k) {
                if (Math.abs(arr[j] - arr[k]) <= b) {
                    int l = Math.max(0, Math.max(arr[j] - a, arr[k] - c));
                    int r = Math.min(1000, Math.min(arr[j] + a, arr[k] + c));
                    if (l <= r) {
                        ans += (l == 0 ? prefixCnt[r] : prefixCnt[r] - prefixCnt[l - 1]);
                    }
                }
            }
            for (int idx = arr[j]; idx <= 1000; idx++) {
                prefixCnt[idx]++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 0, 1, 1, 9, 7 };
        int a = 7, b = 2, c = 3;
        System.out.println(countGoodTriplets(arr, a, b, c));
        // 4
    }
}
