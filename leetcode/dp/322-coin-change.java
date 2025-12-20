package leetcode.dp;

import java.util.Arrays;

class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for(int i=1; i<=amount; i++){
            for(int coin: coins){
                if(i >= coin && dp[i - coin] != Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        int ans;
        if(dp[amount] == Integer.MAX_VALUE){
            ans = -1;
        } else {
            ans = dp[amount];
        }
        return ans;

    }
}


/*
Dynamic Programming approach, each DP state is initially max possible value

Only compare and set dp value if the value is valid (have exact coins to change) -> compare by taking minimum value as possible

Brute force all combinations but make it efficient using DP

edge -> amount 0 means we didn't need to exchange coin -> return immediately

T(n) = O(len(coins) * amount)
S(n) = O(n) -> DP

*/