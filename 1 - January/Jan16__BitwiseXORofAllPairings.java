// Bitwise XOR of All Pairings - https://leetcode.com/problems/bitwise-xor-of-all-pairings/description/?envType=daily-question&envId=2025-01-16

// You are given two 0-indexed arrays, nums1 and nums2, consisting of non-negative integers. There exists another array, nums3, which contains the bitwise XOR of all pairings of integers between nums1 and nums2 (every integer in nums1 is paired with every integer in nums2 exactly once).

// Return the bitwise XOR of all integers in nums3.

// Input: nums1 = [2,1,3], nums2 = [10,2,5,0]
// Output: 13
// Explanation: A possible nums3 array is [8,0,7,2,11,3,4,1,9,1,6,3].
// The bitwise XOR of all these numbers is 13, so we return 13.

public class Jan16__BitwiseXORofAllPairings {
    public static int xorAllNums(int[] nums1, int[] nums2) {
        int ans = 0;
        int n1 = nums1.length;
        int n2 = nums2.length;
        if (n2 % 2 == 1) {
            for (int i = 0; i < n1; i++) {
                ans ^= nums1[i];
            }
        }
        if (n1 % 2 == 1) {
            for (int i = 0; i < n2; i++) {
                ans ^= nums2[i];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums1 = { 2, 1, 3 };
        int[] nums2 = { 10, 2, 5, 0 };
        System.out.println(xorAllNums(nums1, nums2));
        // 13
    }
}
