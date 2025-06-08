// Lexicographical Numbers - https://leetcode.com/problems/lexicographical-numbers/description/?envType=daily-question&envId=2025-06-08

// Given an integer n, return all the numbers in the range [1, n] sorted in lexicographical order.

// You must write an algorithm that runs in O(n) time and uses O(1) extra space. 

// Input: n = 13
// Output: [1,10,11,12,13,2,3,4,5,6,7,8,9]

import java.util.ArrayList;
import java.util.List;

public class June8__LexicographicalNumbers {
    public static List<Integer> lexicalOrder(int n) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i <= 9; i++)
            dfs(n, i, ans);
        return ans;
    }

    public static void dfs(int n, int cur, List<Integer> ans) {
        if (cur > n)
            return;
        ans.add(cur);
        for (int i = 0; i <= 9; i++) {
            int next = cur * 10 + i;
            if (next > n)
                break;
            dfs(n, next, ans);
        }
    }

    public static void main(String[] args) {
        int n = 13;
        System.out.println(lexicalOrder(n));
        // [1,10,11,12,13,2,3,4,5,6,7,8,9]
    }
}
