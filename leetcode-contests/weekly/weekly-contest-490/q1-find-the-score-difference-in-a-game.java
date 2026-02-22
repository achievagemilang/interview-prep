class Solution {
    public int scoreDifference(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int scoreDifference = 0;
        boolean isPlayerActive = true;

        for(int i=0; i<nums.length; i++){
            if(nums[i] % 2 != 0){
                isPlayerActive = !isPlayerActive;
                
            }

            if(i % 6 == 5){
                isPlayerActive = !isPlayerActive;
            }

            if(isPlayerActive){
                scoreDifference += nums[i];
            } else {
                scoreDifference -= nums[i];
            }
        }
        return scoreDifference;
    }
}©leetcode