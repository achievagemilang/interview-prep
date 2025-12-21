package leetcode.slidingwindow;

class Solution {
    public int maxProfit(int[] prices) {
        int l, r, ans;
        ans = 0;
        l = 0;

        for(r=1; r < prices.length; r++){
            int prev = prices[l];
            int next = prices[r];

            if(next < prev){
                l = r;
                continue;
            }

            int profit = next - prev;
            ans = Math.max(profit, ans);
        }

        return ans;
    }
}