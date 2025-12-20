// Delete Columns to Make Sorted - https://leetcode.com/problems/delete-columns-to-make-sorted/description/?envType=daily-question&envId=2025-12-20

// You are given an array of n strings strs, all of the same length.

// The strings can be arranged such that there is one on each line, making a grid.
// For example, strs = ["abc", "bce", "cae"] can be arranged as follows:
// abc
// bce
// cae

// You want to delete the columns that are not sorted lexicographically. In the above example (0-indexed), columns 0 ('a', 'b', 'c') and 2 ('c', 'e', 'e') are sorted, while column 1 ('b', 'c', 'a') is not, so you would delete column 1.

// Return the number of columns that you will delete.

// Input: strs = ["cba","daf","ghi"]
// Output: 1
// Explanation: The grid looks as follows:
//   cba
//   daf
//   ghi
// Columns 0 and 2 are sorted, but column 1 is not, so you only need to delete 1 column.

public class Dec20__DeleteColumnsToMakeSorted {
    public static int minDeletionSize(String[] strs) {
        int res = 0;
        for (int j = 0; j < strs[0].length(); j++)
            res += isUnsorted(strs, j);
        return res;
    }

    private static int isUnsorted(String[] strs, int j) {
        for (int i = 1; i < strs.length; i++)
            if (strs[i].charAt(j) < strs[i - 1].charAt(j))
                return 1;
        return 0;
    }

    public static void main(String[] args) {
        String[] strs = { "cba", "daf", "ghi" };
        System.out.println(minDeletionSize(strs));
        // 1
    }
}
