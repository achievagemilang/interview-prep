class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        
        return bfs(maze, entrance, dirs, visited);
    }

    public int bfs(char[][] grid, int[] entrance, int[][] dirs, boolean[][] visited){
        Queue<int[]> q = new ArrayDeque<>();
        q.add(entrance);
        visited[entrance[0]][entrance[1]] = true;
        
        int steps = 0;

        while(!q.isEmpty()){
            int size = q.size();
            steps++; 

            while(size-- > 0){
                int[] now = q.poll();
                
                for(int[] dir: dirs){
                    int[] next = new int[]{now[0] + dir[0], now[1] + dir[1]};

                    if(!isInBound(grid, next)) continue;

                    if(!visited[next[0]][next[1]] && grid[next[0]][next[1]] == '.'){
                        if(isExit(grid, next)){
                            return steps;
                        }
                        
                        visited[next[0]][next[1]] = true;
                        q.add(next);
                    }
                }
            }
        }

        return -1;
    }

    public boolean isInBound(char[][] maze, int[] pos){
        return pos[0] >= 0 && pos[1] >= 0 && pos[1] < maze[0].length && pos[0] < maze.length;
    }

    public boolean isExit(char[][] maze, int[] pos){
        return pos[0] == 0 || pos[1] == 0 || pos[0] == maze.length - 1 || pos[1] == maze[0].length - 1;
    }
}