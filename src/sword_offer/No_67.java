package sword_offer;

/**
 * @author weib
 * @date 2021-12-29 16:48
 * 67. 把字符串转换成整数
 * https://leetcode-cn.com/problems/ba-zi-fu-chuan-zhuan-huan-cheng-zheng-shu-lcof/
 */
public class No_67 {
    public int strToInt(String s) {
        int length = s.length();
        int num[] = new int[32];
        int numIndex = 0;
        boolean start = false;
        long result = 0;
        // 1正 -1负
        int sign = 1;
        for(int i = 0; i < length; i++){
            char cur = s.charAt(i);
            if(start && isNumber(cur)){
                result *= 10;
                result += cur - '0';
                if(result > Integer.MAX_VALUE){
                    if(sign == -1) {
                        return Integer.MIN_VALUE;
                    }
                    return Integer.MAX_VALUE;
                }
            }
            if(start && !isNumber(cur)){
                break;
            }
            if(!start && cur == ' '){
                continue;
            }
            if(!start && cur == '-' ){
                sign = -1;
                start = true;
                continue;
            }
            if(!start && cur == '+'){
                start = true;
                continue;
            }
            if(!start && isNumber(cur)){
                start = true;
                result = cur - '0';
                continue;
            }
            if(!start && !isNumber(cur)){
                return 0;
            }

        }
        return (int) (sign * result);
    }
    boolean isNumber(char c){
        if(c < '0' || c > '9'){
            return false;
        }
        return true;
    }
}
