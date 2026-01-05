class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        enum Direction {
            Left, Right, Bottom, Up
        }

        if (matrix == null || matrix.length == 0) return new ArrayList<>();

        Direction dir = Direction.Right;
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        
        int[] pos = new int[]{0, 0};
        List<Integer> res = new ArrayList<>();
        
        int totalElements = matrix.length * matrix[0].length;

        while(res.size() < totalElements){
            res.add(matrix[pos[0]][pos[1]]);
            visited[pos[0]][pos[1]] = true;

            if(res.size() == totalElements) break;

            int[] newPos = new int[]{pos[0], pos[1]};
            if(dir == Direction.Right)      newPos[1]++;
            else if(dir == Direction.Left)  newPos[1]--;
            else if(dir == Direction.Up)    newPos[0]--;
            else                            newPos[0]++; 

            if(newPos[0] >= matrix.length || newPos[0] < 0 || 
               newPos[1] >= matrix[0].length || newPos[1] < 0 || 
               visited[newPos[0]][newPos[1]]) {
                
                if(dir == Direction.Right)      dir = Direction.Bottom;
                else if(dir == Direction.Left)  dir = Direction.Up;
                else if(dir == Direction.Up)    dir = Direction.Right;
                else                            dir = Direction.Left; 

                if(dir == Direction.Right)      pos[1]++;
                else if(dir == Direction.Left)  pos[1]--;
                else if(dir == Direction.Up)    pos[0]--;
                else                            pos[0]++; 
            } else {
                pos = newPos;
            }
        }

        return res;
    }
}