class Solution {
    public int maximumAND(int[] nums, int k, int m) {
        int ans = 0;

        for(int bit=31; bit >= 0; bit--){
            long proposal = ans | (1L << bit);

            if(canAchieve(nums, k, m, proposal)){
                ans = (int) proposal;
            }
        }
        
        return ans;
    }

    private boolean canAchieve(int[] nums, int k, int m, long target){
        long[] costs = new long[nums.length];

        for(int i=0; i<nums.length; i++){
            long x = nums[i];

            if((x & target) == target){
                costs[i] = 0;
                } else {
                long missingBits = target & ~x;
                long msb = Long.highestOneBit(missingBits);

                long nextVal = (x & ~(msb - 1)) + msb;
                long finalVal = nextVal | target;
                costs[i] = finalVal - x;
                
            }
        }
        
        Arrays.sort(costs);
        long totalCost = 0;
        for(int i=0; i<m; i++){
            totalCost += costs[i];
        }
        return totalCost <= k;
    }
}