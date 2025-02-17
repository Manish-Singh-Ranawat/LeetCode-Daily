// Letter Tile Possibilities - https://leetcode.com/problems/letter-tile-possibilities/description/?envType=daily-question&envId=2025-02-17

// You have n  tiles, where each tile has one letter tiles[i] printed on it.

// Return the number of possible non-empty sequences of letters you can make using the letters printed on those tiles.

// Input: tiles = "AAB"
// Output: 8
// Explanation: The possible sequences are "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA".

public class Feb17__LetterTilePossibilities {
    public static int numTilePossibilities(String tiles) {
        int[] count = new int[26];
        for (char c : tiles.toCharArray()) {
            count[c - 'A']++;
        }
        return countSequences(count);
    }

    private static int countSequences(int[] count) {
        int totalCount = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] == 0) {
                continue;
            }
            totalCount++;
            count[i]--;
            totalCount += countSequences(count);
            count[i]++;
        }

        return totalCount;
    }

    public static void main(String[] args) {
        String tiles = "AAB";
        System.out.println(numTilePossibilities(tiles));
        // 8
    }
}
