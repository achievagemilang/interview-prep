class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        List<Integer> subset = new ArrayList<>();
        dfs(0, ans, subset, nums);
        return ans;
    }

    void dfs(int start, List<List<Integer>> ans, List<Integer> subset, int[] nums){
        if(start >= nums.length){
            ans.add(new ArrayList<>(subset));
            return;
        }
        // take
        subset.add(nums[start]);
        dfs(start+1, ans, subset, nums);

        // not take
        subset.remove(subset.size() - 1);
        dfs(start+1, ans, subset, nums);
    }
}
