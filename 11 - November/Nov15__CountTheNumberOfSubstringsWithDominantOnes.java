// Count the Number of Substrings With Dominant Ones - https://leetcode.com/problems/count-the-number-of-substrings-with-dominant-ones/description/?envType=daily-question&envId=2025-11-15

// You are given a binary string s.

// Return the number of substrings with dominant ones.

// A string has dominant ones if the number of ones in the string is greater than or equal to the square of the number of zeros in the string.

// Input: s = "00011"
// Output: 5
// Explanation: The substrings with dominant ones are shown in the table below.
// i	j	s[i..j]	Number of Zeros	Number of Ones
// 3	3	  1	           0	      1
// 4	4	  1	           0	      1
// 2	3	  01	       1	      1
// 3	4	  11	       0	      2
// 2	4	  011	       1	      2

public class Nov15__CountTheNumberOfSubstringsWithDominantOnes {
    public static int numberOfSubstrings(String s) {
        int n = s.length();
        int[] pre = new int[n + 1];
        pre[0] = -1;
        for (int i = 0; i < n; i++) {
            if (i == 0 || (i > 0 && s.charAt(i - 1) == '0')) {
                pre[i + 1] = i;
            } else {
                pre[i + 1] = pre[i];
            }
        }
        int res = 0;
        for (int i = 1; i <= n; i++) {
            int cnt0 = s.charAt(i - 1) == '0' ? 1 : 0;
            int j = i;
            while (j > 0 && cnt0 * cnt0 <= n) {
                int cnt1 = (i - pre[j]) - cnt0;
                if (cnt0 * cnt0 <= cnt1) {
                    res += Math.min(j - pre[j], cnt1 - cnt0 * cnt0 + 1);
                }
                j = pre[j];
                cnt0++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "00011";
        System.out.println(numberOfSubstrings(s));
        // 5
    }
}
