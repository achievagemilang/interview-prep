class Solution {
    public int minOperations(int[] nums, int[] target) {
        Set<Integer> toFix = new HashSet<>();

        for(int i=0; i<nums.length; i++){
            if(nums[i] != target[i]){
                toFix.add(nums[i]);
            }
        }

        return toFix.size();
    }
}