# Spiral Matrix

## Problem Description

Given an `m x n` matrix, return all elements of the matrix in spiral order.

**Example 1:**

```
Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]
```

**Example 2:**

```
Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
```

## Solution Approach: Simulation

We can simulate the path of a spiral. We start at `(0,0)` and move right. When we hit a boundary or a visited cell, we turn 90 degrees clockwise. We continue until we have visited all `m * n` cells.

### Algorithm

1.  Define 4 directions: Right, Down, Left, Up.
2.  Initialize a `visited` matrix of the same dimensions to keep track of visited cells.
3.  Start at `(0,0)` with direction `Right`.
4.  Loop until the result list contains all elements:
    - Add current element to result.
    - Mark current position as `visited`.
    - Calculate next position based on current direction.
    - Check if next position is invalid (out of bounds or already visited).
      - If invalid, change direction clockwise (Right -> Down -> Left -> Up -> Right).
      - Update next position based on new direction.
    - Move to the next position.

### Complexity Analysis

- **Time Complexity:** $O(M \cdot N)$, where $M$ is the number of rows and $N$ is the number of columns. We visit each element exactly once.
- **Space Complexity:** $O(M \cdot N)$ for the `visited` array.

## Code Structure

```java
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
```
