# Robot Return to Origin

## Problem Description

There is a robot starting at the position `(0, 0)`, the origin, on a 2D plane. Given a sequence of its moves, judge if this robot **ends up at (0, 0)** after it completes its moves.

The move sequence is represented by a string `moves`, and the character `moves[i]` represents its $i^{th}$ move. Valid moves are `'R'` (right), `'L'` (left), `'U'` (up), and `'D'` (down). If the robot returns to the origin after it finishes all of its moves, return `true`. Otherwise, return `false`.

**Note:** The way that the robot is "facing" is irrelevant. `'R'` will always make the robot move to the right once, `'L'` will always make it move left, etc. Also, assume that the magnitude of the robot's movement is the same for each move.

**Example 1:**

```
Input: moves = "UD"
Output: true
Explanation: The robot moves up once, and then down once. All moves have the same magnitude, so it ended up at the origin where it started. Therefore, we return true.
```

**Example 2:**

```
Input: moves = "LL"
Output: false
Explanation: The robot moves left twice. It ends up two "moves" to the left of the origin. We return false.
```

## Solution Approach: Simulation

We can simulate the robot's movement by maintaining its `x` and `y` coordinates. We start at `(0, 0)` and update the coordinates for each move.

### Algorithm

1.  Initialize `x = 0` and `y = 0` (or use a `Position` object).
2.  Iterate through each character `c` in `moves`.
    - If `c == 'U'`, increment `y`.
    - If `c == 'D'`, decrement `y`.
    - If `c == 'R'`, increment `x`.
    - If `c == 'L'`, decrement `x`.
3.  Check if `x == 0` and `y == 0`. Return the result.

### Complexity Analysis

- **Time Complexity:** $O(N)$, where $N$ is the length of the moves string. We process each move once.
- **Space Complexity:** $O(1)$. We only use a constant amount of extra space for coordinates.

## Code Structure

```java
class Position{
    int x, y;

    public Position(int x, int y){
        this.x = x;
        this.y = y;

    }
}
class Solution {
    public boolean judgeCircle(String moves) {
        Position pos = new Position(0, 0);

        for(char c: moves.toCharArray()){
            if(c == 'U'){
                pos.y++;
            } else if(c == 'L'){
                pos.x--;
            } else if(c == 'R'){
                pos.x++;
            } else {
                pos.y--;
            }
        }

        return pos.x == 0 && pos.y == 0;
    }
}
```
