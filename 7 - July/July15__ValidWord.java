// Valid Word - https://leetcode.com/problems/valid-word/description/?envType=daily-question&envId=2025-07-15

// A word is considered valid if:
// - It contains a minimum of 3 characters.
// - It contains only digits (0-9), and English letters (uppercase and lowercase).
// - It includes at least one vowel.
// - It includes at least one consonant.

// You are given a string word.

// Return true if word is valid, otherwise, return false.

// Notes: 'a', 'e', 'i', 'o', 'u', and their uppercases are vowels.
// A consonant is an English letter that is not a vowel.

// Input: word = "234Adas"
// Output: true
// Explanation: This word satisfies the conditions.

public class July15__ValidWord {
    public static boolean isValid(String word) {
        if (word.length() < 3)
            return false;
        boolean vowel = false;
        boolean consonant = false;
        for (char ch : word.toCharArray()) {
            if (!Character.isLetterOrDigit(ch))
                return false;
            if (Character.isLetter(ch)) {
                ch = Character.toLowerCase(ch);
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
                    vowel = true;
                else
                    consonant = true;
            }
        }
        return vowel && consonant;
    }

    public static void main(String[] args) {
        String word = "234Adas";
        System.out.println(isValid(word));
        // true
    }
}
