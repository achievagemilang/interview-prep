class Solution {
    class Pair{
        int node;
        int edgeIndex;

        Pair(int node, int edgeIndex){
            this.node = node;
            this.edgeIndex = edgeIndex;
        }
    }
    
    public List<Integer> minimumFlips(int n, int[][] edges, String start, String target) {
        int[] needsFlip = new int[n];
        for(int i=0; i<n; i++){
            needsFlip[i] = (start.charAt(i) - '0') ^ (target.charAt(i) - '0');
        }

        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0; i<edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];

            adj.get(u).add(new Pair(v, i));
            adj.get(v).add(new Pair(u, i));
        }

        List<Integer> res = new ArrayList<>();

        dfs(0, -1, res, adj, needsFlip);
            
        if(needsFlip[0] == 1){
            List<Integer> ans = new ArrayList<>();
            ans.add(-1);
            return ans;
            
        }

        Collections.sort(res);

        return res;

    }

    private void dfs(int u, int p, List<Integer> res, List<List<Pair>> adj, int[] needsFlip){
        for(Pair neighbor: adj.get(u)){
            int v = neighbor.node;
            int edgeIndex = neighbor.edgeIndex;

            if(v != p){
                dfs(v, u, res, adj, needsFlip);

                if(needsFlip[v] == 1){
                    res.add(edgeIndex);
                    needsFlip[v] ^= 1;
                    needsFlip[u] ^= 1;
                }
            }
        } 
    }
}