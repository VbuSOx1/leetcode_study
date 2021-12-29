package sword_offer;

import org.junit.Test;

/**
 * @author weib
 * @date 2021-12-29 15:43
 * 20. 表示数值的字符串
 * https://leetcode-cn.com/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof/
 * 这种题 各种乱七八糟的情况要考虑 编代码倒是不难
 */
public class No_20 {
    public boolean isNumber(String s) {
        s = s.trim();
        if (s.length() == 0 || s.contains(" ")){
            return false;
        }
        char lastChar = s.charAt(s.length()-1);
        if(lastChar != '.' && (lastChar > '9' || lastChar < '0')){
            return false;
        }
        if (isDouble(s) || isIntNum(s)) {
            return true;
        }
        int eIndex = Math.max(s.indexOf("e"), s.indexOf("E"));
        if (eIndex == -1 || eIndex == s.length()-1) {
            return false;
        }
        String sPre = s.substring(0, eIndex);
        String sAft = s.substring(eIndex+1);
        if (isDouble(sPre) || isIntNum(sPre)) {
            if (isIntNum(sAft)){
                return true;
            }
        }
        return false;
    }

    // 小数
    public boolean isDouble(String s) {
        try {
            Double.parseDouble(s);
        }catch(Exception e) {
            return false;
        }
        return true;
    }

    // 整数
    public boolean isIntNum(String s) {
        try {
            Long.parseLong(s);
        }catch(Exception e) {
            return false;
        }
        return true;
    }

    @Test
    public void test(){
    }
}
