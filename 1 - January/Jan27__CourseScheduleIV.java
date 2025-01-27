// Course Schedule IV - https://leetcode.com/problems/course-schedule-iv/description/?envType=daily-question&envId=2025-01-27

// There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course ai first if you want to take course bi.

// For example, the pair [0, 1] indicates that you have to take course 0 before you can take course 1.
// Prerequisites can also be indirect. If course a is a prerequisite of course b, and course b is a prerequisite of course c, then course a is a prerequisite of course c.

// You are also given an array queries where queries[j] = [uj, vj]. For the jth query, you should answer whether course uj is a prerequisite of course vj or not.

// Return a boolean array answer, where answer[j] is the answer to the jth query.

// Input: numCourses = 2, prerequisites = [[1,0]], queries = [[0,1],[1,0]]
// Output: [false,true]
// Explanation: The pair [1, 0] indicates that you have to take course 1 before you can take course 0.
// Course 0 is not a prerequisite of course 1, but the opposite is true.

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Jan27__CourseScheduleIV {
    public static List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int[] inDeg = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] p : prerequisites) {
            adj.get(p[0]).add(p[1]);
            inDeg[p[1]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDeg[i] == 0) {
                q.offer(i);
            }
        }
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            map.put(i, new HashSet<>());
        }
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int adjNode : adj.get(cur)) {
                map.get(adjNode).add(cur);
                map.get(adjNode).addAll(map.get(cur));
                inDeg[adjNode]--;
                if (inDeg[adjNode] == 0) {
                    q.offer(adjNode);
                }
            }
        }
        int len = queries.length;
        List<Boolean> ans = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            ans.add(map.get(queries[i][1]).contains(queries[i][0]));
        }
        return ans;
    }

    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = { { 1, 0 } };
        int[][] queries = { { 0, 1 }, { 1, 0 } };
        System.out.println(checkIfPrerequisite(numCourses, prerequisites, queries));
        // [false, true]
    }
}
