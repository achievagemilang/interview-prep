class Solution {
    public int findMaxVal(int n, int[][] restrictions, int[] diff) {
        int[] limit = new int[n];
        Arrays.fill(limit, Integer.MAX_VALUE);
        
        limit[0] = 0;

        for (int[] res : restrictions) {
            int idx = res[0];
            int maxVal = res[1];
            limit[idx] = Math.min(limit[idx], maxVal);
        }

        for (int i = 0; i < n - 1; i++) {
            limit[i + 1] = Math.min(limit[i + 1], limit[i] + diff[i]);
        }

        for (int i = n - 2; i >= 0; i--) {
            limit[i] = Math.min(limit[i], limit[i + 1] + diff[i]);
        }

        int maxVal = 0;
        for (int val : limit) {
            maxVal = Math.max(maxVal, val);
        }

        return maxVal;
    }
}