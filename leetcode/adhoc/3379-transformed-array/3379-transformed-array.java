class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int[] res = new int[nums.length];

        for(int i=0; i<nums.length; i++){
            int steps = nums[i];
            int pos = i + steps;

            pos = pos % nums.length;

            if(pos < 0){
                pos += nums.length;
            }

            res[i] = nums[pos];
        }

        return res;
    }
}

/*
It seems like a simple simulation problem where we can loop linearly from left to right and simulate based on steps mentioned, if nums[i]:
- if positive -> go to right, if overflow, start again from left
- if negative -> go to left, if overflow, start again from right
- if zero -> use nums[i]

Whatever delta nums[i] that we get after simulating will be assigned into corresponding nums[i]

T(n) = O(n)
S(n) = S(1) -> ignoring the new array as it is a must
*/