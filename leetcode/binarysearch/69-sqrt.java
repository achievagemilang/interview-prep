package leetcode.binarysearch;

class Solution {
    public int mySqrt(int x) {
        if (x == 0) return 0;
        
        int l = 1;
        int r = x; 
        
        while (l <= r) {
            int m = l + (r - l) / 2;
            long sqrVal = (long) m * m;

            if (sqrVal == x) {
                return m;
            } else if (sqrVal < x) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        
        return r;
    }
}

/*
Idea is to search for the square root using binary search.
Search values from 1 to x.

T(n) = O(log n)
S(n) = O(1)
*/