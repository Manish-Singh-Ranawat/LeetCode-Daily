// Minimum Time to Repair Cars - https://leetcode.com/problems/minimum-time-to-repair-cars/?envType=daily-question&envId=2025-03-16

// You are given an integer array ranks representing the ranks of some mechanics. ranksi is the rank of the ith mechanic. A mechanic with a rank r can repair n cars in r * n2 minutes.

// You are also given an integer cars representing the total number of cars waiting in the garage to be repaired.

// Return the minimum time taken to repair all the cars.

// Note: All the mechanics can repair the cars simultaneously.

// Input: ranks = [4,2,3,1], cars = 10
// Output: 16
// Explanation: 
// - The first mechanic will repair two cars. The time required is 4 * 2 * 2 = 16 minutes.
// - The second mechanic will repair two cars. The time required is 2 * 2 * 2 = 8 minutes.
// - The third mechanic will repair two cars. The time required is 3 * 2 * 2 = 12 minutes.
// - The fourth mechanic will repair four cars. The time required is 1 * 4 * 4 = 16 minutes.
// It can be proved that the cars cannot be repaired in less than 16 minutes.​​​​​

public class March16__MinimumTimeToRepairCars {
    public static long repairCars(int[] ranks, int cars) {
        int n = ranks.length;
        long low = 1;
        long high = (long) ranks[0] * cars * cars;
        for (int i = 1; i < n; i++) {
            high = Math.min(high, (long) ranks[i] * cars * cars);
        }
        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (canRepair(mid, ranks, cars)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private static boolean canRepair(long time, int[] ranks, int cars) {
        long count = 0;
        for (int rank : ranks) {
            count += (long) Math.sqrt(time / rank);
            if (count >= cars)
                return true;
        }
        return count >= cars;
    }

    public static void main(String[] args) {
        int[] ranks = { 4, 2, 3, 1 };
        int cars = 10;
        System.out.println(repairCars(ranks, cars));
        // 16
    }
}
