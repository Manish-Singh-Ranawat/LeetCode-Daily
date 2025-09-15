// Maximum Number of Words You Can Type - https://leetcode.com/problems/maximum-number-of-words-you-can-type/?envType=daily-question&envId=2025-09-15

// There is a malfunctioning keyboard where some letter keys do not work. All other keys on the keyboard work properly.

// Given a string text of words separated by a single space (no leading or trailing spaces) and a string brokenLetters of all distinct letter keys that are broken, return the number of words in text you can fully type using this keyboard.

// Input: text = "hello world", brokenLetters = "ad"
// Output: 1
// Explanation: We cannot type "world" because the 'd' key is broken.

public class Sept15__MaximumNumberOfWordsYouCanType {
    public static int canBeTypedWords(String text, String brokenLetters) {
        boolean[] hash = new boolean[26];
        for (char ch : brokenLetters.toCharArray())
            hash[ch - 'a'] = true;
        int ans = 0;
        boolean canType = true;
        for (char ch : text.toCharArray()) {
            if (ch == ' ') {
                if (canType)
                    ans++;
                canType = true;
            } else {
                if (hash[ch - 'a'])
                    canType = false;
            }
        }
        if (canType)
            ans++;
        return ans;
    }

    public static void main(String[] args) {
        String text = "hello world";
        String brokenLetters = "ad";
        System.out.println(canBeTypedWords(text, brokenLetters));
        // 1
    }
}
