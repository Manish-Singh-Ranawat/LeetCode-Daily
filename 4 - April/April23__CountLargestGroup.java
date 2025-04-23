// Count Largest Group - https://leetcode.com/problems/count-largest-group/description/?envType=daily-question&envId=2025-04-23

// You are given an integer n.
// Each number from 1 to n is grouped according to the sum of its digits.
// Return the number of groups that have the largest size.

// Input: n = 13
// Output: 4
// Explanation: There are 9 groups in total, they are grouped according sum of its digits of numbers from 1 to 13:
// [1,10], [2,11], [3,12], [4,13], [5], [6], [7], [8], [9].
// There are 4 groups with largest size.

import java.util.HashMap;
import java.util.Map;

public class April23__CountLargestGroup {
    public static int countLargestGroup(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        int largest = 0;
        int count = 0;
        for (int i = 1; i <= n; i++) {
            int num = i;
            int sum = 0;
            while (num != 0) {
                sum += num % 10;
                num /= 10;
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            int size = map.get(sum);
            if (size > largest) {
                largest = size;
                count = 1;
            } else if (size == largest) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int n = 13;
        System.out.println(countLargestGroup(n));
        // 4
    }
}
