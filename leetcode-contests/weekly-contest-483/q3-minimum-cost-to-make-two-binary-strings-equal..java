class Solution {
    public long minimumCost(String s, String t, int flipCost, int swapCost, int crossCost) {
        long count01 = 0;
        long count10 = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            
            if (c1 != c2) {
                if (c1 == '0') {
                    count01++;
                } else {
                    count10++;
                }
            }
        }
        
        long totalCost = 0;
        
        long pairs = Math.min(count01, count10);
        long costPerPairDifferent = Math.min((long) swapCost, 2L * flipCost);
        totalCost += pairs * costPerPairDifferent;
        
        long remaining = Math.abs(count01 - count10);
        
        long costPerPairSame = Math.min(2L * flipCost, (long) crossCost + swapCost);
        
        totalCost += (remaining / 2) * costPerPairSame;
        
        if (remaining % 2 == 1) {
            totalCost += flipCost;
        }
        
        return totalCost;
    }
}