// Finding 3-Digit Even Numbers - https://leetcode.com/problems/finding-3-digit-even-numbers/description/?envType=daily-question&envId=2025-05-12

// You are given an integer array digits, where each element is a digit. The array may contain duplicates.

// You need to find all the unique integers that follow the given requirements:
// - The integer consists of the concatenation of three elements from digits in any arbitrary order.
// - The integer does not have leading zeros.
// - The integer is even.

// For example, if the given digits were [1, 2, 3], integers 132 and 312 follow the requirements.

// Return a sorted array of the unique integers.

// Input: digits = [2,1,3,0]
// Output: [102,120,130,132,210,230,302,310,312,320]
// Explanation: All the possible integers that follow the requirements are in the output array. 
// Notice that there are no odd integers or integers with leading zeros.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class May12__FindingThreeDigitEvenNumbers {
    public static int[] findEvenNumbers(int[] digits) {
        List<Integer> list = new ArrayList<>();
        int[] freq = new int[10];
        for (int d : digits)
            freq[d]++;
        for (int i = 1; i <= 9; i++) {
            if (freq[i] == 0)
                continue;
            freq[i]--;
            for (int j = 0; j <= 9; j++) {
                if (freq[j] == 0)
                    continue;
                freq[j]--;
                for (int k = 0; k <= 9; k += 2) {
                    if (freq[k] == 0)
                        continue;
                    int num = 100 * i + 10 * j + k;
                    list.add(num);
                }
                freq[j]++;
            }
            freq[i]++;
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] digits = { 2, 1, 3, 0 };
        System.out.println(Arrays.toString(findEvenNumbers(digits)));
        // [102,120,130,132,210,230,302,310,312,320]
    }
}
