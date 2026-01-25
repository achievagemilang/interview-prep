class Solution {
    public int minimumDifference(int[] nums, int k) {
        if (k <= 1) return 0;

        Arrays.sort(nums);

        int highestDiff = Integer.MAX_VALUE;

        for(int i = 0; i < nums.length - k + 1; i++){
            int h = nums[i+k-1];
            int l = nums[i];

            int diff = h - l;
            highestDiff = Math.min(diff, highestDiff); 
        }

        return highestDiff;
    }
}