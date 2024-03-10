package cn.iocoder.yudao.leecode.easy;

public class _96isSymmetric {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        return inner(left, right);
    }

    boolean inner(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        boolean checkLeft = inner(left.left, right.right);
        if (!checkLeft) return false;
        return inner(left.right, right.left);
    }
}
