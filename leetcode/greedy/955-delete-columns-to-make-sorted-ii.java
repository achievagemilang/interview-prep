package leetcode.greedy;

class Solution {
    public int minDeletionSize(String[] strs) {
        int ans = 0;
        int n = strs.length;
        if(n <= 1) return ans;
        
        boolean[] sorted = new boolean[n - 1];

        for(int i=0; i<strs[0].length(); i++){
            boolean deleteCol = false;
            
            // PASS 1: Check if we MUST delete this column
            for(int j=0; j<n-1; j++){
                if(sorted[j]) continue;

                if(strs[j+1].charAt(i) < strs[j].charAt(i)){
                    ans++;
                    deleteCol = true; 
                    break;
                }
            }
            
            // PASS 2: If we didn't delete, update the memory
            if(!deleteCol){
                for(int j=0; j<n-1; j++){
                    // If they were equal before, but now this column makes them strict
                    if(strs[j+1].charAt(i) > strs[j].charAt(i)){
                        sorted[j] = true; 
                    }
                }
            }
        }

        return ans;
    }
}