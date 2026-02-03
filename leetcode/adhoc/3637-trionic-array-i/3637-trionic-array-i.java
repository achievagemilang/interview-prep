class Solution {
    public boolean isTrionic(int[] nums) {
        int n = nums.length;
        if (n < 4) return false;

        int i = 0;
        while (i + 1 < n && nums[i] < nums[i + 1]) {
            i++;
        }
        if (i == 0) return false; 

        int endOfPhase1 = i;
        while (i + 1 < n && nums[i] > nums[i + 1]) {
            i++;
        }
        if (i == endOfPhase1) return false;

        int endOfPhase2 = i;
        while (i + 1 < n && nums[i] < nums[i + 1]) {
            i++;
        }
        if (i == endOfPhase2) return false; 

        return i == n - 1;
    }
}