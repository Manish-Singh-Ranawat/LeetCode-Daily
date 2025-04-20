// Rabbits in Forest - https://leetcode.com/problems/rabbits-in-forest/description/?envType=daily-question&envId=2025-04-20

// There is a forest with an unknown number of rabbits. We asked n rabbits "How many rabbits have the same color as you?" and collected the answers in an integer array answers where answers[i] is the answer of the ith rabbit.

// Given the array answers, return the minimum number of rabbits that could be in the forest.

// Input: answers = [1,1,2]
// Output: 5
// Explanation:
// The two rabbits that answered "1" could both be the same color, say red.
// The rabbit that answered "2" can't be red or the answers would be inconsistent.
// Say the rabbit that answered "2" was blue.
// Then there should be 2 other blue rabbits in the forest that didn't answer into the array.
// The smallest possible number of rabbits in the forest is therefore 5: 3 that answered plus 2 that didn't.

import java.util.HashMap;
import java.util.Map;

public class April20__RabbitsInForest {
    public static int numRabbits(int[] answers) {
        Map<Integer, Integer> map = new HashMap<>();
         int res = 0;
         for (int it : answers) {
             map.put(it, map.getOrDefault(it, 0) + 1);
         }
         for (Map.Entry<Integer, Integer> it : map.entrySet()) {
             int key = it.getKey();
             int val = it.getValue();
             int groupSize = key + 1;
             res += Math.ceil((double) val / groupSize) * groupSize;
         }
         return res;
     }

    public static void main(String[] args) {
        int[] answers = { 1, 1, 2 };
        System.out.println(numRabbits(answers));
        // 5
    }
}
