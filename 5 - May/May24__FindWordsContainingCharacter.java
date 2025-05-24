// Find Words Containing Character - https://leetcode.com/problems/find-words-containing-character/description/?envType=daily-question&envId=2025-05-24

// You are given a 0-indexed array of strings words and a character x.

// Return an array of indices representing the words that contain the character x.

// Note that the returned array may be in any order.

// Input: words = ["leet","code"], x = "e"
// Output: [0,1]
// Explanation: "e" occurs in both words: "leet", and "code". Hence, we return indices 0 and 1.

import java.util.ArrayList;
import java.util.List;

public class May24__FindWordsContainingCharacter {
    public static List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> res = new ArrayList<>();
        int n = words.length;
        for (int i = 0; i < n; i++) {
            if (words[i].indexOf(x) != -1)
                res.add(i);
        }
        return res;
    }

    public static void main(String[] args) {
        String[] words = { "leet", "code" };
        char x = 'e';
        System.out.println(findWordsContaining(words, x));
        // [0,1]
    }
}
