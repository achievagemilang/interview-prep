package leetcode.dp;

class Solution {
    public int minDeletionSize(String[] strs) {
        int numRows = strs.length;
        int numCols = strs[0].length();
        
        // dp[i] represents the max number of columns we can KEEP 
        // ending exactly at column index i.
        int[] dp = new int[numCols];
        
        // This tracks the global maximum length of a valid subsequence found so far.
        int maxKept = 1; 

        for (int i = 0; i < numCols; i++) {
            dp[i] = 1; // Worst case: the subsequence is just the column i itself.
            
            // Look back at previous columns j
            for (int j = 0; j < i; j++) {
                
                // Check if column i is compatible with column j for ALL rows
                boolean allRowsSorted = true;
                for (int row = 0; row < numRows; row++) {
                    // Strict requirement: char at j must be <= char at i
                    if (strs[row].charAt(j) > strs[row].charAt(i)) {
                        allRowsSorted = false;
                        break;
                    }
                }
                
                // If compatible, we can potentially extend the subsequence ending at j
                if (allRowsSorted) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            
            // Update global maximum
            maxKept = Math.max(maxKept, dp[i]);
        }
        
        // The answer is total columns minus the ones we kept
        return numCols - maxKept;
    }
}