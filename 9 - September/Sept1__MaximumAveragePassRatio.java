// Maximum Average Pass Ratio - https://leetcode.com/problems/maximum-average-pass-ratio/description/?envType=daily-question&envId=2025-09-01

// There is a school that has classes of students and each class will be having a final exam. You are given a 2D integer array classes, where classes[i] = [passi, totali]. You know beforehand that in the ith class, there are totali total students, but only passi number of students will pass the exam.

// You are also given an integer extraStudents. There are another extraStudents brilliant students that are guaranteed to pass the exam of any class they are assigned to. You want to assign each of the extraStudents students to a class in a way that maximizes the average pass ratio across all the classes.

// The pass ratio of a class is equal to the number of students of the class that will pass the exam divided by the total number of students of the class. The average pass ratio is the sum of pass ratios of all the classes divided by the number of the classes.

// Return the maximum possible average pass ratio after assigning the extraStudents students. Answers within 10-5 of the actual answer will be accepted.

// Input: classes = [[1,2],[3,5],[2,2]], extraStudents = 2
// Output: 0.78333
// Explanation: You can assign the two extra students to the first class. The average pass ratio will be equal to (3/4 + 3/5 + 2/2) / 3 = 0.78333.

import java.util.PriorityQueue;

public class Sept1__MaximumAveragePassRatio {
    public static double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> {
            double gainA = (a[0] + 1) / (a[1] + 1) - (a[0] / a[1]);
            double gainB = (b[0] + 1) / (b[1] + 1) - (b[0] / b[1]);
            return Double.compare(gainB, gainA);
        });
        for (int[] c : classes) {
            pq.offer(new double[] { c[0], c[1] });
        }
        while (extraStudents > 0) {
            double[] top = pq.poll();
            top[0] += 1;
            top[1] += 1;
            pq.offer(top);
            extraStudents--;
        }
        double sum = 0;
        int total = classes.length;
        while (!pq.isEmpty()) {
            double[] top = pq.poll();
            sum += top[0] / top[1];
        }
        return sum / total;
    }

    public static void main(String[] args) {
        int[][] classes = { { 1, 2 }, { 3, 5 }, { 2, 2 } };
        int extraStudents = 2;
        System.out.println(maxAverageRatio(classes, extraStudents));
        // 0.78333
    }
}
