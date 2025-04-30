// Find Numbers with Even Number of Digits - https://leetcode.com/problems/find-numbers-with-even-number-of-digits/description/?envType=daily-question&envId=2025-04-30

// Given an array nums of integers, return how many of them contain an even number of digits.

// Input: nums = [12,345,2,6,7896]
// Output: 2
// Explanation: 
// 12 contains 2 digits (even number of digits). 
// 345 contains 3 digits (odd number of digits). 
// 2 contains 1 digit (odd number of digits). 
// 6 contains 1 digit (odd number of digits). 
// 7896 contains 4 digits (even number of digits). 
// Therefore only 12 and 7896 contain an even number of digits.

public class April30__FindNumbersWithEvenNumberOfDigits {
    public static int findNumbers(int[] nums) {
        int count = 0;
        for (int num : nums) {
            int digits = (int) Math.floor(Math.log10(num)) + 1;
            if (digits % 2 == 0)
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = { 12, 345, 2, 6, 7896 };
        System.out.println(findNumbers(nums));
        // 2
    }
}
