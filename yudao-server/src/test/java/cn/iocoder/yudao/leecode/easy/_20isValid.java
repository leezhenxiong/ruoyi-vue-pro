package cn.iocoder.yudao.leecode.easy;

import java.util.LinkedList;

public class _20isValid {

    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
     * 有效字符串需满足：
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 每个右括号都有一个对应的相同类型的左括号。
     * ([{}])  ()[]{} "([)]"
     * ) ] }
     * } ] )
     * [), ]]
     * [], )]
     *
     * "){"
     */

    public static void main(String[] args) {
        boolean valid = new _20isValid().isValid("()[]{}");
        System.out.println(valid);
    }
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) return false;
        LinkedList<Character> left = new LinkedList<>();
        for (char c : s.toCharArray()) {
            char bracket = getBracket(c);
            if (c != bracket) {
                left.push(bracket);
            } else {
                if (left.isEmpty()) return false;
                if (left.pop() != c) {
                    return false;
                }
            }
        }
        return left.isEmpty();
    }

    private char getBracket(char c) {
        if (c == '(') {
            return ')';
        } else if (c == '{') {
            return '}';
        } else if (c == '[') {
            return ']';
        }
        return c;
    }

    //==========================================
    static class Solution {

        public static void main(String[] args) {
            boolean valid = new Solution().isValid("()[]{}");
            System.out.println(valid);
        }

        public boolean isValid(String s) {
            char[] chars = s.toCharArray();
            int index = 0;
            for (char c : chars) {
                if (c == '(' || c == '[' || c == '{') {
                    chars[index++] = (char) (c + c / 91 + 1);
                } else if (index ==0 || c != chars[--index]) {
                    return false;
                }
            }
            return index == 0;
        }
    }
}
