package leetcode.dp;

import java.util.Arrays;

class Solution {
    public boolean canJump(int[] nums) {
        int[] memo = new int[nums.length]; 
        Arrays.fill(memo, -1);
        return dfs(0, memo, nums);
    }

    public boolean dfs(int start, int[] memo, int[] nums) {
        if (start >= nums.length - 1) {
            return true;
        }

        if (memo[start] != -1) {
            return memo[start] == 1;
        }

        int maxJump = nums[start];
        
        for (int i = maxJump; i >= 1; i--) {
            if (dfs(start + i, memo, nums)) {
                memo[start] = 1;
                return true;
            }
        }

        memo[start] = 0;
        return false;
    }
}

/*
Idea is to use DP to calculate every possible scenario while not computing overlappig subproblems
We use dfs because we obly need to know if an answer is feasible or not to reach the end index

So, we can greedily use biggest possible jumps to reach our destination faster, then backtrack if somehow we didn't managed to get into our goal.

T(n) = O(M*L) , M is max in nums and L is length of the nums
S(n) = O(N) for memo and dfs recursion
*/