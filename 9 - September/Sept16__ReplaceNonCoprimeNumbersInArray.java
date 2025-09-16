// Replace Non-Coprime Numbers in Array - https://leetcode.com/problems/replace-non-coprime-numbers-in-array/description/?envType=daily-question&envId=2025-09-16

// You are given an array of integers nums. Perform the following steps:
// 1 - Find any two adjacent numbers in nums that are non-coprime.
// 2 - If no such numbers are found, stop the process.
// 3 - Otherwise, delete the two numbers and replace them with their LCM (Least Common Multiple).
// 4 - Repeat this process as long as you keep finding two adjacent non-coprime numbers.

// Return the final modified array. It can be shown that replacing adjacent non-coprime numbers in any arbitrary order will lead to the same result.

// The test cases are generated such that the values in the final array are less than or equal to 108.

// Two values x and y are non-coprime if GCD(x, y) > 1 where GCD(x, y) is the Greatest Common Divisor of x and y.

// Input: nums = [6,4,3,2,7,6,2]
// Output: [12,7,6]
// Explanation: 
// - (6, 4) are non-coprime with LCM(6, 4) = 12. Now, nums = [12,3,2,7,6,2].
// - (12, 3) are non-coprime with LCM(12, 3) = 12. Now, nums = [12,2,7,6,2].
// - (12, 2) are non-coprime with LCM(12, 2) = 12. Now, nums = [12,7,6,2].
// - (6, 2) are non-coprime with LCM(6, 2) = 6. Now, nums = [12,7,6].
// There are no more adjacent non-coprime numbers in nums.
// Thus, the final modified array is [12,7,6].
// Note that there are other ways to obtain the same resultant array.

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Sept16__ReplaceNonCoprimeNumbersInArray {
    public static List<Integer> replaceNonCoprimes(int[] nums) {
        Stack<Integer> st = new Stack<>();
        for (int num : nums) {
            st.push(num);
            while (st.size() >= 2) {
                int top1 = st.pop();
                int top2 = st.pop();
                int g = hcf(top1, top2);
                if (g > 1) {
                    long lcm = 1L * top1 * top2 / g;
                    st.push((int) lcm);
                } else {
                    st.push(top2);
                    st.push(top1);
                    break;
                }
            }
        }
        return new ArrayList<>(st);
    }

    private static int hcf(int x, int y) {
        while (y != 0) {
            int temp = y;
            y = x % y;
            x = temp;
        }
        return x;
    }

    public static void main(String[] args) {
        int[] nums = { 6, 4, 3, 2, 7, 6, 2 };
        System.out.println(replaceNonCoprimes(nums));
        // [12,7,6]
    }
}
