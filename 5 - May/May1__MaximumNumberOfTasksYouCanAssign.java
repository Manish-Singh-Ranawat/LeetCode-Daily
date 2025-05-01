// Maximum Number of Tasks You Can Assign - https://leetcode.com/problems/maximum-number-of-tasks-you-can-assign/description/?envType=daily-question&envId=2025-05-01

// You have n tasks and m workers. Each task has a strength requirement stored in a 0-indexed integer array tasks, with the ith task requiring tasks[i] strength to complete. The strength of each worker is stored in a 0-indexed integer array workers, with the jth worker having workers[j] strength. Each worker can only be assigned to a single task and must have a strength greater than or equal to the task's strength requirement (i.e., workers[j] >= tasks[i]).

// Additionally, you have pills magical pills that will increase a worker's strength by strength. You can decide which workers receive the magical pills, however, you may only give each worker at most one magical pill.

// Given the 0-indexed integer arrays tasks and workers and the integers pills and strength, return the maximum number of tasks that can be completed.

// Input: tasks = [3,2,1], workers = [0,3,3], pills = 1, strength = 1
// Output: 3
// Explanation:
// We can assign the magical pill and tasks as follows:
// - Give the magical pill to worker 0.
// - Assign worker 0 to task 2 (0 + 1 >= 1)
// - Assign worker 1 to task 1 (3 >= 2)
// - Assign worker 2 to task 0 (3 >= 3)

import java.util.Arrays;
import java.util.TreeMap;

public class May1__MaximumNumberOfTasksYouCanAssign {
    public static int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        Arrays.sort(tasks);
        Arrays.sort(workers);
        int n = tasks.length, m = workers.length;
        int left = 1, right = Math.min(m, n), ans = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (check(tasks, workers, pills, strength, mid)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    private static boolean check(int[] tasks, int[] workers, int pills, int strength, int mid) {
        int p = pills;
        TreeMap<Integer, Integer> ws = new TreeMap<>();
        for (int i = workers.length - mid; i < workers.length; ++i) {
            ws.put(workers[i], ws.getOrDefault(workers[i], 0) + 1);
        }
        for (int i = mid - 1; i >= 0; --i) {
            Integer key = ws.lastKey();
            if (key >= tasks[i]) {
                ws.put(key, ws.get(key) - 1);
                if (ws.get(key) == 0) {
                    ws.remove(key);
                }
            } else {
                if (p == 0) {
                    return false;
                }
                key = ws.ceilingKey(tasks[i] - strength);
                if (key == null) {
                    return false;
                }
                ws.put(key, ws.get(key) - 1);
                if (ws.get(key) == 0) {
                    ws.remove(key);
                }
                --p;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] tasks = { 3, 2, 1 };
        int[] workers = { 0, 3, 3 };
        int pills = 1;
        int strength = 1;
        System.out.println(maxTaskAssign(tasks, workers, pills, strength));
        // 3
    }
}
