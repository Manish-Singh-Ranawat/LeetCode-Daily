// Number of Substrings With Only 1s - https://leetcode.com/problems/number-of-substrings-with-only-1s/?envType=daily-question&envId=2025-11-16

// Given a binary string s, return the number of substrings with all characters 1's. Since the answer may be too large, return it modulo 109 + 7.

// Input: s = "0110111"
// Output: 9
// Explanation: There are 9 substring in total with only 1's characters.
// "1" -> 5 times.
// "11" -> 3 times.
// "111" -> 1 time.

public class Nov16__NumberOfSubstringsWithOnlyOnes {
    public static int numSub(String s) {
        int MOD = 1000000007;
        long ans = 0;
        long count = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '0') {
                ans += (count * (count + 1)) / 2;
                ans %= MOD;
                count = 0;
            } else
                count++;
        }
        ans += (count * (count + 1)) / 2;
        ans %= MOD;
        return (int) ans;
    }

    public static void main(String[] args) {
        String s = "0110111";
        System.out.println(numSub(s));
        // 9
    }
}
