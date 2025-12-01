// Maximum Running Time of N Computers - https://leetcode.com/problems/maximum-running-time-of-n-computers/description/?envType=daily-question&envId=2025-12-01

// You have n computers. You are given the integer n and a 0-indexed integer array batteries where the ith battery can run a computer for batteries[i] minutes. You are interested in running all n computers simultaneously using the given batteries.

// Initially, you can insert at most one battery into each computer. After that and at any integer time moment, you can remove a battery from a computer and insert another battery any number of times. The inserted battery can be a totally new battery or a battery from another computer. You may assume that the removing and inserting processes take no time.

// Note that the batteries cannot be recharged.

// Return the maximum number of minutes you can run all the n computers simultaneously.

// Input: n = 2, batteries = [3,3,3]
// Output: 4
// Explanation: 
// Initially, insert battery 0 into the first computer and battery 1 into the second computer.
// After two minutes, remove battery 1 from the second computer and insert battery 2 instead. Note that battery 1 can still run for one minute.
// At the end of the third minute, battery 0 is drained, and you need to remove it from the first computer and insert battery 1 instead.
// By the end of the fourth minute, battery 1 is also drained, and the first computer is no longer running.
// We can run the two computers simultaneously for at most 4 minutes, so we return 4.

public class Dec1__MaximumRunningTimeOfNComputers {
    public static long maxRunTime(int n, int[] batteries) {
        long sumPower = 0;
        for (int power : batteries)
            sumPower += power;
        long left = 1, right = sumPower / n;
        while (left < right) {
            long target = right - (right - left) / 2;
            long extra = 0;
            for (int power : batteries)
                extra += Math.min(power, target);
            if (extra >= (long) (n * target))
                left = target;
            else
                right = target - 1;
        }
        return left;
    }

    public static void main(String[] args) {
        int n = 2;
        int[] batteries = { 3, 3, 3 };
        System.out.println(maxRunTime(n, batteries));
        // 4
    }
}