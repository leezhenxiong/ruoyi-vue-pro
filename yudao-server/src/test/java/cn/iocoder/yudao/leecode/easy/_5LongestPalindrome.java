package cn.iocoder.yudao.leecode.easy;

import java.util.HashMap;
import java.util.Map;

public class _5LongestPalindrome {
    public static void main(String[] args) {
        String s = new _5LongestPalindrome().longestPalindrome("tattarrattat");
        System.out.println(s);


    }
    public String longestPalindrome(String s) {
        return maxLongSlice(s);
    }

    public String maxLongSlice(String ans) {
        if (isPalindrome(ans)) {
            return ans;
        }
        Map<Integer, String> map = new HashMap<>();
        int maxResult = 1;
        for (int i = 0; i < ans.length(); i++) {
            //ci =w     ;i =2  i1 = 1 abcacdbaa
            String cStr = Character.toString(ans.charAt(i));
            map.putIfAbsent(1, cStr);
            int j = ans.indexOf(cStr, i + 1);
            while (j > 0) {
                String substring = ans.substring(i, j + 1);
                if (isPalindrome(substring)) {
                    int partLen = substring.length();
                    if (partLen > maxResult) {
                        maxResult = partLen;
                        map.putIfAbsent(maxResult, substring);
                    }
                }
                j = ans.indexOf(cStr, j + 1);
            }
        }
        return map.get(maxResult);
    }

    // ①String.split 性能最差 1500 ,②String.toCharArray() 245, ③ string .charAt性能最佳  187
    private boolean isPalindrome(String s) {
        int len = s.length();
        int limitIndex = len / 2;
        for (int i = 0, j = limitIndex; i < limitIndex; i++) {
            if (!(s.charAt(i) == s.charAt(len - 1 - i))) {
                return false;
            }
        }
        return true;
    }
}


















