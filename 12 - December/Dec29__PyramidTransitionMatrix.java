// Pyramid Transition Matrix - https://leetcode.com/problems/pyramid-transition-matrix/?envType=daily-question&envId=2025-12-29

// You are stacking blocks to form a pyramid. Each block has a color, which is represented by a single letter. Each row of blocks contains one less block than the row beneath it and is centered on top.

// To make the pyramid aesthetically pleasing, there are only specific triangular patterns that are allowed. A triangular pattern consists of a single block stacked on top of two blocks. The patterns are given as a list of three-letter strings allowed, where the first two characters of a pattern represent the left and right bottom blocks respectively, and the third character is the top block.

// - For example, "ABC" represents a triangular pattern with a 'C' block stacked on top of an 'A' (left) and 'B' (right) block. Note that this is different from "BAC" where 'B' is on the left bottom and 'A' is on the right bottom.

// You start with a bottom row of blocks bottom, given as a single string, that you must use as the base of the pyramid.

// Given bottom and allowed, return true if you can build the pyramid all the way to the top such that every triangular pattern in the pyramid is in allowed, or false otherwise.

// Input: bottom = "BCD", allowed = ["BCC","CDE","CEA","FFF"]
// Output: true
// Explanation: The allowed triangular patterns are shown on the right.
// Starting from the bottom (level 3), we can build "CE" on level 2 and then build "A" on level 1.
// There are three triangular patterns in the pyramid, which are "BCC", "CDE", and "CEA". All are allowed.

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Dec29__PyramidTransitionMatrix {
    static int[][] T;
    static Set<Long> seen;

    public static boolean pyramidTransition(String bottom, List<String> allowed) {
        T = new int[7][7];
        for (String a : allowed)
            T[a.charAt(0) - 'A'][a.charAt(1) - 'A'] |= 1 << (a.charAt(2) - 'A');
        seen = new HashSet<Long>();
        int N = bottom.length();
        int[][] A = new int[N][N];
        int t = 0;
        for (char c : bottom.toCharArray())
            A[N - 1][t++] = c - 'A';
        return solve(A, 0, N - 1, 0);
    }

    public static boolean solve(int[][] A, long R, int N, int i) {
        if (N == 1 && i == 1) {
            return true;
        } else if (i == N) {
            if (seen.contains(R))
                return false;
            seen.add(R);
            return solve(A, 0, N - 1, 0);
        } else {
            int w = T[A[N][i]][A[N][i + 1]];
            for (int b = 0; b < 7; ++b)
                if (((w >> b) & 1) != 0) {
                    A[N - 1][i] = b;
                    if (solve(A, R * 8 + (b + 1), N, i + 1))
                        return true;
                }
            return false;
        }
    }

    public static void main(String[] args) {
        String bottom = "BCD";
        List<String> allowed = List.of("BCC", "CDE", "CEA", "FFF");
        System.out.println(pyramidTransition(bottom, allowed));
        // true
    }
}
