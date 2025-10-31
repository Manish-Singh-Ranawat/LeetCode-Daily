// The Two Sneaky Numbers of Digitville - https://leetcode.com/problems/the-two-sneaky-numbers-of-digitville/description/?envType=daily-question&envId=2025-10-31

// In the town of Digitville, there was a list of numbers called nums containing integers from 0 to n - 1. Each number was supposed to appear exactly once in the list, however, two mischievous numbers sneaked in an additional time, making the list longer than usual.

// As the town detective, your task is to find these two sneaky numbers. Return an array of size two containing the two numbers (in any order), so peace can return to Digitville.

// Input: nums = [0,3,2,1,3,2]
// Output: [2,3]
// Explanation: The numbers 2 and 3 each appear twice in the array.

import java.util.Arrays;

public class Oct31__TheTwoSneakyNumbersOfDigitville {
    public static int[] getSneakyNumbers(int[] nums) {
        int n = nums.length - 2;
        int xor = 0;
        for (int num : nums)
            xor ^= num;
        for (int i = 0; i < n; i++)
            xor ^= i;
        int mask = 0;
        for (int i = 0; i < 32; i++) {
            if ((xor & (1 << i)) != 0) {
                mask = 1 << i;
                break;
            }
        }
        int x1 = 0;
        int x2 = 0;
        for (int num : nums) {
            if ((num & mask) == 0)
                x1 ^= num;
            else
                x2 ^= num;
        }
        for (int i = 0; i < n; i++) {
            if ((i & mask) == 0)
                x1 ^= i;
            else
                x2 ^= i;
        }
        return new int[] { x1, x2 };
    }

    public static void main(String[] args) {
        int[] nums = { 0, 3, 2, 1, 3, 2 };
        System.out.println(Arrays.toString(getSneakyNumbers(nums)));
        // [2, 3]
    }
}
