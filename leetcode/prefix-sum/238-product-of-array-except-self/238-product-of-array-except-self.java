
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] postfix = new int[nums.length];
        int[] prefix = new int[nums.length];

        for(int i=0; i<nums.length; i++){
            if(i == 0) prefix[i] = nums[i];
            else prefix[i] = prefix[i-1] * nums[i];
        }

        for(int i=nums.length-1; i >= 0; i--){
            if(i == nums.length-1) postfix[i] = nums[i];
            else postfix[i] = postfix[i+1] * nums[i];
        }

        int[] ans = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            if(i == 0) ans[i] = postfix[i+1];
            else if(i == nums.length-1) ans[i] = prefix[i-1];
            else ans[i] = prefix[i-1] * postfix[i+1];
        }

        return ans;
    }
}