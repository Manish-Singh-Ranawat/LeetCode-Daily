// Maximum Difference Between Even and Odd Frequency I - https://leetcode.com/problems/maximum-difference-between-even-and-odd-frequency-i/?envType=daily-question&envId=2025-06-10

// You are given a string s consisting of lowercase English letters.

// Your task is to find the maximum difference diff = a1 - a2 between the frequency of characters a1 and a2 in the string such that:
// - a1 has an odd frequency in the string.
// - a2 has an even frequency in the string.

// Return this maximum difference.

// Input: s = "aaaaabbc"
// Output: 3
// Explanation: The character 'a' has an odd frequency of 5, and 'b' has an even frequency of 2. The maximum difference is 5 - 2 = 3.

public class June10__MaximumDifferenceBetweenEvenAndOddFrequencyI {
    public static int maxDifference(String s) {
        int[] freq = new int[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }
        int odd = 0;
        int even = s.length();
        for (int i = 0; i < 26; i++) {
            if (freq[i] == 0)
                continue;
            if (freq[i] % 2 == 0)
                even = Math.min(even, freq[i]);
            else
                odd = Math.max(odd, freq[i]);
        }
        return odd - even;
    }

    public static void main(String[] args) {
        String s = "aaaaabbc";
        System.out.println(maxDifference(s));
        // 3
    }
}
