// Vowel Spellchecker - https://leetcode.com/problems/vowel-spellchecker/description/?envType=daily-question&envId=2025-09-14

// Given a wordlist, we want to implement a spellchecker that converts a query word into a correct word.

// For a given query word, the spell checker handles two categories of spelling mistakes:

// -  Capitalization: If the query matches a word in the wordlist (case-insensitive), then the query word is returned with the same case as the case in the wordlist.
// Example: wordlist = ["yellow"], query = "YellOw": correct = "yellow"
// Example: wordlist = ["Yellow"], query = "yellow": correct = "Yellow"
// Example: wordlist = ["yellow"], query = "yellow": correct = "yellow"

// - Vowel Errors: If after replacing the vowels ('a', 'e', 'i', 'o', 'u') of the query word with any vowel individually, it matches a word in the wordlist (case-insensitive), then the query word is returned with the same case as the match in the wordlist.
// Example: wordlist = ["YellOw"], query = "yollow": correct = "YellOw"
// Example: wordlist = ["YellOw"], query = "yeellow": correct = "" (no match)
// Example: wordlist = ["YellOw"], query = "yllw": correct = "" (no match)

// In addition, the spell checker operates under the following precedence rules:
// - When the query exactly matches a word in the wordlist (case-sensitive), you should return the same word back.
// - When the query matches a word up to capitlization, you should return the first such match in the wordlist.
// - When the query matches a word up to vowel errors, you should return the first such match in the wordlist.
// - If the query has no matches in the wordlist, you should return the empty string.

// Given some queries, return a list of words answer, where answer[i] is the correct word for query = queries[i].

// Input: wordlist = ["KiTe","kite","hare","Hare"], queries = ["kite","Kite","KiTe","Hare","HARE","Hear","hear","keti","keet","keto"]
// Output: ["kite","KiTe","KiTe","Hare","hare","","","KiTe","","KiTe"]

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Sept14__VowelSpellchecker {
    public static String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> exactWords = new HashSet<>();
        Map<String, String> caseInsensitive = new HashMap<>();
        Map<String, String> vowelInsensitive = new HashMap<>();
        for (String word : wordlist) {
            exactWords.add(word);
            String lowerWord = word.toLowerCase();
            caseInsensitive.putIfAbsent(lowerWord, word);
            String devoweledWord = devowel(lowerWord);
            vowelInsensitive.putIfAbsent(devoweledWord, word);
        }
        String[] result = new String[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String query = queries[i];
            if (exactWords.contains(query)) {
                result[i] = query;
            } else {
                String lowerQuery = query.toLowerCase();
                if (caseInsensitive.containsKey(lowerQuery)) {
                    result[i] = caseInsensitive.get(lowerQuery);
                } else {
                    String devoweledQuery = devowel(lowerQuery);
                    result[i] = vowelInsensitive.getOrDefault(devoweledQuery, "");
                }
            }
        }
        return result;
    }

    private static String devowel(String word) {
        StringBuilder sb = new StringBuilder();
        for (char c : word.toCharArray()) {
            sb.append(isVowel(c) ? '*' : c);
        }
        return sb.toString();
    }

    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public static void main(String[] args) {
        String[] wordlist = {"KiTe", "kite", "hare", "Hare"};
        String[] queries = {"kite", "Kite", "KiTe", "Hare", "HARE", "Hear", "hear", "keti", "keet", "keto"};
        System.out.println(java.util.Arrays.toString(spellchecker(wordlist, queries)));
        // ["kite","KiTe","KiTe","Hare","hare","","","KiTe","","KiTe"]
    }
}
