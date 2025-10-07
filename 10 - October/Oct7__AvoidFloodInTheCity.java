// Avoid Flood in The City - https://leetcode.com/problems/avoid-flood-in-the-city/description/?envType=daily-question&envId=2025-10-07

// Your country has an infinite number of lakes. Initially, all the lakes are empty, but when it rains over the nth lake, the nth lake becomes full of water. If it rains over a lake that is full of water, there will be a flood. Your goal is to avoid floods in any lake.

// Given an integer array rains where:
// - rains[i] > 0 means there will be rains over the rains[i] lake.
// - rains[i] == 0 means there are no rains this day and you can choose one lake this day and dry it.

// Return an array ans where:
// - ans.length == rains.length
// - ans[i] == -1 if rains[i] > 0.
// - ans[i] is the lake you choose to dry in the ith day if rains[i] == 0.

// If there are multiple valid answers return any of them. If it is impossible to avoid flood return an empty array.

// Notice that if you chose to dry a full lake, it becomes empty, but if you chose to dry an empty lake, nothing changes.

// Input: rains = [1,2,0,0,2,1]
// Output: [-1,-1,2,1,-1,-1]
// Explanation: After the first day full lakes are [1]
// After the second day full lakes are [1,2]
// After the third day, we dry lake 2. Full lakes are [1]
// After the fourth day, we dry lake 1. There is no full lakes.
// After the fifth day, full lakes are [2].
// After the sixth day, full lakes are [1,2].
// It is easy that this scenario is flood-free. [-1,-1,1,2,-1,-1] is another acceptable scenario.

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class Oct7__AvoidFloodInTheCity {
    public static int[] avoidFlood(int[] rains) {
        int[] ans = new int[rains.length];
        Arrays.fill(ans, 1);
        TreeSet<Integer> set = new TreeSet<Integer>();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < rains.length; ++i) {
            if (rains[i] == 0) {
                set.add(i);
            } else {
                ans[i] = -1;
                if (map.containsKey(rains[i])) {
                    Integer it = set.ceiling(map.get(rains[i]));
                    if (it == null) {
                        return new int[0];
                    }
                    ans[it] = rains[i];
                    set.remove(it);
                }
                map.put(rains[i], i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] rains = { 1, 2, 0, 0, 2, 1 };
        System.out.println(Arrays.toString(avoidFlood(rains)));
        // [-1,-1,2,1,-1,-1]
    }
}
