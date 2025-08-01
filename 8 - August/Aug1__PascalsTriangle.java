// Pascal's Triangle - https://leetcode.com/problems/pascals-triangle/?envType=daily-question&envId=2025-08-01

// Given an integer numRows, return the first numRows of Pascal's triangle.

// In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

// Input: numRows = 5
// Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]

import java.util.ArrayList;
import java.util.List;

public class Aug1__PascalsTriangle {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 1; i <= numRows; i++)
            ans.add(generateRow(i));
        return ans;
    }

    private static List<Integer> generateRow(int row) {
        List<Integer> list = new ArrayList<>();
        int num = 1;
        list.add(num);
        for (int i = 1; i < row; i++) {
            num *= (row - i);
            num /= i;
            list.add(num);
        }
        return list;
    }

    public static void main(String[] args) {
        int numRows = 5;
        System.out.println(generate(numRows));
        // [[1], [1, 1], [1, 2, 1], [1, 3, 3, 1], [1, 4, 6, 4, 1]]
    }
}
