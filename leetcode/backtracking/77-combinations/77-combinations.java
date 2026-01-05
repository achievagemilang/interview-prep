class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if(n < k){
            return res;
        }
        List<Integer> current = new ArrayList<>();
        dfs(1, n, k, res, current);

        return res;
    }

    void dfs(int pos, int n, int k, List<List<Integer>> res, List<Integer> current){
        if(k == current.size()){
            res.add(new ArrayList<>(current));
            return;
        }
        if(pos > n){
            return;
        }

        // take
        current.add(pos);
        dfs(pos+1, n, k, res, current);

        // not take
        current.remove(current.size() - 1);
        dfs(pos+1, n, k, res, current);
    }
}

/*
DFS until k length then backtrack to other possible combinations
*/