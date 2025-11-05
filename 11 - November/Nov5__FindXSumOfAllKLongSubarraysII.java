// Find X-Sum of All K-Long Subarrays II - https://leetcode.com/problems/find-x-sum-of-all-k-long-subarrays-ii/?envType=daily-question&envId=2025-11-05

// You are given an array nums of n integers and two integers k and x.

// The x-sum of an array is calculated by the following procedure:
// - Count the occurrences of all elements in the array.
// - Keep only the occurrences of the top x most frequent elements. If two elements have the same number of occurrences, the element with the bigger value is considered more frequent.
// - Calculate the sum of the resulting array.

// Note that if an array has less than x distinct elements, its x-sum is the sum of the array.

// Return an integer array answer of length n - k + 1 where answer[i] is the x-sum of the subarray nums[i..i + k - 1].

// Input: nums = [1,1,2,2,3,4,2,3], k = 6, x = 2
// Output: [6,10,12]
// Explanation:
// For subarray [1, 1, 2, 2, 3, 4], only elements 1 and 2 will be kept in the resulting array. Hence, answer[0] = 1 + 1 + 2 + 2.
// For subarray [1, 2, 2, 3, 4, 2], only elements 2 and 4 will be kept in the resulting array. Hence, answer[1] = 2 + 2 + 2 + 4. Note that 4 is kept in the array since it is bigger than 3 and 1 which occur the same number of times.
// For subarray [2, 2, 3, 4, 2, 3], only elements 2 and 3 are kept in the resulting array. Hence, answer[2] = 2 + 2 + 2 + 3 + 3.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeSet;

public class Nov5__FindXSumOfAllKLongSubarraysII {

    public static long[] findXSum(int[] nums, int k, int x) {
        Helper helper = new Helper(x);
        List<Long> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            helper.insert(nums[i]);
            if (i >= k) {
                helper.remove(nums[i - k]);
            }
            if (i >= k - 1) {
                ans.add(helper.get());
            }
        }
        return ans.stream().mapToLong(Long::longValue).toArray();
    }

    public static void main(String[] args) {
        int k = 6;
        int x = 2;
        int[] nums = { 1, 1, 2, 2, 3, 4, 2, 3 };
        System.out.println(Arrays.toString(findXSum(nums, k, x)));
        // [6, 10, 12]
    }
}

class Helper {
    private int x;
    private long result;
    private TreeSet<Pair> large, small;
    private Map<Integer, Integer> occ;

    private static class Pair implements Comparable<Pair> {
        int first;
        int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public int compareTo(Pair other) {
            if (this.first != other.first) {
                return Integer.compare(this.first, other.first);
            }
            return Integer.compare(this.second, other.second);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null || getClass() != obj.getClass())
                return false;
            Pair pair = (Pair) obj;
            return first == pair.first && second == pair.second;
        }

        @Override
        public int hashCode() {
            return Objects.hash(first, second);
        }
    }

    public Helper(int x) {
        this.x = x;
        this.result = 0;
        this.large = new TreeSet<>();
        this.small = new TreeSet<>();
        this.occ = new HashMap<>();
    }

    public void insert(int num) {
        if (occ.containsKey(num) && occ.get(num) > 0) {
            internalRemove(new Pair(occ.get(num), num));
        }
        occ.put(num, occ.getOrDefault(num, 0) + 1);
        internalInsert(new Pair(occ.get(num), num));
    }

    public void remove(int num) {
        internalRemove(new Pair(occ.get(num), num));
        occ.put(num, occ.get(num) - 1);
        if (occ.get(num) > 0) {
            internalInsert(new Pair(occ.get(num), num));
        }
    }

    public long get() {
        return result;
    }

    private void internalInsert(Pair p) {
        if (large.size() < x || p.compareTo(large.first()) > 0) {
            result += (long) p.first * p.second;
            large.add(p);
            if (large.size() > x) {
                Pair toRemove = large.first();
                result -= (long) toRemove.first * toRemove.second;
                large.remove(toRemove);
                small.add(toRemove);
            }
        } else {
            small.add(p);
        }
    }

    private void internalRemove(Pair p) {
        if (p.compareTo(large.first()) >= 0) {
            result -= (long) p.first * p.second;
            large.remove(p);
            if (!small.isEmpty()) {
                Pair toAdd = small.last();
                result += (long) toAdd.first * toAdd.second;
                small.remove(toAdd);
                large.add(toAdd);
            }
        } else {
            small.remove(p);
        }
    }
}
