// Maximum Matching of Players With Trainers - https://leetcode.com/problems/maximum-matching-of-players-with-trainers/?envType=daily-question&envId=2025-07-13

// You are given a 0-indexed integer array players, where players[i] represents the ability of the ith player. You are also given a 0-indexed integer array trainers, where trainers[j] represents the training capacity of the jth trainer.

// The ith player can match with the jth trainer if the player's ability is less than or equal to the trainer's training capacity. Additionally, the ith player can be matched with at most one trainer, and the jth trainer can be matched with at most one player.

// Return the maximum number of matchings between players and trainers that satisfy these conditions.

// Input: players = [4,7,9], trainers = [8,2,5,8]
// Output: 2
// Explanation: One of the ways we can form two matchings is as follows:
// - players[0] can be matched with trainers[0] since 4 <= 8.
// - players[1] can be matched with trainers[3] since 7 <= 8.
// It can be proven that 2 is the maximum number of matchings that can be formed.

import java.util.Arrays;

public class July13__MaximumMatchingOfPlayersWithTrainers {
    public static int matchPlayersAndTrainers(int[] players, int[] trainers) {
        int m = players.length;
        int n = trainers.length;
        Arrays.sort(players);
        Arrays.sort(trainers);
        int i = 0;
        int j = 0;
        while (i < m && j < n) {
            if (players[i] <= trainers[j])
                i++;
            j++;
        }
        return i;
    }

    public static void main(String[] args) {
        int[] players = { 4, 7, 9 };
        int[] trainers = { 8, 2, 5, 8 };
        System.out.println(matchPlayersAndTrainers(players, trainers));
        // 2
    }
}
