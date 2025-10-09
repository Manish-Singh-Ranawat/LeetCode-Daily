// Find the Minimum Amount of Time to Brew Potions - https://leetcode.com/problems/find-the-minimum-amount-of-time-to-brew-potions/description/?envType=daily-question&envId=2025-10-09

// You are given two integer arrays, skill and mana, of length n and m, respectively.

// In a laboratory, n wizards must brew m potions in order. Each potion has a mana capacity mana[j] and must pass through all the wizards sequentially to be brewed properly. The time taken by the ith wizard on the jth potion is timeij = skill[i] * mana[j].

// Since the brewing process is delicate, a potion must be passed to the next wizard immediately after the current wizard completes their work. This means the timing must be synchronized so that each wizard begins working on a potion exactly when it arrives. ​

// Return the minimum amount of time required for the potions to be brewed properly.

// Input: skill = [1,5,2,4], mana = [5,1,4,2]
// Output: 110
// Explanation:
// Potion Number	Start time	 Wizard 0 done by	Wizard 1 done by	Wizard 2 done by	Wizard 3 done by
//       0	            0	           5	               30	               40	              60
//       1	            52	           53	               58	               60	              64
//       2	            54	           58	               78	               86	              102
//       3	            86	           88	               98	               102	              110
// As an example for why wizard 0 cannot start working on the 1st potion before time t = 52, consider the case where the wizards started preparing the 1st potion at time t = 50. At time t = 58, wizard 2 is done with the 1st potion, but wizard 3 will still be working on the 0th potion till time t = 60.

public class Oct9__FindTheMinimumAmountOfTimeToBrewPotions {
    public static long minTime(int[] skill, int[] mana) {
        int n = skill.length;
        int m = mana.length;
        long[] times = new long[n];
        for (int j = 0; j < m; j++) {
            long curTime = 0;
            for (int i = 0; i < n; i++) {
                curTime = Math.max(curTime, times[i]) + (long) skill[i] * mana[j];
            }
            times[n - 1] = curTime;
            for (int i = n - 2; i >= 0; i--) {
                times[i] = times[i + 1] - (long) skill[i + 1] * mana[j];
            }
        }
        return times[n - 1];
    }

    public static void main(String[] args) {
        int[] skill = { 1, 5, 2, 4 };
        int[] mana = { 5, 1, 4, 2 };
        System.out.println(minTime(skill, mana));
        // 110
    }
}
