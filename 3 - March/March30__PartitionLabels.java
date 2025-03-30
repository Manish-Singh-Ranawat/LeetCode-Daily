// Partition Labels - https://leetcode.com/problems/partition-labels/description/?envType=daily-question&envId=2025-03-30

// You are given a string s. We want to partition the string into as many parts as possible so that each letter appears in at most one part. For example, the string "ababcc" can be partitioned into ["abab", "cc"], but partitions such as ["aba", "bcc"] or ["ab", "ab", "cc"] are invalid.

// Note that the partition is done so that after concatenating all the parts in order, the resultant string should be s.

// Return a list of integers representing the size of these parts.

// Input: s = "ababcbacadefegdehijhklij"
// Output: [9,7,8]
// Explanation:
// The partition is "ababcbaca", "defegde", "hijhklij".
// This is a partition so that each letter appears in at most one part.
// A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits s into less parts.


import java.util.ArrayList;
import java.util.List;

public class March30__PartitionLabels {
    public static List<Integer> partitionLabels(String s) {
        int[] last = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            last[s.charAt(i) - 'a'] = i;
        }
        int start = 0;
        int end = 0;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < s.length(); ++i) {
            end = Math.max(
                    end,
                    last[s.charAt(i) - 'a']);
            if (i == end) {
                ans.add(i - start + 1);
                start = i + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        System.out.println(partitionLabels(s));
        // [9,7,8]
    }
}
