// Count Odd Numbers in an Interval Range - https://leetcode.com/problems/count-odd-numbers-in-an-interval-range/description/?envType=daily-question&envId=2025-12-07

// Given two non-negative integers low and high. Return the count of odd numbers between low and high (inclusive).

// Input: low = 3, high = 7
// Output: 3
// Explanation: The odd numbers between 3 and 7 are [3,5,7].

public class Dec7__CountOddNumbersInAnIntervalRange {
    public static int countOdds(int low, int high) {
        return (high + 1) / 2 - (low / 2);
    }

    public static void main(String[] args) {
        int low = 3;
        int high = 7;
        System.out.println(countOdds(low, high));
        // 3   
    }
}
