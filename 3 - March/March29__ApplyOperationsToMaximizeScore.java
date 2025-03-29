// Apply Operations to Maximize Score - https://leetcode.com/problems/apply-operations-to-maximize-score/description/?envType=daily-question&envId=2025-03-29

// You are given an array nums of n positive integers and an integer k.

// Initially, you start with a score of 1. You have to maximize your score by applying the following operation at most k times:
// - Choose any non-empty subarray nums[l, ..., r] that you haven't chosen previously.
// - Choose an element x of nums[l, ..., r] with the highest prime score. If multiple such elements exist, choose the one with the smallest index.
// - Multiply your score by x.

// Here, nums[l, ..., r] denotes the subarray of nums starting at index l and ending at the index r, both ends being inclusive.

// The prime score of an integer x is equal to the number of distinct prime factors of x. For example, the prime score of 300 is 3 since 300 = 2 * 2 * 3 * 5 * 5.

// Return the maximum possible score after applying at most k operations.

// Since the answer may be large, return it modulo 109 + 7.

// Input: nums = [8,3,9,3,8], k = 2
// Output: 81
// Explanation: To get a score of 81, we can apply the following operations:
// - Choose subarray nums[2, ..., 2]. nums[2] is the only element in this subarray. Hence, we multiply the score by nums[2]. The score becomes 1 * 9 = 9.
// - Choose subarray nums[2, ..., 3]. Both nums[2] and nums[3] have a prime score of 1, but nums[2] has the smaller index. Hence, we multiply the score by nums[2]. The score becomes 9 * 9 = 81.
// It can be proven that 81 is the highest score one can obtain.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class March29__ApplyOperationsToMaximizeScore {

    private static final int MOD = 1_000_000_007;

    public static int maximumScore(List<Integer> nums, int k) {
        int n = nums.size();
        int[] primeScores = new int[n];
        int maxElement = Collections.max(nums);
        List<Integer> primes = getPrimes(maxElement);
        for (int index = 0; index < n; index++) {
            int num = nums.get(index);
            for (int prime : primes) {
                if (prime * prime > num)
                    break;
                if (num % prime != 0)
                    continue;
                primeScores[index]++;
                while (num % prime == 0)
                    num /= prime;
            }
            if (num > 1)
                primeScores[index]++;
        }

        int[] nextDominant = new int[n];
        int[] prevDominant = new int[n];
        Arrays.fill(nextDominant, n);
        Arrays.fill(prevDominant, -1);
        Stack<Integer> decreasingPrimeScoreStack = new Stack<>();
        for (int index = 0; index < n; index++) {
            while (!decreasingPrimeScoreStack.isEmpty() &&
                    primeScores[decreasingPrimeScoreStack.peek()] < primeScores[index]) {
                int topIndex = decreasingPrimeScoreStack.pop();
                nextDominant[topIndex] = index;
            }
            if (!decreasingPrimeScoreStack.isEmpty()) {
                prevDominant[index] = decreasingPrimeScoreStack.peek();
            }
            decreasingPrimeScoreStack.push(index);
        }

        long[] numOfSubarrays = new long[n];
        for (int index = 0; index < n; index++) {
            numOfSubarrays[index] = (long) (nextDominant[index] - index) *
                    (index - prevDominant[index]);
        }

        List<int[]> sortedArray = new ArrayList<>();
        for (int index = 0; index < n; index++) {
            sortedArray.add(new int[] { nums.get(index), index });
        }
        sortedArray.sort((a, b) -> Integer.compare(b[0], a[0]));

        long score = 1;
        int processingIndex = 0;
        while (k > 0) {
            int[] element = sortedArray.get(processingIndex++);
            int num = element[0];
            int index = element[1];
            long operations = Math.min(k, numOfSubarrays[index]);
            score = (score * power(num, operations)) % MOD;
            k -= operations;
        }

        return (int) score;
    }

    private static long power(long base, long exponent) {
        long res = 1;
        while (exponent > 0) {
            if (exponent % 2 == 1) {
                res = (res * base) % MOD;
            }
            base = (base * base) % MOD;
            exponent /= 2;
        }
        return res;
    }

    private static List<Integer> getPrimes(int limit) {
        boolean[] isPrime = new boolean[limit + 1];
        Arrays.fill(isPrime, true);
        List<Integer> primes = new ArrayList<>();
        for (int number = 2; number <= limit; number++) {
            if (!isPrime[number])
                continue;
            primes.add(number);
            for (long multiple = (long) number * number; multiple <= limit; multiple += number) {
                isPrime[(int) multiple] = false;
            }
        }
        return primes;
    }

    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>(Arrays.asList(8, 3, 9, 3, 8));
        int k = 2;
        System.out.println(maximumScore(nums, k));
        // 81
    }
}
