/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {

    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    private int dfs(TreeNode root, int count) {
        if (root == null)
            return count;
        count++;
        int leftDepth = dfs(root.left, count);
        int rightDepth = dfs(root.right, count);
        return Math.max(leftDepth, rightDepth);
    }

    public int maxDepth1(TreeNode root) {
        return dfs(root, 0);

    }

    // DFS Recursive Solution
    public int maxDepth_DFS(TreeNode root) {
        if (root == null)
            return 0;
        // If left subtree is null, recurse on right subtree
        if (root.left == null) {
            return maxDepth(root.right) + 1;
        }

        // If right subtree is null, recurse on left subtree
        if (root.right == null) {
            return maxDepth(root.left) + 1;
        }

        // If both subtrees are not null, find the minimum depth of both subtrees
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    // BFS Solution
    public int maxDepth_BFS(TreeNode root) {
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
                    continue;
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
        return depth - 1;
    }

}