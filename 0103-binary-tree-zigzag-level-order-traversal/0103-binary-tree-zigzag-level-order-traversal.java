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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null)
            return new ArrayList();
        List<List<Integer>> result = new ArrayList();
        // Queue for adding the current level root node
        Stack<TreeNode> currentLevel = new Stack<TreeNode>();
        currentLevel.push(root);

        // Stack for adding next level child/future nodes to be traversed
        Stack<TreeNode> nextLevel = new Stack<TreeNode>();

        boolean isLeftToRight = true;
        while (!currentLevel.isEmpty()) {
            List<Integer> list = new ArrayList<Integer>();
            int size = currentLevel.size(); // Count how many nodes are present in the current level those many times we
                                            // need to check for children
            while (size-- > 0) {
                // Remove the currentLevel nodes one by one and push their children to the
                // nextLevel nodes
                TreeNode currentNode = currentLevel.pop();
                list.add(currentNode.val);

                if (isLeftToRight) {
                    if (currentNode.left != null)
                        nextLevel.push(currentNode.left);
                    if (currentNode.right != null)
                        nextLevel.push(currentNode.right);
                } else {
                    if (currentNode.right != null)
                        nextLevel.push(currentNode.right);
                    if (currentNode.left != null)
                        nextLevel.push(currentNode.left);
                }
            }
            // Flip the direction
            isLeftToRight = !isLeftToRight;

            // Swap the two stacks
            Stack<TreeNode> temp = currentLevel;
            currentLevel = nextLevel;
            nextLevel = temp;

            result.add(list);

        }
        return result;

    }
}