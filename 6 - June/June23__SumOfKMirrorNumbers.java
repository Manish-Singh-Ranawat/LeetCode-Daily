// Sum of k-Mirror Numbers - https://leetcode.com/problems/sum-of-k-mirror-numbers/description/?envType=daily-question&envId=2025-06-23

// A k-mirror number is a positive integer without leading zeros that reads the same both forward and backward in base-10 as well as in base-k.
// - For example, 9 is a 2-mirror number. The representation of 9 in base-10 and base-2 are 9 and 1001 respectively, which read the same both forward and backward.
// - On the contrary, 4 is not a 2-mirror number. The representation of 4 in base-2 is 100, which does not read the same both forward and backward.

// Given the base k and the number n, return the sum of the n smallest k-mirror numbers.

// Input: k = 2, n = 5
// Output: 25
// Explanation:
// The 5 smallest 2-mirror numbers and their representations in base-2 are listed as follows:
//   base-10    base-2
//     1          1
//     3          11
//     5          101
//     7          111
//     9          1001
// Their sum = 1 + 3 + 5 + 7 + 9 = 25. 

public class June23__SumOfKMirrorNumbers {
    private static int[] digit = new int[100];

    public static long kMirror(int k, int n) {
        int left = 1, count = 0;
        long ans = 0;
        while (count < n) {
            int right = left * 10;
            for (int op = 0; op < 2; ++op) {
                for (int i = left; i < right && count < n; ++i) {
                    long combined = i;
                    int x = (op == 0 ? i / 10 : i);
                    while (x > 0) {
                        combined = combined * 10 + (x % 10);
                        x /= 10;
                    }
                    if (isPalindrome(combined, k)) {
                        ++count;
                        ans += combined;
                    }
                }
            }
            left = right;
        }
        return ans;
    }

    private static boolean isPalindrome(long x, int k) {
        int length = -1;
        while (x > 0) {
            ++length;
            digit[length] = (int) (x % k);
            x /= k;
        }
        for (int i = 0, j = length; i < j; ++i, --j) {
            if (digit[i] != digit[j]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int k = 2;
        int n = 5;
        System.out.println(kMirror(k, n));
        // 25
    }
}
