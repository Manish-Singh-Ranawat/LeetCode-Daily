//  Count Mentions Per User - https://leetcode.com/problems/count-mentions-per-user/description/?envType=daily-question&envId=2025-12-12

// You are given an integer numberOfUsers representing the total number of users and an array events of size n x 3.

// Each events[i] can be either of the following two types:

// 1 - Message Event: ["MESSAGE", "timestampi", "mentions_stringi"]
// - This event indicates that a set of users was mentioned in a message at timestampi.
// - The mentions_stringi string can contain one of the following tokens:
//  -- id<number>: where <number> is an integer in range [0,numberOfUsers - 1]. There can be multiple ids separated by a single whitespace and may contain duplicates. This can mention even the offline users.
//  -- ALL: mentions all users.
//  -- HERE: mentions all online users.

// 2 - Offline Event: ["OFFLINE", "timestampi", "idi"]
// - This event indicates that the user idi had become offline at timestampi for 60 time units. The user will automatically be online again at time timestampi + 60.

// Return an array mentions where mentions[i] represents the number of mentions the user with id i has across all MESSAGE events.

// All users are initially online, and if a user goes offline or comes back online, their status change is processed before handling any message event that occurs at the same timestamp.

// Note that a user can be mentioned multiple times in a single message event, and each mention should be counted separately.

// Input: numberOfUsers = 2, events = [["MESSAGE","10","id1 id0"],["OFFLINE","11","0"],["MESSAGE","71","HERE"]]
// Output: [2,2]
// Explanation:
// Initially, all users are online.
// At timestamp 10, id1 and id0 are mentioned. mentions = [1,1]
// At timestamp 11, id0 goes offline.
// At timestamp 71, id0 comes back online and "HERE" is mentioned. mentions = [2,2]

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Dec12__CountMentionsPerUser {
    public static int[] countMentions(int numberOfUsers, List<List<String>> events) {
        List<List<String>> eventsCopy = new ArrayList<>(events);
        eventsCopy.sort((a, b) -> {
            int timeA = Integer.parseInt(a.get(1));
            int timeB = Integer.parseInt(b.get(1));
            if (timeA != timeB) {
                return Integer.compare(timeA, timeB);
            }
            boolean aIsMessage = a.get(0).equals("MESSAGE");
            boolean bIsMessage = b.get(0).equals("MESSAGE");
            return Boolean.compare(aIsMessage, bIsMessage);
        });
        int[] count = new int[numberOfUsers];
        int[] nextOnlineTime = new int[numberOfUsers];
        for (List<String> event : eventsCopy) {
            int curTime = Integer.parseInt(event.get(1));
            String type = event.get(0);
            if (type.equals("MESSAGE")) {
                String target = event.get(2);
                if (target.equals("ALL")) {
                    for (int i = 0; i < numberOfUsers; i++)
                        count[i]++;
                } else if (target.equals("HERE")) {
                    for (int i = 0; i < numberOfUsers; i++) {
                        if (nextOnlineTime[i] <= curTime)
                            count[i]++;
                    }
                } else {
                    String[] users = target.split(" ");
                    for (String user : users) {
                        int idx = Integer.parseInt(user.substring(2));
                        count[idx]++;
                    }
                }
            } else {
                int idx = Integer.parseInt(event.get(2));
                nextOnlineTime[idx] = curTime + 60;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int numberOfUsers = 2;
        List<List<String>> events = new ArrayList<>(Arrays.asList(List.of("MESSAGE", "10", "id1 id0"),
                List.of("OFFLINE", "11", "0"), List.of("MESSAGE", "71", "HERE")));
        System.out.println(Arrays.toString(countMentions(numberOfUsers, events)));
        // [2,2]
    }
}
