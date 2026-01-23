package leetcode.binarysearch;

class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        int ans = -1;

        while(l <= r){
            int m = (l + r) / 2;
            int n = nums[m];

            if(n <= nums[nums.length - 1]){
                ans = nums[m];
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return ans;
    }
}

/*
Run through code

3 4 5 1 2

iter:

1: 
l = 0, r = 4
m = 2
5 -> 5 >= 2

2:
l = 3
r = 4
m = 3
1 -> 1 <= 2
ans = 1
l = 3
r = 3

3:
l = 3
r = 3
m = 3
1 -> 1 <= 2
ans = 1
l = 3
r = 2

Explanation:
Assume we have this array as example:

3,4,5,1,2
     |
can separate like above into this

3 4 5. | 1 2
Notice that 1 2 is <= 2 and 3 4 5 >= 2

So it has a feasible function  <= arr.get(|arr| - 1)

Minimum means that it should be <= 2 and is the latest index we've seen as minimum as possible which means we need to shrinked the right index

T(n): O(log (n))
S(n): O(1)
*/