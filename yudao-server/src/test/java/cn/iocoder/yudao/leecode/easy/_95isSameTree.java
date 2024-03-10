package cn.iocoder.yudao.leecode.easy;

public class _95isSameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null) {
            return q == null;
        }
        return dfs(p, q);
    }

    boolean dfs(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null || p.val != q.val) {
            return false;
        }
        boolean left = dfs(p.left, q.left);
        if (!left) {
            return false;
        }
        return dfs(p.right, q.right);
    }

}
