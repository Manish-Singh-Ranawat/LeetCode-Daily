// Maximum Employees to Be Invited to a Meeting - https://leetcode.com/problems/maximum-employees-to-be-invited-to-a-meeting/description/?envType=daily-question&envId=2025-01-26

// A company is organizing a meeting and has a list of n employees, waiting to be invited. They have arranged for a large circular table, capable of seating any number of employees.

// The employees are numbered from 0 to n - 1. Each employee has a favorite person and they will attend the meeting only if they can sit next to their favorite person at the table. The favorite person of an employee is not themself.

// Given a 0-indexed integer array favorite, where favorite[i] denotes the favorite person of the ith employee, return the maximum number of employees that can be invited to the meeting.

// Input: favorite = [2,2,1,2]
// Output: 3
// Explanation:
// All employees cannot be invited because employee 2 cannot sit beside employees 0, 1, and 3, simultaneously.
// Note that the company can also invite employees 1, 2, and 3, and give them their desired seats.
// The maximum number of employees that can be invited to the meeting is 3. 

import java.util.LinkedList;
import java.util.Queue;

public class Jan26__MaximumEmployeesToBeInvitedToMeeting {
    public static int maximumInvitations(int[] favorite) {
        int n = favorite.length;
        int[] inDeg = new int[n];
        int[] chainLen = new int[n];
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        for (int f : favorite)
            inDeg[f]++;
        for (int i = 0; i < n; i++)
            if (inDeg[i] == 0)
                q.add(i);
        while (!q.isEmpty()) {
            int u = q.poll();
            visited[u] = true;
            int v = favorite[u];
            chainLen[v] = Math.max(chainLen[v], chainLen[u] + 1);
            if (--inDeg[v] == 0)
                q.add(v);
        }
        int maxCycle = 0, pairChains = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i])
                continue;
            int cycleLen = 0, current = i;
            while (!visited[current]) {
                visited[current] = true;
                current = favorite[current];
                cycleLen++;
            }
            if (cycleLen == 2)
                pairChains += 2 + chainLen[i] + chainLen[favorite[i]];
            else
                maxCycle = Math.max(maxCycle, cycleLen);
        }
        return Math.max(maxCycle, pairChains);
    }

    public static void main(String[] args) {
        int[] favorite = { 2, 2, 1, 2 };
        System.out.println(maximumInvitations(favorite));
        // 3
    }
}
