// Calculate Money in Leetcode Bank - https://leetcode.com/problems/calculate-money-in-leetcode-bank/?envType=daily-question&envId=2025-10-25

// Hercy wants to save money for his first car. He puts money in the Leetcode bank every day.

// He starts by putting in $1 on Monday, the first day. Every day from Tuesday to Sunday, he will put in $1 more than the day before. On every subsequent Monday, he will put in $1 more than the previous Monday.

// Given n, return the total amount of money he will have in the Leetcode bank at the end of the nth day.

// Input: n = 10
// Output: 37
// Explanation: After the 10th day, the total is (1 + 2 + 3 + 4 + 5 + 6 + 7) + (2 + 3 + 4) = 37. Notice that on the 2nd Monday, Hercy only puts in $2.

public class Oct25__CalculateMoneyInLeetcodeBank {
    public static int totalMoney(int n) {
        int k = n / 7;
        int F = 28;
        int L = 28 + (k - 1) * 7;
        int arithmeticSum = k * (F + L) / 2; 
        int monday = 1 + k;
        int finalWeek = 0;
        for (int day = 0; day < n % 7; day++) 
            finalWeek += monday + day;
        return arithmeticSum + finalWeek;
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println(totalMoney(n));
        // 37  
    }
}
