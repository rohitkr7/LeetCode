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
     * Time complexity:
     * 
     * In the worst case, the height (h) could be as large as (n)(the number of
     * nodes) if the tree is unbalanced, leading to O(n)complexity.
     * In the best case, if the tree is balanced, the height (h) would be (logn),
     * leading to O(logn) complexity.
     * Space complexity:
     * 
     * In the worst case, the space complexity is O(n) if the tree is completely
     * unbalanced.
     * In the best case, the space complexity is O(logn) if the tree is balanced.
     * 
     */

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        } else if (root.val > val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }
}