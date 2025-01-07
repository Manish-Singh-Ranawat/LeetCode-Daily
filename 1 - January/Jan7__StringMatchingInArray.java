// String Matching in an Array - https://leetcode.com/problems/string-matching-in-an-array/?envType=daily-question&envId=2025-01-07

// Given an array of string words, return all strings in words that is a substring of another word. You can return the answer in any order.

// A substring is a contiguous sequence of characters within a string

// Input: words = ["mass","as","hero","superhero"]
// Output: ["as","hero"]
// Explanation: "as" is substring of "mass" and "hero" is substring of "superhero".
// ["hero","as"] is also a valid answer.

// Input: words = ["leetcode","et","code"]
// Output: ["et","code"]
// Explanation: "et", "code" are substring of "leetcode".

import java.util.ArrayList;
import java.util.List;

public class Jan7__StringMatchingInArray {
    public static List<String> stringMatching(String[] words) {
        int n = words.length;
        List<String> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j || words[i].length() > words[j].length()) {
                    continue;
                }
                if (words[j].contains(words[i]) && !res.contains(words[i])) {
                    res.add(words[i]);
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[] words = { "mass", "as", "hero", "superhero" };
        System.out.println(stringMatching(words));
        // [as, hero]
    }

}