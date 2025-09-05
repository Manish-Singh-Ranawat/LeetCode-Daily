// Minimum Operations to Make the Integer Zero - https://leetcode.com/problems/minimum-operations-to-make-the-integer-zero/?envType=daily-question&envId=2025-09-05

// You are given two integers num1 and num2.

// In one operation, you can choose integer i in the range [0, 60] and subtract 2i + num2 from num1.

// Return the integer denoting the minimum number of operations needed to make num1 equal to 0.

// If it is impossible to make num1 equal to 0, return -1.

// Input: num1 = 3, num2 = -2
// Output: 3
// Explanation: We can make 3 equal to 0 with the following operations:
// - We choose i = 2 and subtract 22 + (-2) from 3, 3 - (4 + (-2)) = 1.
// - We choose i = 2 and subtract 22 + (-2) from 1, 1 - (4 + (-2)) = -1.
// - We choose i = 0 and subtract 20 + (-2) from -1, (-1) - (1 + (-2)) = 0.
// It can be proven, that 3 is the minimum number of operations that we need to perform.

public class Sept5__MinimumOperationsToMakeTheIntegerZero {
    public static int makeTheIntegerZero(int num1, int num2) {
        int k = 1;
        while (true) {
            long x = num1 - (long) num2 * k;
            if (x < k) {
                return -1;
            }
            if (k >= Long.bitCount(x)) {
                return k;
            }
            k++;
        }
    }

    public static void main(String[] args) {
        int num1 = 3;
        int num2 = -2;
        System.out.println(makeTheIntegerZero(num1, num2));
        // 3
    }
}
