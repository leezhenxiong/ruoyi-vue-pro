package cn.iocoder.yudao.leecode.easy;

import java.util.Arrays;

public class _66plusOne {

    public static void main(String[] args) {
        int[] ints = new _66plusOne().plusOne(new int[]{9, 9});
        System.out.println(Arrays.toString(ints));
    }

    public int[] plusOne(int[] digits) {
        int index = digits.length - 1;
        int lastI = digits[index];
        int carry = (lastI + 1) / 10;
        if (carry != 1) {
            digits[index]++;
            return digits;
        } else {
            digits[index] = 0;
            while (carry == 1) {
                if (index > 0) {
                    int nextI = digits[--index];
                    digits[index] = (nextI + 1) % 10;
                    carry = (nextI + 1) / 10;
                } else {
                    int[] res = new int[digits.length + 1];
                    res[0] = 1;
                    System.arraycopy(digits, 0, res, 1, digits.length);
                    return res;
                }
            }
        }
        return digits;
    }

    static class Solution {
        public static void main(String[] args) {
            int[] ints = new Solution().plusOne(new int[]{9, 9});
            System.out.println(Arrays.toString(ints));
        }

        public int[] plusOne(int[] digits) {
            int i = digits.length - 1;
            while (i >= 0) {
                digits[i]++;
                if (digits[i] % 10 != 0) {
                    return digits;
                }
                digits[i] = digits[i] % 10;
                i--;
            }
            int[] res = new int[digits.length + 1];
            res[0] = 1;
            return res;
        }
    }
}
