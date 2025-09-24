// Fraction to Recurring Decimal - https://leetcode.com/problems/fraction-to-recurring-decimal/description/?envType=daily-question&envId=2025-09-24

// Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

// If the fractional part is repeating, enclose the repeating part in parentheses.

// If multiple answers are possible, return any of them.

// It is guaranteed that the length of the answer string is less than 104 for all the given inputs.

// Input: numerator = 4, denominator = 333
// Output: "0.(012)"

import java.util.HashMap;

public class Sept24__FractionToRecurringDecimal {
    public static String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0)
            return "0";
        StringBuilder sb = new StringBuilder("");
        if (1L * numerator * denominator < 0)
            sb.append("-");
        long n = (long) Math.abs(1L * numerator);
        long d = (long) Math.abs(1L * denominator);
        sb.append(n / d);
        long rem = n % d;
        if (rem == 0)
            return sb.toString();
        sb.append(".");
        HashMap<Long, Integer> map = new HashMap<>();
        while (rem != 0) {
            if (map.containsKey(rem)) {
                sb.insert(map.get(rem), "(");
                sb.append(")");
                break;
            }
            map.put(rem, sb.length());
            rem *= 10;
            sb.append(rem / d);
            rem = rem % d;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int numerator = 4;
        int denominator = 333;
        System.out.println(fractionToDecimal(numerator, denominator));
        // 0.(012)
    }
}
