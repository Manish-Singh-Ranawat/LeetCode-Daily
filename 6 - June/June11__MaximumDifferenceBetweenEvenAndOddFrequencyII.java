// Maximum Difference Between Even and Odd Frequency II - https://leetcode.com/problems/maximum-difference-between-even-and-odd-frequency-ii/description/?envType=daily-question&envId=2025-06-11

// You are given a string s and an integer k. Your task is to find the maximum difference between the frequency of two characters, freq[a] - freq[b], in a substring subs of s, such that:
// - subs has a size of at least k.
// - Character a has an odd frequency in subs.
// - Character b has an even frequency in subs.

// Return the maximum difference.

// Note that subs can contain more than 2 distinct characters.

// Input: s = "12233", k = 4
// Output: -1
// Explanation: For the substring "12233", the frequency of '1' is 1 and the frequency of '3' is 2. The difference is 1 - 2 = -1.

import java.util.Arrays;

public class June11__MaximumDifferenceBetweenEvenAndOddFrequencyII {
    public static int maxDifference(String s, int k) {
        int n = s.length();
        int ans = Integer.MIN_VALUE;
        for (char a = '0'; a <= '4'; ++a) {
            for (char b = '0'; b <= '4'; ++b) {
                if (a == b) {
                    continue;
                }
                int[] best = new int[4];
                Arrays.fill(best, Integer.MAX_VALUE);
                int cnt_a = 0, cnt_b = 0;
                int prev_a = 0, prev_b = 0;
                int left = -1;
                for (int right = 0; right < n; ++right) {
                    cnt_a += (s.charAt(right) == a) ? 1 : 0;
                    cnt_b += (s.charAt(right) == b) ? 1 : 0;
                    while (right - left >= k && cnt_b - prev_b >= 2) {
                        int left_status = getStatus(prev_a, prev_b);
                        best[left_status] = Math.min(
                                best[left_status],
                                prev_a - prev_b);
                        ++left;
                        prev_a += (s.charAt(left) == a) ? 1 : 0;
                        prev_b += (s.charAt(left) == b) ? 1 : 0;
                    }
                    int right_status = getStatus(cnt_a, cnt_b);
                    if (best[right_status ^ 0b10] != Integer.MAX_VALUE) {
                        ans = Math.max(
                                ans,
                                cnt_a - cnt_b - best[right_status ^ 0b10]);
                    }
                }
            }
        }
        return ans;
    }

    private static int getStatus(int cnt_a, int cnt_b) {
        return ((cnt_a & 1) << 1) | (cnt_b & 1);
    }

    public static void main(String[] args) {
        String s = "12233";
        int k = 4;
        System.out.println(maxDifference(s, k));
        // -1
    }
}
