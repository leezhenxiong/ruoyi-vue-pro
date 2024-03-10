package cn.iocoder.yudao.leecode.easy;

import java.util.ArrayList;
import java.util.List;

public class _6ZShapeConvert {
    public static void main(String[] args) {
        String paypalishiring = new _6ZShapeConvert().convert("PAYPALISHIRING", 3);
        System.out.println(paypalishiring);

    }

    /**
     * @param s       "PAYPALISHIRING"
     * @param numRows 3
     *                P   A   H   N
     *                A P L S I I G
     *                Y   I   R
     *                ------------------------------
     *                P     I    N
     *                A   L S  I G
     *                Y A   H R
     *                P     I
     * @return "PAHNAPLSIIGYIR"
     */
    public String convert(String s, int numRows) {
        if (numRows < 2) return s;
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < numRows; i++) rows.add(new StringBuilder());
        int i = 0, flag = -1;
        for (char c : s.toCharArray()) {
            rows.get(i).append(c);
            if (i == 0 || i == numRows - 1) flag = -flag;
            i += flag;
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder row : rows) res.append(row);
        return res.toString();
    }

    static class Solution {

        public static void main(String[] args) {
            String s = new Solution().convert("PAYPALISHIRING", 3);
            System.out.println(s);
        }

        public String convert(String s, int numRows) {
            if (numRows == 1) {
                return s;
            }
            int initLen = s.length();
            if (initLen <= numRows) {
                return s;
            }
            int oneRoundNum = 2 * numRows - 2;
            char[] chars = s.toCharArray();
            char[] result = new char[initLen];
            int cursor = 0;
            for (int i = 0; i < numRows; i++) {
                if (i == 0 || i == numRows - 1) {
                    int index = i;
                    while (index <= initLen - 1) {
                        result[cursor++] = chars[index];
                        index = index + oneRoundNum;
                    }
                } else {
                    result[cursor++] = chars[i]; //i = 1 cursor = 4
                    int nextIndex = oneRoundNum - i;
                    int counter = 0;
                    while (nextIndex < initLen && cursor < initLen) {
                        result[cursor++] = chars[nextIndex];
                        if (counter++ % 2 == 0) {
                            nextIndex = nextIndex + 2 * i;  // i=1 5 + 2=7;  i =2: 4 +4 = 8 ; i = 3:
                        } else {
                            nextIndex = nextIndex + oneRoundNum - 2 * i; //initIndex = 2, 4, 8, 10, 14
                        }
                    }
                }
            }
            return new String(result);
        }
    }

    public String convert1(String s, int numRows) {
        int n = s.length(), r = numRows;
        if (r == 1 || r >= n) {
            return s;
        }
        int t = r * 2 - 2;
        int c = (n + t - 1) / t * (r - 1);
        char[][] mat = new char[r][c];
        for (int i = 0, x = 0, y = 0; i < n; ++i) {
            mat[x][y] = s.charAt(i);
            if (i % t < r - 1) {
                ++x; // 向下移动
            } else {
                --x;
                ++y; // 向右上移动
            }
        }
        StringBuffer ans = new StringBuffer();
        for (char[] row : mat) {
            for (char ch : row) {
                if (ch != 0) {
                    ans.append(ch);
                }
            }
        }
        return ans.toString();
    }
}


















