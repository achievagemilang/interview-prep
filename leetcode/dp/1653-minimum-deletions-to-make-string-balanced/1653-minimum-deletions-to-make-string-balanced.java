class Solution {
    public int minimumDeletions(String s) {
        int bCount = 0;
        int minDeletions = 0;

        for(char c : s.toCharArray()){
            if(c == 'b'){
                bCount++;
            } else {
                minDeletions = Math.min(minDeletions + 1, bCount);
            }
        }


        return minDeletions;
    }
}

/*
Track how many b counts

Then, whenever we present with a during our linear scan, there would be 2 cases:
- a is being kept -> remove previous b(s) -> bCount so far
- a is being discarded -> remove this a -> minDeletions so far + 1

return minDeletions

T(n) -> O(n)
S(n) -> O(1)

*/
