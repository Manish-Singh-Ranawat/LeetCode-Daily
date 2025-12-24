// Apple Redistribution into Boxes - https://leetcode.com/problems/apple-redistribution-into-boxes/description/?envType=daily-question&envId=2025-12-24

// You are given an array apple of size n and an array capacity of size m.

// There are n packs where the ith pack contains apple[i] apples. There are m boxes as well, and the ith box has a capacity of capacity[i] apples.

// Return the minimum number of boxes you need to select to redistribute these n packs of apples into boxes.

// Note that, apples from the same pack can be distributed into different boxes.

// Input: apple = [1,3,2], capacity = [4,3,1,5,2]
// Output: 2
// Explanation: We will use boxes with capacities 4 and 5.
// It is possible to distribute the apples as the total capacity is greater than or equal to the total number of apples.

import java.util.Arrays;
import java.util.Collections;

public class Dec24__AppleRedistributionIntoBoxes {
    public static int minimumBoxes(int[] apple, int[] capacity) {
        int sum = 0;
        for (int a : apple)
            sum += a;
        Integer[] capArray = new Integer[capacity.length];
        for (int i = 0; i < capacity.length; i++)
            capArray[i] = capacity[i];
        Arrays.sort(capArray, Collections.reverseOrder());
        int need = 0;
        while (sum > 0) {
            sum -= capArray[need];
            need += 1;
        }
        return need;
    }

    public static void main(String[] args) {
        int[] apple = { 1, 3, 2 };
        int[] capacity = { 4, 3, 1, 5, 2 };
        System.out.println(minimumBoxes(apple, capacity));
        // 2
    }
}