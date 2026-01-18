class Solution {
    public int[] bestTower(int[][] towers, int[] center, int radius) {
        int bestQuality = -1;
        int[] ans = new int[]{-1, -1};

        for(int[] tower: towers){
            int x = tower[0];
            int y = tower[1];
            int q = tower[2];

            int dist = Math.abs(x - center[0]) + Math.abs(y - center[1]);

            if(dist <= radius){
                if(q > bestQuality){
                    bestQuality = q;
                    ans = new int[]{x, y};
                } else if(q == bestQuality){
                    if((x < ans[0]) || (x == ans[0] && y < ans[1])){
                        ans = new int[]{x, y};
                    }
                }
            }
            
        }

        return ans;
    }
}