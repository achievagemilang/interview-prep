class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> mp = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            int n = target - nums[i];
            if(mp.containsKey(n)){
                return new int[]{mp.get(n), i};
            }
            mp.putIfAbsent(nums[i], i);
        }

        return new int[]{0,0};
    }
}