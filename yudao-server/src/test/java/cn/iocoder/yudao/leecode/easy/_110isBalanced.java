package cn.iocoder.yudao.leecode.easy;

public class _110isBalanced {
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
        public boolean isBalanced(TreeNode root) {
            return countHeight(root) >= 0;
        }

        public int countHeight(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int left = countHeight(root.left);
            int right = countHeight(root.right);
            return left == -1 || right == -1 || Math.abs(left - right) > 1 ? -1 : Math.max(left, right) + 1;
        }
    }
}
