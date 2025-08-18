// 24 Game - https://leetcode.com/problems/24-game/description/?envType=daily-question&envId=2025-08-18

// You are given an integer array cards of length 4. You have four cards, each containing a number in the range [1, 9]. You should arrange the numbers on these cards in a mathematical expression using the operators ['+', '-', '*', '/'] and the parentheses '(' and ')' to get the value 24.

// You are restricted with the following rules:
// - The division operator '/' represents real division, not integer division.
//   For example, 4 / (1 - 2 / 3) = 4 / (1 / 3) = 12.
// - Every operation done is between two numbers. In particular, we cannot use '-' as a unary operator.
//   For example, if cards = [1, 1, 1, 1], the expression "-1 - 1 - 1 - 1" is not allowed.
// - You cannot concatenate numbers together
//   For example, if cards = [1, 2, 1, 2], the expression "12 + 12" is not valid.

// Return true if you can get such expression that evaluates to 24, and false otherwise.

// Input: cards = [4,1,8,7]
// Output: true
// Explanation: (8-4) * (7-1) = 24

import java.util.ArrayList;
import java.util.List;

public class Aug18__24Game {
    final static double EPS = 1e-6;

    public static boolean judgePoint24(int[] cards) {
        List<Double> nums = new ArrayList<>();
        for (int n : cards)
            nums.add((double) n);
        return dfs(nums);
    }

    private static boolean dfs(List<Double> nums) {
        if (nums.size() == 1) {
            return Math.abs(nums.get(0) - 24.0) < EPS;
        }
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.size(); j++) {
                if (i == j)
                    continue;
                List<Double> next = new ArrayList<>();
                for (int k = 0; k < nums.size(); k++) {
                    if (k != i && k != j)
                        next.add(nums.get(k));
                }
                for (double val : compute(nums.get(i), nums.get(j))) {
                    next.add(val);
                    if (dfs(next))
                        return true;
                    next.remove(next.size() - 1);
                }
            }
        }
        return false;
    }

    private static List<Double> compute(double a, double b) {
        List<Double> res = new ArrayList<>();
        res.add(a + b);
        res.add(a - b);
        res.add(b - a);
        res.add(a * b);
        if (Math.abs(b) > EPS)
            res.add(a / b);
        if (Math.abs(a) > EPS)
            res.add(b / a);
        return res;
    }

    public static void main(String[] args) {
        int[] cards = { 4, 1, 8, 7 };
        System.out.println(judgePoint24(cards));
        // true
    }
}
