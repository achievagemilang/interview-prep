package leetcode.binarysearch;

class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0){
            int[] ans = {-1, -1};
            return ans;
        }
        int l = 0;
        int r = nums.length - 1;

        int firstPos = -1;
        while(l <= r){
            int m = (l + r) / 2;
            int n = nums[m];

            if(n == target){
                r = m - 1;
                firstPos = m;
            } else if (n > target){
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        
        if(firstPos == -1){
            return new int[]{-1,-1};
        }

        int lastPos = -1;
        l = 0;
        r = nums.length - 1;
        while(l <= r){
            int m = (l + r) / 2;
            int n = nums[m];

            if(n == target){
                l = m + 1;
                lastPos = m;
            } else if (n > target){
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        int[] ans = {firstPos, lastPos};
        return ans;
    }
}


/*
Idea is quite simple.
Deconstruct the problem into these:
- Find the first element
- Find the last element

Then we can use boundaryIndex to store both firstPos and lastPos -> up until the last element where left/right shrink respectively

T(n): O(log (n))
S(n): O(1)

*/