// Three Consecutive Odds - https://leetcode.com/problems/three-consecutive-odds/?envType=daily-question&envId=2025-05-11

// Given an integer array arr, return true if there are three consecutive odd numbers in the array. Otherwise, return false.

// Input: arr = [2,6,4,1]
// Output: false
// Explanation: There are no three consecutive odds.

public class May11__ThreeConsecutiveOdds {
    public static boolean threeConsecutiveOdds(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 2; i++) {
            if (arr[i] % 2 == 1 && arr[i + 1] % 2 == 1 && arr[i + 2] % 2 == 1)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 6, 4, 1 };
        System.out.println(threeConsecutiveOdds(arr));
        // false
    }
}
