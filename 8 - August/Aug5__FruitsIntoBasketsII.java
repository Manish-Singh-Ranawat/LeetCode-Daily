// Fruits Into Baskets II - https://leetcode.com/problems/fruits-into-baskets-ii/description/

// You are given two arrays of integers, fruits and baskets, each of length n, where fruits[i] represents the quantity of the ith type of fruit, and baskets[j] represents the capacity of the jth basket.

// From left to right, place the fruits according to these rules:
// - Each fruit type must be placed in the leftmost available basket with a capacity greater than or equal to the quantity of that fruit type.
// - Each basket can hold only one type of fruit.
// - If a fruit type cannot be placed in any basket, it remains unplaced.

// Return the number of fruit types that remain unplaced after all possible allocations are made.

// Input: fruits = [4,2,5], baskets = [3,5,4]
// Output: 1
// Explanation:
// fruits[0] = 4 is placed in baskets[1] = 5.
// fruits[1] = 2 is placed in baskets[0] = 3.
// fruits[2] = 5 cannot be placed in baskets[2] = 4.
// Since one fruit type remains unplaced, we return 1.

public class Aug5__FruitsIntoBasketsII {
    public static int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            boolean isPlaced = false;
            for (int j = 0; j < n; j++) {
                if (baskets[j] >= fruits[i]) {
                    baskets[j] = 0;
                    isPlaced = true;
                    break;
                }
            }
            if (!isPlaced)
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] fruits = { 4, 2, 5 };
        int[] baskets = { 3, 5, 4 };
        System.out.println(numOfUnplacedFruits(fruits, baskets));
        // 1
    }
}
