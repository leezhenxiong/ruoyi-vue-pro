package cn.iocoder.yudao.leecode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 70. 爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 示例 1：
 * 输入：n = 2
 * 输出：2
 * 解释：有两种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶
 * 2. 2 阶
 * 示例 2：
 * <p>
 * 输入：n = 3
 * 输出：3
 * 解释：有三种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶 + 1 阶
 * 2. 1 阶 + 2 阶
 * 3. 2 阶 + 1 阶
 */
public class _70climbStairs {
    Map<Integer, Integer> map = new HashMap<>();

    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int n1, n2;
        if (map.containsKey(n - 1)) {
            n1 = map.get(n - 1);
        } else {
            n1 = climbStairs(n - 1);
        }
        if (map.containsKey(n - 2)) {
            n2 = map.get(n - 2);
        } else {
            n2 = climbStairs(n - 2);
        }
        int result = n1 + n2;
        map.putIfAbsent(n, result);
        return result;
    }

    class Solution {

        public int climbStairs(int n) {
            if (n <= 2) return n;
            int[] array = new int[n];
            array[0] = 1;
            array[1] = 2;
            for (int i = 2; i < n; i++) {
                array[i] = array[i - 1] + array[i - 2];
            }
            return array[n - 1];
        }
    }

    class Solution1 {
        public int climbStairs(int n) {
            int p = 0, q = 0, r = 1;
            for (int i = 1; i <= n; ++i) {
                p = q;
                q = r;
                r = p + q;
            }
            return r;
        }
    }


}
