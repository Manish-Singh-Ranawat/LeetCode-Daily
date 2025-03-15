// House Robber IV - https://leetcode.com/problems/house-robber-iv/?envType=daily-question&envId=2025-03-15

// There are several consecutive houses along a street, each of which has some money inside. There is also a robber, who wants to steal money from the homes, but he refuses to steal from adjacent homes.

// The capability of the robber is the maximum amount of money he steals from one house of all the houses he robbed.

// You are given an integer array nums representing how much money is stashed in each house. More formally, the ith house from the left has nums[i] dollars.

// You are also given an integer k, representing the minimum number of houses the robber will steal from. It is always possible to steal at least k houses.

// Return the minimum capability of the robber out of all the possible ways to steal at least k houses.

// Input: nums = [2,3,5,9], k = 2
// Output: 5
// Explanation: 
// There are three ways to rob at least 2 houses:
// - Rob the houses at indices 0 and 2. Capability is max(nums[0], nums[2]) = 5.
// - Rob the houses at indices 0 and 3. Capability is max(nums[0], nums[3]) = 9.
// - Rob the houses at indices 1 and 3. Capability is max(nums[1], nums[3]) = 9.
// Therefore, we return min(5, 9, 9) = 5.

public class March15__HouseRobberIV {
    public static int minCapability(int[] nums, int k) {
        int n = nums.length;
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            low = Math.min(low, nums[i]);
            high = Math.max(high, nums[i]);
        }
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (check(mid, nums, k)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private static boolean check(int cap, int[] nums, int k) {
        int n = nums.length;
        int i = 0;
        int count = 0;
        while (i < n) {
            if (nums[i] <= cap) {
                count++;
                i += 2;
            } else
                i += 1;
        }
        return count >= k;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 3, 5, 9 };
        int k = 2;
        System.out.println(minCapability(nums, k));
        // 5
    }
}
