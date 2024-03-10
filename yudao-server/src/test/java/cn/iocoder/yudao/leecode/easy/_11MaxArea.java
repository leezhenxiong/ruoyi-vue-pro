package cn.iocoder.yudao.leecode.easy;

public class _11MaxArea {
    /**
     * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
     * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
     * 返回容器可以储存的最大水量。
     * 说明：你不能倾斜容器。
     */
    public int maxArea1(int[] height) {
        int len = height.length;
        int max = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int x = j - i;
                int hi = height[i];
                int hj = height[j];
                int h0 = Math.min(hi, hj);
                int area = x * h0;
                if (max < area) {
                    max = area;
                }
            }
        }
        return max;
    }

    public int maxArea(int[] height) {
        int len = height.length;
        int i = 0, j = len -1, res = 0;
        while (i < j) {
            if (height[i] < height[j]) {
                res = Math.max(res, (j - i) * height[i++]);
            } else {
                res = Math.max(res, (j - i) * height[j--]);
            }
        }
        return res;
    }
}
