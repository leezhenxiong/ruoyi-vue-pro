package cn.iocoder.yudao.leecode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 */
public class _12IntToRoman {

    static Map<Integer, String> specialMap = new HashMap<>();
    static Map<Integer, String> numMap = new HashMap<>();
    static {
        specialMap.put(4, "IV");
        specialMap.put(9, "IX");
        specialMap.put(40, "XL");
        specialMap.put(90, "XC");
        specialMap.put(400, "CD");
        specialMap.put(900, "CM");
        numMap.put(1, "I");
        numMap.put(5, "V");
        numMap.put(10, "X");
        numMap.put(50, "L");
        numMap.put(100, "C");
        numMap.put(500, "D");
        numMap.put(1000, "M");
    }

    public String intToRoman(int num) {
        String s = specialMap.get(num);
        if (s != null) {
            return s;
        }
        s = numMap.get(num);
        if (s != null) {
            return s;
        }



        return "";
    }
}
