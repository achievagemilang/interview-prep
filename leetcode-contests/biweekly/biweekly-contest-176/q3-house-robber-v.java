class Solution {
    public long rob(int[] nums, int[] colors) {
        if (nums == null || colors == null || nums.length != colors.length){
            return 0;
        }

        if(nums.length == 0){
            return 0;
        }

        long prevMax = nums[0];
        long prevPrevMax = 0;

        for(int i=1; i<nums.length; i++){
            long currentMax;

            if(colors[i] != colors[i - 1]){
                currentMax = prevMax + nums[i];
            } else {
                currentMax = Math.max(prevMax, prevPrevMax + nums[i]);
            }

            prevPrevMax = prevMax;
            prevMax = currentMax;
        }

            
        return prevMax;
    }
}