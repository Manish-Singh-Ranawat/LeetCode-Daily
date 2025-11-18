// 1-bit and 2-bit Characters - https://leetcode.com/problems/1-bit-and-2-bit-characters/description/?envType=daily-question&envId=2025-11-18

// We have two special characters:
// - The first character can be represented by one bit 0.
// - The second character can be represented by two bits (10 or 11).

// Given a binary array bits that ends with 0, return true if the last character must be a one-bit character.

// Input: bits = [1,0,0]
// Output: true
// Explanation: The only way to decode it is two-bit character and one-bit character.
// So the last character is one-bit character.

public class Nov18__1bitAnd2bitCharacters {
    public static boolean isOneBitCharacter(int[] bits) {
        int n = bits.length;
        int i = 0;
        while (i < n - 1) {
            if (bits[i] == 1)
                i += 2;
            else
                i += 1;
        }
        return i == n - 1;
    }

    public static void main(String[] args) {
        int[] bits = { 1, 0, 0 };
        System.out.println(isOneBitCharacter(bits));
        // true
    }
}
