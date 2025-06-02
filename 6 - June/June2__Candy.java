// Candy - https://leetcode.com/problems/candy/description/?envType=daily-question&envId=2025-06-02

// There are n children standing in a line. Each child is assigned a rating
// value given in the integer array ratings.

// You are giving candies to these children subjected to the following requirements:
// - Each child must have at least one candy.
// - Children with a higher rating get more candies than their neighbors.

// Return the minimum number of candies you need to have to distribute the
// candies to the children.

// Input: ratings = [1,0,2]
// Output: 5
// Explanation: You can allocate to the first, second and third child with 2, 1,
// 2 candies respectively.

public class June2__Candy {
    public static int candy(int[] ratings) {
        int n = ratings.length;
        int i = 1;
        int sum = 1;
        while (i < n) {
            if (ratings[i] == ratings[i - 1]) {
                sum += 1;
                i++;
                continue;
            }
            int peak = 1;
            while (i < n && ratings[i] > ratings[i - 1]) {
                peak++;
                sum += peak;
                i++;
            }
            int down = 1;
            while (i < n && ratings[i] < ratings[i - 1]) {
                sum += down;
                down++;
                i++;
            }
            if (down > peak) {
                sum += (down - peak);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] ratings = { 1, 0, 2 };
        System.out.println(candy(ratings));
        // 5
    }
}
