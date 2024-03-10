package cn.iocoder.yudao.leecode.easy;

public class _28strStr {
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    class Solution {
        public int strStr(String haystack, String needle) {
            char[] array = haystack.toCharArray();
            for (int i = 0; i != array.length; ++i) {
                if (array[i] == needle.charAt(0)) {
                    if (haystack.startsWith(needle, i)) {
                        return i;
                    }
                }
            }
            return -1;
        }
    }
}
