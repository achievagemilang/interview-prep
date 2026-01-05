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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return dfs(root, targetSum, 0);
    }

    public boolean dfs(TreeNode root, int targetSum, int sum){
        if(root == null){
            return false;
        }
        int v = root.val;

        if(root.right == null && root.left == null){
            int currentSum = v + sum;
            return currentSum == targetSum;
        }
        return dfs(root.left, targetSum, sum+v) || dfs(root.right, targetSum, sum+v);
    }
}