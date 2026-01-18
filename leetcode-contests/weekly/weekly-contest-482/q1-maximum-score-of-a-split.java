
class Solution {
    public long maximumScore(int[] nums) {
        int n = nums.length;
        int[] suffixMin = new int[n];

        suffixMin[n - 1] = nums[n - 1];
        for (int k = n - 2; k >= 0; k--) {
            suffixMin[k] = Math.min(nums[k], suffixMin[k + 1]);
        }

        long maxScore = Long.MIN_VALUE;
        long currentPrefixSum = 0;
        
        for (int i = 0; i < n - 1; i++) {
            currentPrefixSum += nums[i];
            
            int currentSuffixMin = suffixMin[i + 1];
            
            long score = currentPrefixSum - currentSuffixMin;
            maxScore = Math.max(maxScore, score);
        }
        
        return maxScore;
    }
}