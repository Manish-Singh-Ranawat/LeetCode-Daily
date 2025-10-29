// Smallest Number With All Set Bits - https://leetcode.com/problems/smallest-number-with-all-set-bits/description/?envType=daily-question&envId=2025-10-29

// You are given a positive number n.

// Return the smallest number x greater than or equal to n, such that the binary representation of x contains only set bits

// Input: n = 5
// Output: 7
// Explanation: The binary representation of 7 is "111".

public class Oct29__SmallestNumberWithAllSetBits {
    public static int smallestNumber(int n) {
        int ans = 1;
        while (ans <= n)
            ans = ans << 1;
        return ans - 1;
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(smallestNumber(n));
        // 7
    }
}
