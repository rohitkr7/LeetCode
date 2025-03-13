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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> finalResult = new ArrayList<List<Integer>>();
        if (root == null)
            return finalResult;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        while (queue.size() > 0) {
            int qSize = queue.size();
            List list = new ArrayList<Integer>();

            for (int i = 0; i < qSize; i++) {
                TreeNode current = queue.remove();
                if (current != null) {
                    list.add(current.val);
                    queue.add(current.left);
                    queue.add(current.right);
                }

            }
            if (list.size() > 0) {
                finalResult.add(list);
            }

        }
        return finalResult;
    }
}