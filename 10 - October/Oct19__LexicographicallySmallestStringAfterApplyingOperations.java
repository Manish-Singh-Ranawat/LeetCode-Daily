// Lexicographically Smallest String After Applying Operations - https://leetcode.com/problems/lexicographically-smallest-string-after-applying-operations/description/?envType=daily-question&envId=2025-10-19

// You are given a string s of even length consisting of digits from 0 to 9, and two integers a and b.

// You can apply either of the following two operations any number of times and in any order on s:
// - Add a to all odd indices of s (0-indexed). Digits post 9 are cycled back to 0. For example, if s = "3456" and a = 5, s becomes "3951".
// - Rotate s to the right by b positions. For example, if s = "3456" and b = 1, s becomes "6345".

// Return the lexicographically smallest string you can obtain by applying the above operations any number of times on s.

// A string a is lexicographically smaller than a string b (of the same length) if in the first position where a and b differ, string a has a letter that appears earlier in the alphabet than the corresponding letter in b. For example, "0158" is lexicographically smaller than "0190" because the first position they differ is at the third letter, and '5' comes before '9'.

// Input: s = "5525", a = 9, b = 2
// Output: "2050"
// Explanation: We can apply the following operations:
// Start:  "5525"
// Rotate: "2555"
// Add:    "2454"
// Add:    "2353"
// Rotate: "5323"
// Add:    "5222"
// Add:    "5121"
// Rotate: "2151"
// Add:    "2050"​​​​​
// There is no way to obtain a string that is lexicographically smaller than "2050".

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class Oct19__LexicographicallySmallestStringAfterApplyingOperations {
    public static String findLexSmallestString(String s, int a, int b) {
        Set<String> vis = new HashSet<>();
        String smallest = s;
        Deque<String> q = new ArrayDeque<>();
        q.offer(s);
        vis.add(s);
        while (!q.isEmpty()) {
            String cur = q.poll();
            if (cur.compareTo(smallest) < 0)
                smallest = cur;
            StringBuilder sb = new StringBuilder(cur);
            for (int i = 1; i < sb.length(); i += 2)
                sb.setCharAt(i, (char) ((sb.charAt(i) - '0' + a) % 10 + '0'));
            String added = sb.toString();
            if (vis.add(added))
                q.offer(added);
            String rotated = cur.substring(cur.length() - b) + cur.substring(0, cur.length() - b);
            if (vis.add(rotated))
                q.offer(rotated);
        }
        return smallest;
    }

    public static void main(String[] args) {
        String s = "5525";
        int a = 9;
        int b = 2;
        System.out.println(findLexSmallestString(s, a, b));
        // "2050"
    }
}
