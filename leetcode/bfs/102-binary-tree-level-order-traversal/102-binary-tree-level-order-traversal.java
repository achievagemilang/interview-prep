package leetcode.bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

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

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        Deque<TreeNode> q = new ArrayDeque<>();
        q.add(root);

        bfs(q, ans);
        
        return ans;
    }

    public void bfs(Deque<TreeNode> q, List<List<Integer>> ans){
        if (q.isEmpty()) return;
        List<Integer> currentLevel = new ArrayList<>();
        Deque<TreeNode> newQ = new ArrayDeque<>();

        while(!q.isEmpty()){
            TreeNode node = q.poll();
            currentLevel.add(node.val);

            TreeNode left = node.left;
            TreeNode right = node.right;

            if(left != null) newQ.add(left);
            if(right != null) newQ.add(right);

        }

        ans.add(currentLevel);
        bfs(newQ, ans);
    }
}


/*
Simply just use BFS
start at root then visit each note while making sure each level is being recorded on the visit -> append to our answer
Java by default is passed by reference when passing an object so we should return the passed ans as our result

T(n) -> O(n) -> visit once
S(n) -> O(n) -> for our queue
*/