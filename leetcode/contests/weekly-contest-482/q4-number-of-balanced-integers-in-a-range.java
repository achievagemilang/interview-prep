class Solution {
    private Long[][][][] memo;
    private char[] S;
    private int OFFSET = 200; 

    public long countBalanced(long low, long high) {
        return solveFor(high) - solveFor(low - 1);
    }

    private long solveFor(long n) {
        if (n <= 0) return 0;
        S = String.valueOf(n).toCharArray();
        int len = S.length;
        
        memo = new Long[len][400][2][2]; 
        
        return dp(0, true, 0, true, true);
    }

    private long dp(int idx, boolean tight, int sum, boolean isStart, boolean isOddPos) {
        if (idx == S.length) {
            return (!isStart && sum == 0) ? 1 : 0;
        }

        if (!tight && memo[idx][sum + OFFSET][isStart ? 1 : 0][isOddPos ? 1 : 0] != null) {
            return memo[idx][sum + OFFSET][isStart ? 1 : 0][isOddPos ? 1 : 0];
        }

        long count = 0;
        int limit = tight ? (S[idx] - '0') : 9;

        for (int digit = 0; digit <= limit; digit++) {
            boolean nextTight = tight && (digit == limit);
            
            if (isStart) {
                if (digit == 0) {
                    count += dp(idx + 1, nextTight, sum, true, true);
                } else {
                    count += dp(idx + 1, nextTight, sum + digit, false, false);
                }
            } else {
                int nextSum = isOddPos ? (sum + digit) : (sum - digit);
                
                count += dp(idx + 1, nextTight, nextSum, false, !isOddPos);
            }
        }

        if (!tight) {
            memo[idx][sum + OFFSET][isStart ? 1 : 0][isOddPos ? 1 : 0] = count;
        }
        
        return count;
    }
}