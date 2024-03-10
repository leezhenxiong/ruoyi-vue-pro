package cn.iocoder.yudao.leecode.easy;

import java.util.Arrays;

public class _58lengthOfLastWord {

    public int lengthOfLastWord1(String s) {
        System.out.println(Arrays.toString(s.toCharArray()));
        String[] split = s.split("\\s+");
        return split[split.length - 1].length();
    }

    public static void main(String[] args) {
        int i = new _58lengthOfLastWord().lengthOfLastWord("aa");
        System.out.println(i);
    }

    public int lengthOfLastWord(String s) {
        int index = s.length() - 1;
        boolean endWithAl = Character.isAlphabetic(s.codePointAt(index));
        int len = endWithAl ? 1 : 0;
        if (endWithAl) {
            while (index > 0 && Character.isAlphabetic(s.codePointAt(--index))) {
                len++;
            }
        } else {
            while (index > 0 && !Character.isAlphabetic(s.codePointAt(index))) {
                index--;
            }
            while (index >= 0 && Character.isAlphabetic(s.codePointAt(index--))) {
                len++;
            }
        }
        return len;
    }
}
