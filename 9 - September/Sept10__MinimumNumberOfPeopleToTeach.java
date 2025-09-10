// Minimum Number of People to Teach - https://leetcode.com/problems/minimum-number-of-people-to-teach/description/?envType=daily-question&envId=2025-09-10

// On a social network consisting of m users and some friendships between users, two users can communicate with each other if they know a common language.

// You are given an integer n, an array languages, and an array friendships where:
// - There are n languages numbered 1 through n,
// - languages[i] is the set of languages the i​​​​​​th​​​​ user knows, and
// - friendships[i] = [u​​​​​​i​​​, v​​​​​​i] denotes a friendship between the users u​​​​​​​​​​​i​​​​​ and vi.

// You can choose one language and teach it to some users so that all friends can communicate with each other. Return the minimum number of users you need to teach.

// Note that friendships are not transitive, meaning if x is a friend of y and y is a friend of z, this doesn't guarantee that x is a friend of z.

// Input: n = 2, languages = [[1],[2],[1,2]], friendships = [[1,2],[1,3],[2,3]]
// Output: 1
// Explanation: You can either teach user 1 the second language or user 2 the first language.

import java.util.HashSet;
import java.util.Set;

public class Sept10__MinimumNumberOfPeopleToTeach {
    public static int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        Set<Integer> usersToTeach = new HashSet<>();
        for (int[] it : friendships) {
            int u = it[0] - 1;
            int v = it[1] - 1;
            Set<Integer> set = new HashSet<>();
            for (int lang : languages[u])
                set.add(lang);
            boolean canCommunicate = false;
            for (int lang : languages[v]) {
                if (set.contains(lang)) {
                    canCommunicate = true;
                    break;
                }
            }
            if (!canCommunicate) {
                usersToTeach.add(u);
                usersToTeach.add(v);
            }
        }
        int[] language = new int[n + 1];
        int maxKnownLanguage = 0;
        for (int it : usersToTeach) {
            for (int lang : languages[it]) {
                language[lang]++;
                maxKnownLanguage = Math.max(maxKnownLanguage, language[lang]);
            }
        }
        return usersToTeach.size() - maxKnownLanguage;
    }

    public static void main(String[] args) {
        int n = 2;
        int[][] languages = { { 1 }, { 2 }, { 1, 2 } };
        int[][] friendships = { { 1, 2 }, { 1, 3 }, { 2, 3 } };
        System.out.println(minimumTeachings(n, languages, friendships));
        // 1
    }
}
