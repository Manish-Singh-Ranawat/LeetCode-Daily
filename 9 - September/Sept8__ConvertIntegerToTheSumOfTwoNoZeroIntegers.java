// Convert Integer to the Sum of Two No-Zero Integers - https://leetcode.com/problems/convert-integer-to-the-sum-of-two-no-zero-integers/description/?envType=daily-question&envId=2025-09-08

// No-Zero integer is a positive integer that does not contain any 0 in its decimal representation.

// Given an integer n, return a list of two integers [a, b] where:
// - a and b are No-Zero integers.
// - a + b = n

// The test cases are generated so that there is at least one valid solution. If there are many valid solutions, you can return any of them.

// Input: n = 2
// Output: [1,1]
// Explanation: Let a = 1 and b = 1.
// Both a and b are no-zero integers, and a + b = 2 = n.

import java.util.Arrays;

public class Sept8__ConvertIntegerToTheSumOfTwoNoZeroIntegers {
    public static int[] getNoZeroIntegers(int n) {
        int i = 1;
        int a = n;
        int b = 0;
        while (n > 1) {
            int remove = n % 10 == 1 ? 2 : 1;
            a = a - remove * i;
            b = b + remove * i;
            n = (n - remove) / 10;
            i *= 10;
        }
        return new int[] { a, b };
    }

    public static void main(String[] args) {
        int n = 2;
        System.out.println(Arrays.toString(getNoZeroIntegers(n)));
        // [1, 1]
    }
}
