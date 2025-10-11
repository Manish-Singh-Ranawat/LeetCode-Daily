// Maximum Total Damage With Spell Casting - https://leetcode.com/problems/maximum-total-damage-with-spell-casting/?envType=daily-question&envId=2025-10-11

// A magician has various spells.

// You are given an array power, where each element represents the damage of a spell. Multiple spells can have the same damage value.

// It is a known fact that if a magician decides to cast a spell with a damage of power[i], they cannot cast any spell with a damage of power[i] - 2, power[i] - 1, power[i] + 1, or power[i] + 2.

// Each spell can be cast only once.

// Return the maximum possible total damage that a magician can cast.

// Input: power = [1,1,3,4]
// Output: 6
// Explanation: The maximum possible damage of 6 is produced by casting spells 0, 1, 3 with damage 1, 1, 4.

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Oct11__MaximumTotalDamageWithSpellCasting {
    public static long maximumTotalDamage(int[] power) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int damage : power) {
            countMap.put(damage, countMap.getOrDefault(damage, 0) + 1);
        }
        List<Integer> uniqueDamages = new ArrayList<>(countMap.keySet());
        Collections.sort(uniqueDamages);
        int n = uniqueDamages.size();
        long[] dp = new long[n + 1];
        for (int i = 0; i < n; i++) {
            int currentDamage = uniqueDamages.get(i);
            long currentDamageTotal = (long) currentDamage * countMap.get(currentDamage);
            int j = i;
            while (j > 0 && uniqueDamages.get(j - 1) >= currentDamage - 2) {
                j--;
            }
            long skipDamage = dp[i];
            long takeDamage = dp[j] + currentDamageTotal;
            dp[i + 1] = Math.max(skipDamage, takeDamage);
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int[] power = { 1, 1, 3, 4 };
        System.out.println(maximumTotalDamage(power));
        // 6  
    }
}
