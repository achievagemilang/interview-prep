class Solution {
    public int countMonobit(int n) {
        if (n == 0) return 1;
        if (n == 1) return 2;

        int numberOfOnes = 0;
        int monobit = 1;

        while(monobit <= n){
            numberOfOnes++;
            monobit = (monobit << 1) | 1;
        }
        
        return 1 + numberOfOnes;
    }
}

// All Zeroes -> 0 (00, 000 isn't possible)
// All Ones -> 1, 11, 111, 1111
// means that up to n:
/*
    we should check the most upper bound ones that satisfy the range

    The answer would be 1 (from zero) + 1's 
*/©leetcode