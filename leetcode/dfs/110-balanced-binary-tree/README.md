# Balanced Binary Tree

## Problem Description

Given a binary tree, determine if it is **height-balanced**.

A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every node never differs by more than one.

## Examples

**Example 1:**

```
Input: root = [3,9,20,null,null,15,7]
Output: true
```

**Example 2:**

```
Input: root = [1,2,2,3,3,null,null,4,4]
Output: false
```

## Solution Approach

Use a bottom-up DFS approach that returns `-1` if any subtree is unbalanced.

1. Recursively compute the height of each subtree.
2. If the left or right subtree returns `-1`, propagate `-1` up (unbalanced).
3. If the height difference between left and right exceeds 1, return `-1`.
4. Otherwise, return `1 + max(leftHeight, rightHeight)`.

This approach avoids redundant height calculations by short-circuiting as soon as imbalance is detected.

## Complexity Analysis

- **Time Complexity:** $O(N)$ — each node is visited once.
- **Space Complexity:** $O(H)$ — recursion stack depth, where $H$ is the tree height.

## Code Structure

```java
class Solution {
    public boolean isBalanced(TreeNode root) {
        return dfsHeight(root) != -1;
    }

    public int dfsHeight(TreeNode root){
        if(root == null) return 0;

        int leftH = dfsHeight(root.left);
        if(leftH == -1) return -1;

        int rightH = dfsHeight(root.right);
        if(rightH == -1) return -1;

        if(Math.abs(leftH - rightH) > 1) return -1;

        return 1 + Math.max(leftH, rightH);
    }
}
```
