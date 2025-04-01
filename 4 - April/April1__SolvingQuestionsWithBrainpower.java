// Solving Questions With Brainpower - https://leetcode.com/problems/solving-questions-with-brainpower/description/?envType=daily-question&envId=2025-04-01

// You are given a 0-indexed 2D integer array questions where questions[i] = [pointsi, brainpoweri].

// The array describes the questions of an exam, where you have to process the questions in order (i.e., starting from question 0) and make a decision whether to solve or skip each question. Solving question i will earn you pointsi points but you will be unable to solve each of the next brainpoweri questions. If you skip question i, you get to make the decision on the next question.

// For example, given questions = [[3, 2], [4, 3], [4, 4], [2, 5]]:
// - If question 0 is solved, you will earn 3 points but you will be unable to solve questions 1 and 2.
// - If instead, question 0 is skipped and question 1 is solved, you will earn 4 points but you will be unable to solve questions 2 and 3.

// Return the maximum points you can earn for the exam.

// Input: questions = [[3,2],[4,3],[4,4],[2,5]]
// Output: 5
// Explanation: The maximum points can be earned by solving questions 0 and 3.
// - Solve question 0: Earn 3 points, will be unable to solve the next 2 questions
// - Unable to solve questions 1 and 2
// - Solve question 3: Earn 2 points
// Total points earned: 3 + 2 = 5. There is no other way to earn 5 or more points.

import java.util.Arrays;

public class April1__SolvingQuestionsWithBrainpower {
    // -- Tabulation --
    public static long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n];
        for (int i = n - 1; i >= 0; i--) {
            long pick = questions[i][0] + (i + questions[i][1] + 1 < n ? dp[i +
                    questions[i][1] + 1] : 0);
            long notPick = i + 1 < n ? dp[i + 1] : 0;
            dp[i] = Math.max(pick, notPick);
        }
        return dp[0];
    }

    // -- Memoization --
    // public static long mostPoints(int[][] questions) {
    //     int n = questions.length;
    //     long[] dp = new long[n];
    //     Arrays.fill(dp, -1);
    //     return helper(0, questions, dp);
    // }

    // private static long helper(int i, int[][] questions, long[] dp) {
    //     if (i >= questions.length) {
    //         return 0;
    //     }
    //     if (dp[i] != -1)
    //         return dp[i];
    //     long pick = questions[i][0] + helper(i + questions[i][1] + 1, questions, dp);
    //     long notPick = helper(i + 1, questions, dp);
    //     return dp[i] = Math.max(pick, notPick);
    // }

    public static void main(String[] args) {
        int[][] questions = { { 3, 2 }, { 4, 3 }, { 4, 4 }, { 2, 5 } };
        System.out.println(mostPoints(questions));
        // 5
    }
}