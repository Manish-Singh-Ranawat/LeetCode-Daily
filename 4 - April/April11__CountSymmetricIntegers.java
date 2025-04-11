// Count Symmetric Integers - https://leetcode.com/problems/count-symmetric-integers/description/?envType=daily-question&envId=2025-04-11

// You are given two positive integers low and high.

// An integer x consisting of 2 * n digits is symmetric if the sum of the first n digits of x is equal to the sum of the last n digits of x. Numbers with an odd number of digits are never symmetric.

// Return the number of symmetric integers in the range [low, high].

// Input: low = 1, high = 100
// Output: 9
// Explanation: There are 9 symmetric integers between 1 and 100: 11, 22, 33, 44, 55, 66, 77, 88, and 99.

public class April11__CountSymmetricIntegers {
    public static int countSymmetricIntegers(int low, int high) {
        int ans = 0;
        for (int i = low; i <= high; i++) {
            if (symmetric(i))
                ans++;
        }
        return ans;
    }

    private static boolean symmetric(int num) {
        String s = Integer.toString(num);
        if (s.length() % 2 == 1)
            return false;
        int n = s.length() / 2;
        int front = 0;
        int back = 0;
        for (int i = 0; i < n; i++) {
            back += Character.getNumericValue(s.charAt(i));
            front += Character.getNumericValue(s.charAt(i + n));
        }
        return front == back;
    }

    public static void main(String[] args) {
        int low = 1;
        int high = 100;
        System.out.println(countSymmetricIntegers(low, high));
        // 9
    }
}
