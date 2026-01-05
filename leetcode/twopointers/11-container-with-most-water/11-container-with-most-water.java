package leetcode.twopointers;

class Solution {
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int ans = -1;
        while(l < r){
            int left = height[l];
            int right = height[r];
            int area = Math.min(left, right) * (r - l);

            ans = Math.max(area, ans);

            if(height[l] <= height[r]){
                l++;
            } else {
                r--;
            }
        }

        return ans;
    }
}


/*
Approach is to use two pointers:
left: 0
right: rightmost of the element
then gradually calculate the area being covered and store the max value we have as possible until l >= r -> while l < r

By doing this we only iterate once and not using extra space
T(n) = O(n)
S(n) = O(1)

*/