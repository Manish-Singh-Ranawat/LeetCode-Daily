// Design Spreadsheet - https://leetcode.com/problems/design-spreadsheet/description/?envType=daily-question&envId=2025-09-19

// A spreadsheet is a grid with 26 columns (labeled from 'A' to 'Z') and a given number of rows. Each cell in the spreadsheet can hold an integer value between 0 and 105.

// Implement the Spreadsheet class:
// - Spreadsheet(int rows) Initializes a spreadsheet with 26 columns (labeled 'A' to 'Z') and the specified number of rows. All cells are initially set to 0.
// - void setCell(String cell, int value) Sets the value of the specified cell. The cell reference is provided in the format "AX" (e.g., "A1", "B10"), where the letter represents the column (from 'A' to 'Z') and the number represents a 1-indexed row.
// - void resetCell(String cell) Resets the specified cell to 0.
// - int getValue(String formula) Evaluates a formula of the form "=X+Y", where X and Y are either cell references or non-negative integers, and returns the computed sum.

// Note: If getValue references a cell that has not been explicitly set using setCell, its value is considered 0.

// Input:
// ["Spreadsheet", "getValue", "setCell", "getValue", "setCell", "getValue", "resetCell", "getValue"]
// [[3], ["=5+7"], ["A1", 10], ["=A1+6"], ["B2", 15], ["=A1+B2"], ["A1"], ["=A1+B2"]]

// Output:
// [null, 12, null, 16, null, 25, null, 15]

// Explanation:
// Spreadsheet spreadsheet = new Spreadsheet(3); // Initializes a spreadsheet with 3 rows and 26 columns
// spreadsheet.getValue("=5+7"); // returns 12 (5+7)
// spreadsheet.setCell("A1", 10); // sets A1 to 10
// spreadsheet.getValue("=A1+6"); // returns 16 (10+6)
// spreadsheet.setCell("B2", 15); // sets B2 to 15
// spreadsheet.getValue("=A1+B2"); // returns 25 (10+15)
// spreadsheet.resetCell("A1"); // resets A1 to 0
// spreadsheet.getValue("=A1+B2"); // returns 15 (0+15)


class Spreadsheet {

    private int[][] cells;

    public Spreadsheet(int rows) {
        cells = new int[rows+1][26];
    }

    public void setCell(String cell, int value) {
        int col = cell.charAt(0) - 'A';
        int row = Integer.parseInt(cell.substring(1));
        cells[row][col] = value;
    }

    public void resetCell(String cell) {
        this.setCell(cell, 0);
    }

    public int getValue(String formula) {
        int idx = formula.indexOf('+');
        String left = formula.substring(1, idx);
        String right = formula.substring(idx + 1);
        int valLeft = Character.isLetter(left.charAt(0))
                ? cells[Integer.parseInt(left.substring(1))][left.charAt(0) - 'A']
                : Integer.parseInt(left);
        int valRight = Character.isLetter(right.charAt(0))
                ? cells[Integer.parseInt(right.substring(1))][right.charAt(0) - 'A']
                : Integer.parseInt(right);
        return valLeft + valRight;
    }
}

public class Sept19__DesignSpreadsheet {
    public static void main(String[] args) {
        Spreadsheet spreadsheet = new Spreadsheet(3);
        System.out.println(spreadsheet.getValue("=5+7")); // 12 
        spreadsheet.setCell("A1", 10); 
        System.out.println(spreadsheet.getValue("=A1+6")); // 16
        spreadsheet.setCell("B2", 15); 
        System.out.println(spreadsheet.getValue("=A1+B2")); // 25
        spreadsheet.resetCell("A1"); 
        System.out.println(spreadsheet.getValue("=A1+B2")); // 15
    }
}
