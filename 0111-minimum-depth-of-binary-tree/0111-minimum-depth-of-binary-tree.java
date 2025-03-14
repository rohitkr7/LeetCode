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
    // DFS Solution : Recursion using call stack
    public int minDepth_1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        // If left subtree is null, recurse on right subtree
        if (root.left == null) {
            return minDepth(root.right) + 1;
        }
        
        // If right subtree is null, recurse on left subtree
        if (root.right == null) {
            return minDepth(root.left) + 1;
        }
        
        // If both subtrees are not null, find the minimum depth of both subtrees
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }

    // BFS Solution
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 1;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                if (currentNode.left == null && currentNode.right == null) {
                    return depth;
                }
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
            depth++;
        }

        return depth;
    }
}