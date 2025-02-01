// Special Array I - https://leetcode.com/problems/special-array-i/description/?envType=daily-question&envId=2025-02-01

// An array is considered special if every pair of its adjacent elements contains two numbers with different parity.

// You are given an array of integers nums. Return true if nums is a special array, otherwise, return false.

// Input: nums = [2,1,4]
// Output: true
// Explanation: There is only two pairs: (2,1) and (1,4), and both of them contain numbers with different parity. So the answer is true.

public class Feb1__SpecialArrayI {
    public static boolean isArraySpecial(int[] nums) {
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            int prev = nums[i - 1] % 2;
            int cur = nums[i] % 2;
            if (prev == cur)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 1, 4 };
        System.out.println(isArraySpecial(nums));
        // true
    }
}