package cn.iocoder.yudao.leecode.easy;

public class _14LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        int minLen = Integer.MAX_VALUE;
        for (String s : strs) {
            minLen = Math.min(minLen, s.length());
        }
        if (minLen == Integer.MAX_VALUE) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < minLen; i++) {
            char now = strs[0].charAt(i);

            for (int j = 1; j < strs.length; j++) {
                char c = strs[j].charAt(i);
                if (c != now) {
                    return stringBuilder.toString();
                }
            }
            stringBuilder.append(now);
        }
        return stringBuilder.toString();
    }
}
