class Solution {
    class Position {
        int i, j;
        Position(int i, int j){
            this.i = i;
            this.j = j;

        }
    }
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;


        int ans = 0;
        boolean[][] visited = new boolean[rows][cols]; 
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    bfs(new Position(i, j), visited, grid);
                    ans++;
                }
            }
        }

        return ans;
    }

    public void bfs(Position pos , boolean[][] visited, char[][] grid){
        Queue<Position> q = new ArrayDeque();
        q.add(pos);
        visited[pos.i][pos.j] = true;
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        while(!q.isEmpty()){
            Position now = q.poll();

            for(int[] d: dirs){
                Position next = new Position(now.i + d[0], now.j + d[1]);

                if(isInBound(next, grid) && !visited[next.i][next.j] && grid[next.i][next.j] == '1'){
                    q.add(next);
                    visited[next.i][next.j] = true;
                }
            }
        } 
    }

    public boolean isInBound(Position pos, char[][] grid){
        int rows = grid.length;
        int cols = grid[0].length;

        return pos.i >= 0 && pos.i < rows && pos.j >=0 && pos.j < cols;
    }
}