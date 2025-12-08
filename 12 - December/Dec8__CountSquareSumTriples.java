// Count Square Sum Triples - https://leetcode.com/problems/count-square-sum-triples/description/?envType=daily-question&envId=2025-12-08

// A square triple (a,b,c) is a triple where a, b, and c are integers and a2 + b2 = c2.

// Given an integer n, return the number of square triples such that 1 <= a, b, c <= n.

// Input: n = 5
// Output: 2
// Explanation: The square triples are (3,4,5) and (4,3,5).

public class Dec8__CountSquareSumTriples {
    public static int countTriples(int n) {
        int res = 0;
        for (int a = 1; a <= n; a++) {
            for (int b = 1; b <= n; b++) {
                int c = (int) Math.sqrt(a * a + b * b + 1.0);
                if (c <= n && c * c == a * a + b * b)
                    res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(countTriples(n));
        // 2
    }
}
