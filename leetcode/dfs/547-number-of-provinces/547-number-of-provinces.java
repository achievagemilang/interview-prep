class Solution {
    public int findCircleNum(int[][] isConnected) {
        boolean[] visited = new boolean[isConnected.length];
        int[] startPos = new int[isConnected.length];
        for(int i=0; i<isConnected.length; i++){
            startPos[i] = i;
        }

        int ans = 0;
        for(int i=0; i<startPos.length; i++){
            int pos = startPos[i];
            ans += dfs(pos, visited, isConnected);
        }

        return ans;
    }

    public int dfs(int pos, boolean[] visited, int[][] isConnected){
        if(visited[pos]) return 0;

        visited[pos] = true;
        for(int i=0; i<isConnected.length; i++){
            if(isConnected[pos][i] == 1 && !visited[i]){
                dfs(i, visited, isConnected);
            }
        }

        return 1;
    }
}

/*
Idea is to have all starting possible positions -> 1,2,3,4,..n (if 1-indexed)
Then use DFS to visit until the last possible nodes then increment our ans accordingly, we must keep track of visited nodes so that if the recursion of dfs found visited nodes means that it's on the same provinces

return the ans that we store in the params

T(N): O(V*E) -> vertex/node and edges
S(N): O(N) -> visited
*/