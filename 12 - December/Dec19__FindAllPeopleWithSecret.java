// Find All People With Secret - https://leetcode.com/problems/find-all-people-with-secret/description/?envType=daily-question&envId=2025-12-19

// You are given an integer n indicating there are n people numbered from 0 to n - 1. You are also given a 0-indexed 2D integer array meetings where meetings[i] = [xi, yi, timei] indicates that person xi and person yi have a meeting at timei. A person may attend multiple meetings at the same time. Finally, you are given an integer firstPerson.

// Person 0 has a secret and initially shares the secret with a person firstPerson at time 0. This secret is then shared every time a meeting takes place with a person that has the secret. More formally, for every meeting, if a person xi has the secret at timei, then they will share the secret with person yi, and vice versa.

// The secrets are shared instantaneously. That is, a person may receive the secret and share it with people in other meetings within the same time frame.

// Return a list of all the people that have the secret after all the meetings have taken place. You may return the answer in any order.

// Input: n = 6, meetings = [[1,2,5],[2,3,8],[1,5,10]], firstPerson = 1
// Output: [0,1,2,3,5]
// Explanation:
// At time 0, person 0 shares the secret with person 1.
// At time 5, person 1 shares the secret with person 2.
// At time 8, person 2 shares the secret with person 3.
// At time 10, person 1 shares the secret with person 5.​​​​
// Thus, people 0, 1, 2, 3, and 5 know the secret after all the meetings.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Dec19__FindAllPeopleWithSecret {

    public static List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        Arrays.sort(meetings, (a, b) -> a[2] - b[2]);
        Map<Integer, List<int[]>> sameTimeMeetings = new TreeMap<>();
        for (int[] meeting : meetings) {
            int x = meeting[0], y = meeting[1], t = meeting[2];
            sameTimeMeetings.computeIfAbsent(t, k -> new ArrayList<>()).add(new int[] { x, y });
        }
        UnionFind graph = new UnionFind(n);
        graph.unite(firstPerson, 0);
        for (int t : sameTimeMeetings.keySet()) {
            for (int[] meeting : sameTimeMeetings.get(t)) {
                int x = meeting[0], y = meeting[1];
                graph.unite(x, y);
            }
            for (int[] meeting : sameTimeMeetings.get(t)) {
                int x = meeting[0], y = meeting[1];
                if (!graph.connected(x, 0)) {
                    graph.reset(x);
                    graph.reset(y);
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            if (graph.connected(i, 0)) {
                ans.add(i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 6;
        int[][] meetings = { { 1, 2, 5 }, { 2, 3, 8 }, { 1, 5, 10 } };
        int firstPerson = 1;
        System.out.println(findAllPeople(n, meetings, firstPerson));
        // [0, 1, 2, 3, 5]
    }
}

class UnionFind {
    private int[] parent;
    private int[] rank;

    public UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; ++i) {
            parent[i] = i;
        }
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public void unite(int x, int y) {
        int px = find(x);
        int py = find(y);
        if (px != py) {
            if (rank[px] > rank[py]) {
                parent[py] = px;
            } else if (rank[px] < rank[py]) {
                parent[px] = py;
            } else {
                parent[py] = px;
                rank[px] += 1;
            }
        }
    }

    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }

    public void reset(int x) {
        parent[x] = x;
        rank[x] = 0;
    }
}