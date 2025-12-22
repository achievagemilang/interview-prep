package leetcode.companies.traveloka;

import java.util.Arrays;
import java.util.List;

class Solution{

    public static long minTotalCost(int numItems, List<Integer> itemId, List<Integer> cost) {
        long[] minCosts = new long[numItems];
        
        Arrays.fill(minCosts, Long.MAX_VALUE);
        
        for (int i = 0; i < itemId.size(); i++) {
            int id = itemId.get(i);
            int c = cost.get(i);
            
            if (id >= 0 && id < numItems) {
                if (c < minCosts[id]) {
                    minCosts[id] = c;
                }
            }
        }
        
        long totalCost = 0;
        
        for (long val : minCosts) {
            if (val == Long.MAX_VALUE) {
                return -1; 
            }
            totalCost += val;
        }
        
        return totalCost;
    }
}