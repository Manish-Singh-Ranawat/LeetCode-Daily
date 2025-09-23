// Compare Version Numbers - https://leetcode.com/problems/compare-version-numbers/?envType=daily-question&envId=2025-09-23

// Given two version strings, version1 and version2, compare them. A version string consists of revisions separated by dots '.'. The value of the revision is its integer conversion ignoring leading zeros.

// To compare version strings, compare their revision values in left-to-right order. If one of the version strings has fewer revisions, treat the missing revision values as 0.

// Return the following:
// - If version1 < version2, return -1.
// - If version1 > version2, return 1.
// - Otherwise, return 0.

// Input: version1 = "1.2", version2 = "1.10"
// Output: -1
// Explanation: version1's second revision is "2" and version2's second revision is "10": 2 < 10, so version1 < version2.

public class Sept23__CompareVersionNumbers {
    public static int compareVersion(String version1, String version2) {
        int n = version1.length();
        int m = version2.length();
        int i = 0;
        int j = 0;
        while (i < n || j < m) {
            int num1 = 0;
            while (i < n && version1.charAt(i) != '.') {
                num1 = num1 * 10 + (int) (version1.charAt(i) - '0');
                i++;
            }
            int num2 = 0;
            while (j < m && version2.charAt(j) != '.') {
                num2 = num2 * 10 + (int) (version2.charAt(j) - '0');
                j++;
            }
            if (num1 < num2)
                return -1;
            if (num1 > num2)
                return 1;
            i++;
            j++;
        }
        return 0;
    }

    public static void main(String[] args) {
        String version1 = "1.2";
        String version2 = "1.10";
        System.out.println(compareVersion(version1, version2));
        // -1
    }
}
