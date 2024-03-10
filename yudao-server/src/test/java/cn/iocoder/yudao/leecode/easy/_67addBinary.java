package cn.iocoder.yudao.leecode.easy;

public class _67addBinary {

    public static void main(String[] args) {
        String s = "10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101";

        String s1 = new _67addBinary().addBinary("210110", "110");
        System.out.println(s1);
    }

    public String addBinary(String a, String b) {

        int len = Math.min(a.length(), b.length());
        char[] aCharArray = a.toCharArray();
        char[] bCharArray = b.toCharArray();
        StringBuilder aBuilder;
        StringBuilder bBuilder;
        if (a.length() == len) {
            aBuilder = new StringBuilder(a).reverse();
            bBuilder = new StringBuilder(b).reverse();
        } else {
            bBuilder = new StringBuilder(a).reverse();
            aBuilder = new StringBuilder(b).reverse();
        }
        String remainedBuilder = bBuilder.substring(0, len);
        System.out.println(remainedBuilder);
        StringBuilder result = new StringBuilder();
        int carry = 0;
        for (int i = 0; i < len; i++) {
            int i1 = Integer.parseInt(String.valueOf(aBuilder.charAt(i)));
            int i2 = Integer.parseInt(String.valueOf(bBuilder.charAt(i)));
            int i3 = (i1 + i2) % 2 + carry;
            result.append(i3 );
            carry = (i1 + i2) / 2;
        }
        return "";
    }




    static class Solution {
        public static void main(String[] args) {
            String s = "10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101";
            String s1 = new Solution().addBinary("110110", "110");
            System.out.println(s1);
        }

        public String addBinary(String a, String b) {
            StringBuilder ans = new StringBuilder();
            int n = Math.max(a.length(), b.length()), carry = 0;
            for (int i = 0; i < n; ++i) {
                carry += i < a.length() ? (a.charAt(a.length() - 1 - i) - '0') : 0;
                carry += i < b.length() ? (b.charAt(b.length() - 1 - i) - '0') : 0;
                ans.append((char) (carry % 2 + '0'));
                carry /= 2;
            }
            if (carry > 0) {
                ans.append('1');
            }
            ans.reverse();
            return ans.toString();
        }
    }
}
