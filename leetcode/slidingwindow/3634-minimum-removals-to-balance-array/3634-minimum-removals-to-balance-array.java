class Solution {
    public int minRemoval(int[] nums, int k) {
        Arrays.sort(nums);

        int maxKept = 0;
        int l = 0;

        for(int r = 0; r < nums.length; r++){
            while((long)nums[r] > (long) k * nums[l]){
                l++;
            }
            maxKept = Math.max(maxKept, r - l + 1);
        }

        return nums.length - maxKept;
    }
}

/*
Approach is to scan from left to right, right after we sort the array

Why sort? because we need to maintain the order of checking on this condition
k * min must be >= max
We can iteratively check this and adjust the left window index accordingly

Maintain the window of kept elements, then our answer would be -> N - maxKept, where N is the length of nums

T(n) = O(N log N)
S(n) = depends on sorting algo
*/