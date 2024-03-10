package cn.iocoder.yudao.leecode.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class _13RomanToInt {

    static Map<String, Integer> specialMap = new HashMap<>();
    static Map<String, Integer> numMap = new HashMap<>();

    static {
        specialMap.put("IV", 4);
        specialMap.put("IX", 9);
        specialMap.put("XL", 40);
        specialMap.put("XC", 90);
        specialMap.put("CD", 400);
        specialMap.put("CM", 900);
        numMap.put("I", 1);
        numMap.put("V", 5);
        numMap.put("X", 10);
        numMap.put("L", 50);
        numMap.put("C", 100);
        numMap.put("D", 500);
        numMap.put("M", 1000);
    }

    public int auto(String s, int res, AtomicInteger atomicInteger, char in, char next0, char next1, int i0, int i1) {
        if (s.charAt(atomicInteger.get()) == in) {
            if (atomicInteger.get() + 1 < s.length()) {
                char c1 = s.charAt(atomicInteger.get() + 1);
                if (c1 == next0) {
                    res += i0;
                    atomicInteger.incrementAndGet();
                } else if (c1 == next1) {
                    res += i1;
                    atomicInteger.incrementAndGet();
                } else {
                    res = getRes(String.valueOf(s.charAt(atomicInteger.get())), res);
                }
            } else {
                res = getRes(String.valueOf(s.charAt(atomicInteger.get())), res);
            }
        }
        return res;
    }

    private static int getRes(String s, int res) {
        Integer ii = numMap.get(s);
        if (ii != null) {
            res += ii;
        }
        return res;
    }

    public int romanToInt(String s) {
        int res = 0;
        for (AtomicInteger atomicInteger = new AtomicInteger(0); atomicInteger.get() < s.length(); atomicInteger.incrementAndGet()) {
            char c = s.charAt(atomicInteger.get());
            if (c == 'I') {
                res = auto(s, res, atomicInteger, 'I', 'V', 'X', 4, 9);
            } else if (c == 'X') {
                res = auto(s, res, atomicInteger, 'X', 'L', 'C', 40, 90);
            } else if (c == 'C') {
                res = auto(s, res, atomicInteger, 'C', 'D', 'M', 400, 900);
            } else {
                res = getRes(String.valueOf(c), res);
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int ivivxlc = new _13RomanToInt().romanToInt("DCXXI");
        System.out.println(ivivxlc);
    }

    class Solution {
        public int romanToInt(String s) {
            int sum = 0;
            int preNum = getValue(s.charAt(0));
            for (int i = 1; i < s.length(); i++) {
                int num = getValue(s.charAt(i));
                if (preNum < num) {
                    sum -= preNum;
                } else {
                    sum += preNum;
                }
                preNum = num;
            }
            sum += preNum;
            return sum;
        }

        private int getValue(char ch) {
            switch (ch) {
                case 'I':
                    return 1;
                case 'V':
                    return 5;
                case 'X':
                    return 10;
                case 'L':
                    return 50;
                case 'C':
                    return 100;
                case 'D':
                    return 500;
                case 'M':
                    return 1000;
                default:
                    return 0;
            }
        }
    }
}
