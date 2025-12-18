package leetcode.adhoc;

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