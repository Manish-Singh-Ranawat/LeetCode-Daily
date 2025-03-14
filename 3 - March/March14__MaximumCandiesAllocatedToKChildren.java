// Maximum Candies Allocated to K Children - https://leetcode.com/problems/maximum-candies-allocated-to-k-children/description/?envType=daily-question&envId=2025-03-14

// You are given a 0-indexed integer array candies. Each element in the array denotes a pile of candies of size candies[i]. You can divide each pile into any number of sub piles, but you cannot merge two piles together.

// You are also given an integer k. You should allocate piles of candies to k children such that each child gets the same number of candies. Each child can be allocated candies from only one pile of candies and some piles of candies may go unused.

// Return the maximum number of candies each child can get.

// Input: candies = [5,8,6], k = 3
// Output: 5
// Explanation: We can divide candies[1] into 2 piles of size 5 and 3, and candies[2] into 2 piles of size 5 and 1. We now have five piles of candies of sizes 5, 5, 3, 5, and 1. We can allocate the 3 piles of size 5 to 3 children. It can be proven that each child cannot receive more than 5 candies.

public class March14__MaximumCandiesAllocatedToKChildren {
    public static int maximumCandies(int[] candies, long k) {
        int n = candies.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, candies[i]);
        }
        int low = 1;
        int high = max;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isPossible(mid, k, candies)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }

    private static boolean isPossible(int c, long k, int[] candies) {
        int n = candies.length;
        long total = 0;
        for (int i = 0; i < n; i++) {
            total += candies[i] / c;
        }
        return total >= k;
    }

    public static void main(String[] args) {
        int[] candies = { 5, 8, 6 };
        long k = 3;
        System.out.println(maximumCandies(candies, k));
        // 5
    }
}
