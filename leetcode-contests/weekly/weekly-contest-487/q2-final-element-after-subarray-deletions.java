class Solution {
    public int finalElement(int[] nums) {
        int n = nums.length;
        return Math.max(nums[0], nums[n - 1]);
    }
}


/*
any duplicates? doens't mention assume there is
but the key here is that Alice and Bob is playing optimal, means:
on odd turn: Alice will take the lowest
on even turn: Bob will take the highest

Can definitely do based on the reqs but resulting in O(n^2) is there any better approach?
Have to figure out solution of O(n log n) at most-> use sorting
alice always take the left
bob always take the right 
can shorten the window using two pointers

T(n) -> O(n log n)
S(n) -> depends on the sorting algo used

ACTUALLY:

This is a Game theory, assuming Alice can play optimal -> she can always win since she can pivot Bob's move
*/©leetcode