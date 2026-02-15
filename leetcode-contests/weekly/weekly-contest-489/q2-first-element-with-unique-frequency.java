class Solution {
    public int firstUniqueFreq(int[] nums) {
        if(nums == null || nums.length == 0){
            return -1;
        }

        Map<Integer,Integer> numCounts = new HashMap<>();
        for(int num: nums){
            int count = numCounts.getOrDefault(num, 0);
            numCounts.put(num, count + 1);
        }

        Map<Integer, Integer> freqCounts = new HashMap<>();
        for(int freq: numCounts.values()){
            int count = freqCounts.getOrDefault(freq, 0);
            freqCounts.put(freq, count + 1);
        }

        for(int n: nums){
            int f = numCounts.get(n);

            if(freqCounts.get(f) == 1){
                return n;
            }
        }

        return -1;
    }
}