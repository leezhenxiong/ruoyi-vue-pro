package cn.iocoder.yudao.leecode.easy;

public class _8MyAtoi {
    public static void main(String[] args) {
        int i = new _8MyAtoi().myAtoi("  0000000000012345678");
        System.out.println(i);
    }
    public int myAtoi(String s) {
        s = s.trim();
        if ("".equals(s)) {
            return 0;
        }
        int length = s.length();
        char char0 = s.charAt(0);
        if (!Character.isDigit(char0) && ('-' != char0 && '+' != char0)) {
            return 0;
        }
        if (char0 == '-' || char0 == '+') {
            if (length > 1 && !Character.isDigit(s.charAt(1)) || length == 1) {
                return 0;
            }
        } else if (length == 1 && Character.isDigit(char0)) {
            return Integer.parseInt(s);
        }
        String cutStr = cutStr(length, s);
        return calIntByIntStr(cutStr);
    }

    public String cutStr(int length, String s) {
        int i = 0;
        int j = 0;
        if (s.charAt(0) == '+' || s.charAt(0) == '-') {
            i = 1;
            j = 1;
        }
        int init = i;
        boolean longZeroFlag = true;
        for (; i < length; i++) {
            char charsi = s.charAt(i);
            if (!('0' == charsi && longZeroFlag)) {
                longZeroFlag = false;
                if (j - init >= 11) {
                    return s.substring(init, j);
                } else {
                    if (!Character.isDigit(charsi)) {
                        return s.substring(init, j);
                    }
                    j++;
                    // sb.append(charsi);
                }
            } else {
                init++;
                j++;
            }
        }
        return s.substring(init, j);
    }

    // 2147483647
    //-2147483648
    private int calIntByIntStr(String s) {
        //System.out.println("input = " + s);
        if ("".equals(s)) {
            return 0;
        }
        if (s.charAt(0) == '-') {
            if (s.length() >= 10) {
                if (Long.parseLong("-" + s) <= Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                } else {
                    return -Integer.parseInt(s);
                }
            } else {
                return -Integer.parseInt(s);
            }
        } else {
            if (s.length() >= 10) {
                if (Long.parseLong(s) >= Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                } else {
                    return Integer.parseInt(s);
                }
            } else {
                return Integer.parseInt(s);
            }
        }
    }

}
