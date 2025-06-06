// Using a Robot to Print the Lexicographically Smallest String - https://leetcode.com/problems/using-a-robot-to-print-the-lexicographically-smallest-string/description/?envType=daily-question&envId=2025-06-06

// You are given a string s and a robot that currently holds an empty string t. Apply one of the following operations until s and t are both empty:
// - Remove the first character of a string s and give it to the robot. The robot will append this character to the string t.
// - Remove the last character of a string t and give it to the robot. The robot will write this character on paper.

// Return the lexicographically smallest string that can be written on the paper.

// Input: s = "bac"
// Output: "abc"
// Explanation: Let p denote the written string.
// Perform first operation twice p="", s="c", t="ba". 
// Perform second operation twice p="ab", s="c", t="". 
// Perform first operation p="ab", s="", t="c". 
// Perform second operation p="abc", s="", t="".

import java.util.Stack;

public class June6__UsingRobotToPrintLexicographicallySmallestString {
    public static String robotWithString(String s) {
        int[] freq = new int[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }
        char min = 'a';
        Stack<Character> st = new Stack<>();
        StringBuilder ans = new StringBuilder();
        for (char ch : s.toCharArray()) {
            st.push(ch);
            freq[ch - 'a']--;
            while (min != 'z' && freq[min - 'a'] == 0)
                min++;
            while (!st.isEmpty() && st.peek() <= min) {
                ans.append(st.pop());
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        String s = "bac";
        System.out.println(robotWithString(s));
        // abc
    }
}
