// Max Difference You Can Get From Changing an Integer - https://leetcode.com/problems/max-difference-you-can-get-from-changing-an-integer/description/?envType=daily-question&envId=2025-06-15

// You are given an integer num. You will apply the following steps to num two separate times:
// - Pick a digit x (0 <= x <= 9).
// - Pick another digit y (0 <= y <= 9). Note y can be equal to x.
// - Replace all the occurrences of x in the decimal representation of num by y.

// Let a and b be the two results from applying the operation to num independently.

// Return the max difference between a and b.

// Note that neither a nor b may have any leading zeros, and must not be 0.

// Input: num = 555
// Output: 888
// Explanation: The first time pick x = 5 and y = 9 and store the new integer in a.
// The second time pick x = 5 and y = 1 and store the new integer in b.
// We have now a = 999 and b = 111 and max difference = 888

public class June15__MaxDifferenceYouCanGetFromChangingAnInteger {
    public static int maxDiff(int num) {
        String max = Integer.toString(num);
        String min = Integer.toString(num);
        int n = max.length();
        for (int i = 0; i < n; i++) {
            char digit = max.charAt(i);
            if (digit != '9') {
                max = max.replace(digit, '9');
                break;
            }
        }
        for (int i = 0; i < n; i++) {
            char digit = min.charAt(i);
            if (i == 0) {
                if (digit != '1') {
                    min = min.replace(digit, '1');
                    break;
                }
            } else {
                if (digit != '0' && digit != min.charAt(0)) {
                    min = min.replace(digit, '0');
                    break;
                }
            }
        }
        return Integer.parseInt(max) - Integer.parseInt(min);
    }

    public static void main(String[] args) {
        int num = 555;
        System.out.println(maxDiff(num));
        // 888
    }
}
