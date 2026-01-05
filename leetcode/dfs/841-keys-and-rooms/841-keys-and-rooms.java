import java.util.Arrays;
import java.util.List;

class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int[] visited = new int[rooms.size()];
        dfs(0, rooms, visited);

        int[] allVisited = new int[rooms.size()];
        Arrays.fill(allVisited, 1);
        return Arrays.equals(visited, allVisited);
    }

    public void dfs(int pos, List<List<Integer>> rooms, int[] visited){
        if(visited[pos] == 1) return;
        visited[pos] = 1;

        for(int key: rooms.get(pos)){
            dfs(key, rooms, visited);
        }
    }
}


/*
Approach is simply to visit all of the rooms by using keys obtained using DFS
we will need to keep track which room we already visited to prune the dfs

Update the visited room once we in there -> recursively calls each key in the room

As final answer, check if we visited all rooms -> O(n)

T(n): O(N*M) where n is length of room and M is max key in the rooms
S(n): O(N) -> Visited array
*/