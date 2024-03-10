package cn.iocoder.yudao.leecode.easy;

public class _69mySqrt {

    public static void main(String[] args) {
        System.out.println(Math.log(9));
    }

    public int mySqrt(int x) {


        return 0;
    }

    static class Solution {

        public static void main(String[] args) {
            int i = new Solution().mySqrt(4);
            System.out.println(i);
        }

        int s;

        public int mySqrt(int x) {
            s = x;
            if (x == 0) return 0;
            return ((int) (sqrts(x)));
        }

        public double sqrts(double x) {
            double res = (x + s / x) / 2;
            if (res == x) {
                return x;
            } else {
                return sqrts(res);
            }
        }
    }

    public class Solution1 {

        public int mySqrt(int x) {
            // 特殊值判断
            if (x == 0) {
                return 0;
            }
            if (x == 1) {
                return 1;
            }

            int left = 1;
            int right = x / 2;
            // 在区间 [left..right] 查找目标元素
            while (left < right) {
                int mid = left + (right - left + 1) / 2;
                // 注意：这里为了避免乘法溢出，改用除法
                if (mid > x / mid) {
                    // 下一轮搜索区间是 [left..mid - 1]
                    right = mid - 1;
                } else {
                    // 下一轮搜索区间是 [mid..right]
                    left = mid;
                }
            }
            return left;
        }
    }



}
