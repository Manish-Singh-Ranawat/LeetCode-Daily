// Lexicographically Minimum String After Removing Stars - https://leetcode.com/problems/lexicographically-minimum-string-after-removing-stars/description/?envType=daily-question&envId=2025-06-07

// You are given a string s. It may contain any number of '*' characters. Your task is to remove all '*' characters.

// While there is a '*', do the following operation:
// - Delete the leftmost '*' and the smallest non-'*' character to its left. If there are several smallest characters, you can delete any of them.

// Return the lexicographically smallest resulting string after removing all '*' characters.

// Input: s = "aaba*"
// Output: "aab"
// Explanation: We should delete one of the 'a' characters with '*'. If we choose s[3], s becomes the lexicographically smallest.

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class June7__LexicographicallyMinimumStringAfterRemovingStars {
    public static String clearStars(String s) {
        List<Stack<Integer>> stacks = new ArrayList<>();
        for (int i = 0; i < 26; i++)
            stacks.add(new Stack<Integer>());
        char[] arr = s.toCharArray();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (arr[i] == '*') {
                for (int j = 0; j < 26; j++) {
                    if (!stacks.get(j).isEmpty()) {
                        arr[stacks.get(j).pop()] = '*';
                        break;
                    }
                }
            } else {
                stacks.get(arr[i] - 'a').push(i);
            }
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (arr[i] != '*')
                ans.append(arr[i]);
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        String s = "aaba*";
        System.out.println(clearStars(s));
        // aab
    }
}
