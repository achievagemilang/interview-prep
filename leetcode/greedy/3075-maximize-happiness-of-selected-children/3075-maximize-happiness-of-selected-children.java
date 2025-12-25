import java.util.Arrays;

class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        
        long sum = 0;
        int n = happiness.length;
        
        for (int i = 0; i < k; i++) {
            int currentVal = happiness[n - 1 - i];
            
            if (currentVal - i > 0) {
                sum += (currentVal - i);
            } else {
                break; 
            }
        }
        
        return sum;
    }
}

/*
    Approach is to greedily take the highest happiness value and subtract the decrementing value until k is reached.

    Edge cases:
    - k is larger than happiness length -> handled by constraints
    - all happiness values are negative -> sum will be 0
    
    T(n) = O(n log n) -> Sorting
    S(n) = O(1)
*/