// Coupon Code Validator - https://leetcode.com/problems/coupon-code-validator/description/?envType=daily-question&envId=2025-12-13

// You are given three arrays of length n that describe the properties of n coupons: code, businessLine, and isActive. The ith coupon has:
// - code[i]: a string representing the coupon identifier.
// - businessLine[i]: a string denoting the business category of the coupon.
// - isActive[i]: a boolean indicating whether the coupon is currently active.

// A coupon is considered valid if all of the following conditions hold:
// 1 - code[i] is non-empty and consists only of alphanumeric characters (a-z, A-Z, 0-9) and underscores (_).
// 2 - businessLine[i] is one of the following four categories: "electronics", "grocery", "pharmacy", "restaurant".
// 3 - isActive[i] is true.

// Return an array of the codes of all valid coupons, sorted first by their businessLine in the order: "electronics", "grocery", "pharmacy", "restaurant", and then by code in lexicographical (ascending) order within each category.

// Input: code = ["SAVE20","","PHARMA5","SAVE@20"], businessLine = ["restaurant","grocery","pharmacy","restaurant"], isActive = [true,true,true,true]
// Output: ["PHARMA5","SAVE20"]
// Explanation:
// First coupon is valid.
// Second coupon has empty code (invalid).
// Third coupon is valid.
// Fourth coupon has special character @ (invalid).

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Dec13__CouponCodeValidator {
    public static List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        List<String> e = new ArrayList<>();
        List<String> g = new ArrayList<>();
        List<String> p = new ArrayList<>();
        List<String> r = new ArrayList<>();
        int n = code.length;
        for (int i = 0; i < n; i++) {
            if (!isActive[i] || code[i].length() == 0)
                continue;
            boolean flag = true;
            for (char c : code[i].toCharArray()) {
                if (c != '_' && !Character.isLetterOrDigit(c)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                if ("electronics".equals(businessLine[i]))
                    e.add(code[i]);
                else if ("grocery".equals(businessLine[i]))
                    g.add(code[i]);
                else if ("pharmacy".equals(businessLine[i]))
                    p.add(code[i]);
                else if ("restaurant".equals(businessLine[i]))
                    r.add(code[i]);
            }
        }
        Collections.sort(e);
        Collections.sort(g);
        Collections.sort(p);
        Collections.sort(r);
        List<String> mergedList = new ArrayList<>();
        mergedList.addAll(e);
        mergedList.addAll(g);
        mergedList.addAll(p);
        mergedList.addAll(r);
        return mergedList;
    }

    public static void main(String[] args) {
        String[] code = { "SAVE20", "", "PHARMA5", "SAVE@20" };
        String[] businessLine = { "restaurant", "grocery", "pharmacy", "restaurant" };
        boolean[] isActive = { true, true, true, true };
        System.out.println(validateCoupons(code, businessLine, isActive));
        // [PHARMA5, SAVE20]
    }
}
