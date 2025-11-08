// Minimum One Bit Operations to Make Integers Zero - https://leetcode.com/problems/minimum-one-bit-operations-to-make-integers-zero/description/?envType=daily-question&envId=2025-11-08

// Given an integer n, you must transform it into 0 using the following operations any number of times:
// - Change the rightmost (0th) bit in the binary representation of n.
// - Change the ith bit in the binary representation of n if the (i-1)th bit is set to 1 and the (i-2)th through 0th bits are set to 0.

// Return the minimum number of operations to transform n into 0.

// Input: n = 6
// Output: 4
// Explanation: The binary representation of 6 is "110".
// "110" -> "010" with the 2nd operation since the 1st bit is 1 and 0th through 0th bits are 0.
// "010" -> "011" with the 1st operation.
// "011" -> "001" with the 2nd operation since the 0th bit is 1.
// "001" -> "000" with the 1st operation.

public class Nov8__MinimumOneBitOperationsToMakeIntegersZero {
    public static int minimumOneBitOperations(int n) {
        int ans = 0;
        int k = 0;
        int mask = 1;
        while (mask <= n) {
            if ((n & mask) != 0) {
                ans = (1 << (k + 1)) - 1 - ans;
            }
            
            mask <<= 1;
            k++;
        }
        return ans;
    }

    // public static int minimumOneBitOperations(int n) {
    //     if (n == 0) 
    //         return 0;
    //     int k = 0;
    //     int curr = 1;
    //     while (curr * 2 <= n) {
    //         curr *= 2;
    //         k++;
    //     }  
    //     return (1 << (k + 1)) - 1 - minimumOneBitOperations(n ^ curr);
    // }

    public static void main(String[] args) {
        int n = 6;
        System.out.println(minimumOneBitOperations(n));
        // 4
    }
}
