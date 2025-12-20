package leetcode.dp;

import java.util.Arrays;

class Solution {
    public int climbStairs(int n) {
        int[] memo = new int[50];
        Arrays.fill(memo, -1);

        return climbStairs(n, memo);
    }

    public int climbStairs(int n, int[] memo){
        if(n == 0) return 1;
        if(n < 0) return 0;
        if(memo[n] != -1) return memo[n];

        memo[n] = climbStairs(n - 1, memo) + climbStairs(n - 2, memo);
        return memo[n];
    }
}
/*
    basic DP
    T(n): O(n) -> each state is calculated once
    S(n): O(n)
*/