// Check If All 1's Are at Least Length K Places Away - https://leetcode.com/problems/check-if-all-1s-are-at-least-length-k-places-away/description/?envType=daily-question&envId=2025-11-17

// Given an binary array nums and an integer k, return true if all 1's are at least k places away from each other, otherwise return false.

// Input: nums = [1,0,0,0,1,0,0,1], k = 2
// Output: true
// Explanation: Each of the 1s are at least 2 places away from each other.

public class Nov17__CheckIfAllOnesAreAtLeastLengthKPlacesAway {
    public static boolean kLengthApart(int[] nums, int k) {
        int prev = -1;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                if (prev != -1 && i - prev - 1 < k)
                    return false;
                prev = i;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int k = 2;
        int[] nums = { 1, 0, 0, 0, 1, 0, 0, 1 };
        System.out.println(kLengthApart(nums, k));
        // true
    }
}
