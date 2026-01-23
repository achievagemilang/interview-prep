package leetcode.binarysearch;
class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length == 1) return 0;
        int l = 0;
        int r = nums.length - 1;

        while(l <= r){
            int m = (l + r) / 2;
            int n = nums[m];

            if(m - 1 > -1 && m + 1 < nums.length && nums[m - 1] < n && nums[m + 1] < n){
                return m;
            } else if (m - 1 <= -1 && nums[m + 1] < n){
                return m;
            } else if (m + 1 >= nums.length && nums[m - 1] < n){
                return m;
            } else if (nums[m + 1] > n){
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return -1;
    }
}


/*
The approach is binary search as we can divide by 2 in each iteration hence O (log n) can be achieved

How?

We can return any peak element, and we have this nums[i] != nums[i + 1] as our information. Which mean there will not be these scenarios:
1. 
   2 -> M
 1.  1 -> peak is 2 (no problem, instantly return this)

2. 
3.  3
  2  M  -> IS A PROBLEM. we did not know which section to be eliminate, or this problem is same with this:
    4
3
  2. -> M

  Just pick one section to continue as it guarantees a peak (maybe 4 is in on the end, or at least on the left/right is already less than the middle element)

  BUT The problem is actualy like this:
    M
  2 2 2 -> we didn't know how to proceed (luckily, no case realted to this in given question -> nums[i] != nums[i + 1]) 


T(n) = O(log n)
S(n) = O(1)

 */