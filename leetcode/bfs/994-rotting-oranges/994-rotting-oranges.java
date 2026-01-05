class Solution {
    class Position{
        int x, y;
        Position(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public int orangesRotting(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        int ans = 0;

        Queue<Position> q = new ArrayDeque<>();
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(grid[i][j] == 2) q.add(new Position(i , j));
            }
        }

        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while(!q.isEmpty()){
            Queue<Position> nextQueue = new ArrayDeque();
            boolean rottedSomething = false;
            while(!q.isEmpty()){
                Position now = q.poll();

                for(int[] dir: dirs){
                    Position next = new Position(now.x + dir[0], now.y + dir[1]);

                    if(isInBound(next, grid) && grid[next.x][next.y] == 1){
                        nextQueue.add(next);
                        grid[next.x][next.y] = 2;
                        rottedSomething = true;
                    }
                }
            }
            if(rottedSomething)ans++;
            q = nextQueue;
        }

        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(grid[i][j] == 1) return -1;
            }
        }

        return ans;
    }
    boolean isInBound(Position pos, int[][] grid){
        return pos.x >= 0 && pos.y >= 0 && pos.x < grid.length && pos.y < grid[0].length;
    }
}