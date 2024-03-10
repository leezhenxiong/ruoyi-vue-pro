package cn.iocoder.yudao.leecode.easy;

/**
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 * 示例 1：
 * <p>
 * 输入：x = 123
 * 输出：321
 */
public class _7StringReverse {

    public static void main(String[] args) {
        int reverse = new _7StringReverse().reverse(321);
        System.out.println(reverse);
    }

    public int reverse(int x) {
        long div = (long) x / 10;
        long tmp = (long) x % 10;
        while (div != 0) {
            long nextMod = div % 10;
            tmp = tmp * 10 + nextMod;
            div = div / 10;
        }
        if (tmp < Integer.MIN_VALUE || tmp > Integer.MAX_VALUE) {
            return 0;
        }
        return (int) tmp;
    }
}
