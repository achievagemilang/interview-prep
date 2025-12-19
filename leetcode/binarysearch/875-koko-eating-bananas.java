package leetcode.binarysearch;

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxPiles = 0;
        for(int pile: piles){
            maxPiles = Math.max(pile, maxPiles);
        }
        
        int l = 1;
        int r = maxPiles;
        int ans = r;
        while(l <= r){
            int m = l + (r - l) / 2;
            
            if(canFinish(m, h, piles)){
                ans = m;
                r = m - 1;
            } else{
                l = m + 1;
            }
        }

        return ans;
    }

    boolean canFinish(int k, int h, int[]piles){
        long totalHours = 0;
        for(int pile: piles){
            totalHours += (long) Math.ceil((double) pile / k);
        }

        return totalHours <= (long) h;
    }
}

/*
My idea is we will use binary search
The baseline of the logic is because we have to make sure that:
len(piles) <= h
because we need to eat at least len(piles) hours to finish all of banana in the piles

there for our search value will be coming from [1 .. max(piles)]

because by using maximum value from piles we can definitely finish all of the piles in one hour respectively hence it'll be at least h hours at minimum

Therefore the logic become like this:
Get value from [1..max(piles)] -> log n
check if value feasible for <= h condition -> len(piles)
if feasible try to find smaller number,
if not shrinken into the right side to find a bigger number.

T(n) = O(log(n) * n)
S(n) = S(1)
*/

