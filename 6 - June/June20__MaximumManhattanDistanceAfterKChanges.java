// Maximum Manhattan Distance After K Changes -https://leetcode.com/problems/maximum-manhattan-distance-after-k-changes/description/?envType=daily-question&envId=2025-06-20

// You are given a string s consisting of the characters 'N', 'S', 'E', and 'W', where s[i] indicates movements in an infinite grid:
// - 'N' : Move north by 1 unit.
// - 'S' : Move south by 1 unit.
// - 'E' : Move east by 1 unit.
// - 'W' : Move west by 1 unit.

// Initially, you are at the origin (0, 0). You can change at most k characters to any of the four directions.

// Find the maximum Manhattan distance from the origin that can be achieved at any time while performing the movements in order.

// The Manhattan Distance between two cells (xi, yi) and (xj, yj) is |xi - xj| + |yi - yj|.

// Input: s = "NWSE", k = 1
// Output: 3
// Explanation: Change s[2] from 'S' to 'N'. The string s becomes "NWNE".

//   Movement	   Position(x, y)	Manhattan Distance	 Maximum
// s[0] == 'N'	     (0, 1)	           0 + 1 = 1	       1
// s[1] == 'W'	     (-1, 1)	       1 + 1 = 2	       2
// s[2] == 'N'	     (-1, 2)	       1 + 2 = 3	       3
// s[3] == 'E'	     (0, 2)	           0 + 2 = 2	       3
// The maximum Manhattan distance from the origin that can be achieved is 3. Hence, 3 is the output.

public class June20__MaximumManhattanDistanceAfterKChanges {
    public static int maxDistance(String s, int k) {
        int north = 0;
        int south = 0;
        int east = 0;
        int west = 0;
        int max = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char d = s.charAt(i);
            if (d == 'N')
                north++;
            else if (d == 'S')
                south++;
            else if (d == 'E')
                east++;
            else
                west++;
            int md = Math.abs(north - south) + Math.abs(east - west);
            int steps = i + 1;
            int wasted = steps - md;
            int extra = Math.min(2 * k, wasted);
            max = Math.max(max, md + extra);
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "NWSE";
        int k = 1;
        System.out.println(maxDistance(s, k));
        // 3
    }
}
