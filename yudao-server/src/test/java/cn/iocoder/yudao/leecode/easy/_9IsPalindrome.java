package cn.iocoder.yudao.leecode.easy;

public class _9IsPalindrome {

    public static void main(String[] args) {

    }

    public boolean isPalindrome(int x) {
        int result = x % 10;// 123 ===> 3
        if (x < 0 || (result == 0 && x != 0)) {
            return false;
        } else if (x < 10) {
            return true;
        }
        // 123
        int div = x / 10; // 12
        while (div != 0) {
            int modNext = div % 10; // 2 1
            result = result * 10 + modNext;// 32  321
            div = div / 10;  // 1 0
        }
        return x == result;
    }

    class Solution {
        public boolean isPalindrome(int x) {
            String s = String.valueOf(x);
            int length = s.length();
            int middle = length / 2;
            int mod = length % 2;
            if (mod == 1) {
                middle += 1;
            }
            for (int i = 0; i < middle; i++) {
                if (s.charAt(i) != s.charAt(length - i -1)) {
                    return false;
                }
            }
            return true;
        }
    }
}
