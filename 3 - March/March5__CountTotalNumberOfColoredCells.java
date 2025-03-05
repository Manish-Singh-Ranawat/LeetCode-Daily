// Count Total Number of Colored Cells - https://leetcode.com/problems/count-total-number-of-colored-cells/description/?envType=daily-question&envId=2025-03-05

// There exists an infinitely large two-dimensional grid of uncolored unit cells. You are given a positive integer n, indicating that you must do the following routine for n minutes:

// At the first minute, color any arbitrary unit cell blue.
// Every minute thereafter, color blue every uncolored cell that touches a blue cell.

// Return the number of colored cells at the end of n minutes.

// Input: n = 2
// Output: 5
// Explanation: After 2 minutes, there are 4 colored cells on the boundary and 1 in the center, so we return 5. 



public class March5__CountTotalNumberOfColoredCells {
    public static long coloredCells(int n) {
        return 1 + 2L * n * (n - 1);
    }

    public static void main(String[] args) {
        int n = 2;
        System.out.println(coloredCells(n));
        // 5
    }
}
