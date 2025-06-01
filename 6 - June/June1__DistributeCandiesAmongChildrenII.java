// Distribute Candies Among Children II - https://leetcode.com/problems/distribute-candies-among-children-ii/description/?envType=daily-question&envId=2025-06-01

// You are given two positive integers n and limit.

// Return the total number of ways to distribute n candies among 3 children such that no child gets more than limit candies.

// Input: n = 3, limit = 3
// Output: 10
// Explanation: There are 10 ways to distribute 3 candies such that no child gets more than 3 candies: (0, 0, 3), (0, 1, 2), (0, 2, 1), (0, 3, 0), (1, 0, 2), (1, 1, 1), (1, 2, 0), (2, 0, 1), (2, 1, 0) and (3, 0, 0).

public class June1__DistributeCandiesAmongChildrenII {
    public static long distributeCandies(int n, int limit) {
        int min = Math.max(0, n - 2 * limit);
        int max = Math.min(limit, n);
        long ans = 0;
        for (int i = min; i <= max; i++) {
            ans += Math.min(limit, n - i) - Math.max(0, n - i - limit) + 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 3;
        int limit = 3;
        System.out.println(distributeCandies(n, limit));
        // 10
    }
}
