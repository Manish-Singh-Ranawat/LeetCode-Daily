// Number of People Aware of a Secret - https://leetcode.com/problems/number-of-people-aware-of-a-secret/description/?envType=daily-question&envId=2025-09-09

// On day 1, one person discovers a secret.

// You are given an integer delay, which means that each person will share the secret with a new person every day, starting from delay days after discovering the secret. You are also given an integer forget, which means that each person will forget the secret forget days after discovering it. A person cannot share the secret on the same day they forgot it, or on any day afterwards.

// Given an integer n, return the number of people who know the secret at the end of day n. Since the answer may be very large, return it modulo 109 + 7.

// Input: n = 6, delay = 2, forget = 4
// Output: 5
// Explanation:
// Day 1: Suppose the first person is named A. (1 person)
// Day 2: A is the only person who knows the secret. (1 person)
// Day 3: A shares the secret with a new person, B. (2 people)
// Day 4: A shares the secret with a new person, C. (3 people)
// Day 5: A forgets the secret, and B shares the secret with a new person, D. (3 people)
// Day 6: B shares the secret with E, and C shares the secret with F. (5 people)


public class Sept9__NumberOfPeopleAwareOfSecret {
    public static int peopleAwareOfSecret(int n, int delay, int forget) {
        int[] dp = new int[n + 1];
        int mod = (int) (1e9 + 7);
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = Math.max(0, i - forget + 1); j <= i - delay; j++) {
                dp[i] = (dp[i] + dp[j]) % mod;
            }
        }
        int ans = 0;
        for (int i = n - forget + 1; i <= n; i++) {
            ans = (ans + dp[i]) % mod;
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 6;
        int delay = 2;
        int forget = 4;
        System.out.println(peopleAwareOfSecret(n, delay, forget));
        // 5
    }
}
