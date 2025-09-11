// Sort Vowels in a String - https://leetcode.com/problems/sort-vowels-in-a-string/description/?envType=daily-question&envId=2025-09-11

// Given a 0-indexed string s, permute s to get a new string t such that:
// - All consonants remain in their original places. More formally, if there is an index i with 0 <= i < s.length such that s[i] is a consonant, then t[i] = s[i].
// - The vowels must be sorted in the nondecreasing order of their ASCII values. More formally, for pairs of indices i, j with 0 <= i < j < s.length such that s[i] and s[j] are vowels, then t[i] must not have a higher ASCII value than t[j].

// Return the resulting string.

// The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in lowercase or uppercase. Consonants comprise all letters that are not vowels.

// Input: s = "lEetcOde"
// Output: "lEOtcede"
// Explanation: 'E', 'O', and 'e' are the vowels in s; 'l', 't', 'c', and 'd' are all consonants. The vowels are sorted according to their ASCII values, and the consonants remain in the same places.

public class Sept11__SortVowelsInString {
    public static String sortVowels(String s) {
        int[] count = new int[1000];
        int n = s.length();
        char[] ans = new char[n];
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (isVowel(ch))
                count[ch]++;
        }
        int idx = 0;
        String sortedVowels = "AEIOUaeiou";
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (!isVowel(ch)) {
                ans[i] = ch;
            } else {
                while (count[sortedVowels.charAt(idx)] == 0) {
                    idx++;
                }
                ans[i] = sortedVowels.charAt(idx);
                count[sortedVowels.charAt(idx)]--;
            }
        }
        return new String(ans);
    }

    private static boolean isVowel(char ch) {
        ch = Character.toLowerCase(ch);
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

    public static void main(String[] args) {
        String s = "lEetcOde";
        System.out.println(sortVowels(s));
        // lEOtcede
    }
}
