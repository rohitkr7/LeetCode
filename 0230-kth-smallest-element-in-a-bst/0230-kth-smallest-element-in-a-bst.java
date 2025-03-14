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

    /*
     * Hint 1: In-Order Traversal
     * In-Order Traversal of a Binary Search Tree (BST) visits nodes in ascending
     * order. This means that the k-th node visited during an in-order traversal is
     * the k-th smallest element in the BST.
     * Hint 2: Recursive Approach
     * You can use a recursive in-order traversal to count nodes as you visit them.
     * When you reach the k-th node, you have found your answer.
     * 
     */

    private int count = 0;
    private int result = 0;

    public int kthSmallest(TreeNode root, int k) {
        inOrderTraversal(root, k);
        return result;
    }

    private void inOrderTraversal(TreeNode node, int k) {
        if (node == null)
            return;

        inOrderTraversal(node.left, k);

        count++;
        if (count == k) {
            result = node.val;
            return;
        }

        inOrderTraversal(node.right, k);
    }
}