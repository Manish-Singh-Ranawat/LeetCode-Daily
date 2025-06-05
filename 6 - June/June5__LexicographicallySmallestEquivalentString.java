// Lexicographically Smallest Equivalent String - https://leetcode.com/problems/lexicographically-smallest-equivalent-string/description/?envType=daily-question&envId=2025-06-05

// You are given two strings of the same length s1 and s2 and a string baseStr.

// We say s1[i] and s2[i] are equivalent characters.
// - For example, if s1 = "abc" and s2 = "cde", then we have 'a' == 'c', 'b' == 'd', and 'c' == 'e'.

// Equivalent characters follow the usual rules of any equivalence relation:
// - Reflexivity: 'a' == 'a'.
// - Symmetry: 'a' == 'b' implies 'b' == 'a'.
// - Transitivity: 'a' == 'b' and 'b' == 'c' implies 'a' == 'c'.

// For example, given the equivalency information from s1 = "abc" and s2 = "cde", "acd" and "aab" are equivalent strings of baseStr = "eed", and "aab" is the lexicographically smallest equivalent string of baseStr.

// Return the lexicographically smallest equivalent string of baseStr by using the equivalency information from s1 and s2.

// Input: s1 = "parker", s2 = "morris", baseStr = "parser"
// Output: "makkek"
// Explanation: Based on the equivalency information in s1 and s2, we can group their characters as [m,p], [a,o], [k,r,s], [e,i].
// The characters in each group are equivalent and sorted in lexicographical order.
// So the answer is "makkek".

public class June5__LexicographicallySmallestEquivalentString {
    public static String smallestEquivalentString(String s1, String s2, String baseStr) {
        int n = s1.length();
        DisjointSet ds = new DisjointSet(26);
        for (int i = 0; i < n; i++) {
            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(i);
            ds.union((int) (ch1 - 'a'), (int) (ch2 - 'a'));
        }
        StringBuilder ans = new StringBuilder();
        for (char ch : baseStr.toCharArray()) {
            int p = ds.findParent((int) (ch - 'a'));
            ans.append((char) ('a' + p));
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        String s1 = "parker";
        String s2 = "morris";
        String baseStr = "parser";
        System.out.println(smallestEquivalentString(s1, s2, baseStr));
        // "makkek"
    }
}

class DisjointSet {
    int[] parent;

    DisjointSet(int n) {
        this.parent = new int[n + 1];
        for (int i = 0; i <= n; i++)
            parent[i] = i;
    }

    public int findParent(int x) {
        if (parent[x] == x)
            return x;
        return parent[x] = findParent(parent[x]);
    }

    public void union(int x, int y) {
        int px = findParent(x);
        int py = findParent(y);
        if (px == py)
            return;
        if (px < py) {
            parent[py] = px;
        } else {
            parent[px] = py;
        }
    }
}
