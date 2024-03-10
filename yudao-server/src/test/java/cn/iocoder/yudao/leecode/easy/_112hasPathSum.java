package cn.iocoder.yudao.leecode.easy;

public class _112hasPathSum {
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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return dfs(root, targetSum);
    }

    private boolean dfs(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }
        boolean left = false, right = false;
        if (root.left != null) {
            left = dfs(root.left, targetSum - root.val);
        }
        if (left) return true;
        if (root.right != null) {
            right = dfs(root.right, targetSum - root.val);
        }
        return right;
    }
}
