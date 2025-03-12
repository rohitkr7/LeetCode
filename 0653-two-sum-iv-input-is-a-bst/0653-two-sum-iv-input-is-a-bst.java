
// Definition for a binary tree node.
/*
public class TreeNode {
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
*/
class Solution {

    public boolean findTarget(TreeNode root, int k) {
        // In-Order Traversal :: left >> root >> right
        // Note In-Order Traversal on a BST will give us array in sorted ascending array
        // Traversal time: O(n)
        // If we do right >> root >> left :: It will give us an array in descending
        // order

        List<Integer> nums = new ArrayList<>();
        inorder(root, nums);
        for (int i = 0, j = nums.size() - 1; i < j;) {
            if (nums.get(i) + nums.get(j) == k)
                return true;
            if (nums.get(i) + nums.get(j) < k)
                i++;
            else
                j--;
        }
        return false;

    }

    public void inorder(TreeNode root, List<Integer> nums) {
        if (root == null)
            return;
        inorder(root.left, nums);
        nums.add(root.val);
        inorder(root.right, nums);
    }

    // Below is Binary Search Method
    /*
    public boolean findTarget(TreeNode root, int k) {
        return dfs(root, root, k);
    }

    public boolean dfs(TreeNode root, TreeNode cur, int k) {
        if (cur == null)
            return false;
        return search(root, cur, k - cur.val) || dfs(root, cur.left, k) || dfs(root,
                cur.right, k);
    }

    public boolean search(TreeNode root, TreeNode cur, int value) {
        if (root == null)
            return false;
        return (root.val == value) && (root != cur)
                || (root.val < value) && search(root.right, cur, value)
                || (root.val > value) && search(root.left, cur, value);
    }
    */

    // Below is using HashSet and it works with other binary trees also not
    // necessarily to be BST
    /*
    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> set = new HashSet<>();
        return dfs(root, set, k);
    }

    public boolean dfs(TreeNode root, HashSet<Integer> set, int k) {
        if (root == null)
            return false;
        if (set.contains(k - root.val))
            return true;
        set.add(root.val);
        return dfs(root.left, set, k) || dfs(root.right, set, k);
    }
    */
}