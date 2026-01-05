/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans =new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(root, targetSum, 0, ans, path);

        return ans;
    }

    void dfs(TreeNode root, int targetSum, int sum, List<List<Integer>> ans, List<Integer> path){
        if(root == null) return;

        sum += root.val;
        path.add(root.val);

        if(root.right == null && root.left == null){
            if(sum == targetSum){
                ans.add(new ArrayList<>(path));
            }
        } else { 
            dfs(root.left, targetSum, sum, ans, path);
            dfs(root.right, targetSum, sum, ans, path);
        }

        path.remove(path.size() - 1);
    }
}