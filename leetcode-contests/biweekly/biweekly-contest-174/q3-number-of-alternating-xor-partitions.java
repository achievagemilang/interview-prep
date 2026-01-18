class Solution {
    public int alternatingXOR(int[] nums, int target1, int target2) {
        final int MOD = (int) (Math.pow(10, 9) + 7);

        int currentXor = 0;
        long total = 0;

        Map<Integer, Integer> mapT1 = new HashMap<>();
        Map<Integer, Integer> mapT2 = new HashMap<>();

        mapT2.put(0, 1);

        for(int n: nums){
            currentXor ^= n;

            int prevXorT1 = currentXor ^ target1;
            int waysToFormT1 = mapT2.getOrDefault(prevXorT1, 0);
            
            int prevXorT2 = currentXor ^ target2;
            int waysToFormT2 = mapT1.getOrDefault(prevXorT2, 0);

            int existingT1 = mapT1.getOrDefault(currentXor, 0);
            mapT1.put(currentXor, (existingT1 + waysToFormT1) % MOD);
            
            int existingT2 = mapT2.getOrDefault(currentXor, 0);
            mapT2.put(currentXor, (existingT2 + waysToFormT2) % MOD);
            
            total = ( waysToFormT1 + waysToFormT2 ) % MOD;
        }
        
        return (int) total;
    }
}©leetcode