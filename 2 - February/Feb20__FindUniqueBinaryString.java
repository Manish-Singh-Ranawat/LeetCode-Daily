// Find Unique Binary String - https://leetcode.com/problems/find-unique-binary-string/description/?envType=daily-question&envId=2025-02-20

// Given an array of strings nums containing n unique binary strings each of length n, return a binary string of length n that does not appear in nums. If there are multiple answers, you may return any of them.

// Input: nums = ["01","10"]
// Output: "11"
// Explanation: "11" does not appear in nums. "00" would also be correct.

public class Feb20__FindUniqueBinaryString {
    public static String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char c = nums[i].charAt(i);
            ans.append(c == '0' ? '1' : '0');
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        String[] nums = { "01", "10" };
        System.out.println(findDifferentBinaryString(nums));
        // 11
    }
}
