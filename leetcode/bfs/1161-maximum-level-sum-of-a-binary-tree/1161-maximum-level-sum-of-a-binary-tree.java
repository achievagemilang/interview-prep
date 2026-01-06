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
    public int maxLevelSum(TreeNode root) {
        Map<Integer,Integer> res = new HashMap<>();
        if(root == null) return -1; 
        int maxValue = Integer.MIN_VALUE;

        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        int level = 1;

        while(!q.isEmpty()){
            int size = q.size();
            int sum = 0;
            while(size > 0){
                TreeNode n = q.poll();
                size--;
                sum += n.val;
                if(n.left != null){
                    q.add(n.left);
                }
                if(n.right != null){
                    q.add(n.right);
                }
            }
            res.putIfAbsent(sum, level);
            maxValue = Math.max(sum, maxValue);
            level++;
        }

        return res.get(maxValue);

    }
}