package leetcode.backtracking;

class Solution {
    public class Position{
        int row, col;
        Position(int row, int col){
            this.row = row;
            this.col = col;
        }
    }

    public boolean exist(char[][] board, String word) {
        char start = word.charAt(0);
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                char c = board[i][j];
                boolean res = false;
                StringBuilder sb = new StringBuilder();
                sb.append(c);
                boolean[][] visited = new boolean[board.length][board[0].length];
                visited[i][j] = true;
                if(c == start) res = dfs(board, word, sb, visited, new Position(i, j));
                if(res) return res;
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, String word, StringBuilder sb, boolean[][]visited, Position pos){
        if(word.equals(sb.toString())){
            return true;
        }

        int[][] dirs = new int[][]{{0,1}, {0, -1}, {1, 0}, {-1, 0}};
        for(int[] dir: dirs){
            int nextRow = dir[0] + pos.row;
            int nextCol = dir[1] + pos.col;

            if(!isInBoard(nextRow, nextCol, board)){
                continue;
            }

            if(visited[nextRow][nextCol]){
                continue;
            }

            char c = board[nextRow][nextCol];
            sb.append(c);
            visited[nextRow][nextCol] = true;

            if(!word.substring(0, sb.toString().length()).equals(sb.toString())){
                sb.deleteCharAt(sb.length() - 1);
                visited[nextRow][nextCol] = false;
                continue;
            }

            if(dfs(board, word, sb, visited, new Position(nextRow, nextCol))){
                return true;
            }

            sb.deleteCharAt(sb.length() - 1);
            visited[nextRow][nextCol] = false;
        }
        return false;
    }

    public boolean isInBoard(int row, int col, char[][]board){
        return row >= 0 && col >= 0 && col < board[0].length && row < board.length;
    }
}

/*
NOTE: based on the contraints we need not to worry about edge cases

Backtrack states:
- our current built word
- visited positions
- current position

So we're gonna use backtracking where we try every possible scenario given every possible starting points.

Starting points can be found iff word.charAt(0) == board[i][j] -> we can start dfs from here
every dfs need to keep track of visited position so that we didn't visit the same place twice, return true if we found any route into the word

If after trying every possible scenario we didn't find the route, then just return false

T(n) = O(4^L * |SP|) -> 4 because we have 4 directions and will be repeated each iteration by L where L is length of the words (up until we found the combination)
S(n) = O(L * |startingPoints|) -> Recursion stack -> L iteration at most

*/