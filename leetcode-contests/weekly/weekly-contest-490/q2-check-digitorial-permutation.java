class Solution {
    public boolean isDigitorialPermutation(int n) {
        if (n <= 0) return false;

        final int[] factMap = {
            1,
            1,
            2,
            6,
            24,
            120,
            720,
            5040,
            40320,
            362880
        };

        int[] originalDigitCounts = new int[10];
        int targetSum = 0;
        int originalLength = 0;
        int tempN = n;

        while(tempN > 0){
            int digit = tempN % 10;
            originalDigitCounts[digit]++;
            targetSum += factMap[digit];
            tempN /= 10;
            originalLength++;
        }

        int[] targetDigitCounts = new int[10];
        int targetLength = 0;
        int tempTarget = targetSum;

        while (tempTarget > 0){
            int digit = tempTarget % 10;
            targetDigitCounts[digit]++;
            tempTarget /= 10;
            targetLength++;
        }

        if(originalLength != targetLength ){
            return false;
        }

        for(int i=0; i<10; i++){
            if(originalDigitCounts[i] != targetDigitCounts[i]){
                return false;
            }
        }

        return true;
    }
}©leetcode