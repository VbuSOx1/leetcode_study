package sword_offer;

import java.util.ArrayList;

/**
 * @author weib
 * @date 2021-12-13 20:08
 *  46. 把数字翻译成字符串
 * https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/
 */
public class No_46 {

    public int translateNum(int num) {
        String nums = "" + num;
        char[] numChars = nums.toCharArray();
        int[] dp = new int[numChars.length];
        return translateNum(numChars, numChars.length - 1, dp);
    }

    // 以numChars[n]为结尾的数字 有多少种翻译方法
    public int translateNum(char[] numChars, int n, int[] dp) {
        if (n == 0) {
            dp[0] = 1;
            return 1;
        }
        // 同上一个数字的和
        int sum = (numChars[n-1] - '0') * 10 + numChars[n] - '0';
        if (dp[n - 1] == 0) {
            dp[n - 1] = translateNum(numChars, n - 1, dp);
        }
        if (sum > 25 || numChars[n-1] == '0') {
            return dp[n-1];
        }
        if (n == 1) {
            dp[1] = 2;
            return 2;
        }
        return dp[n-1] + dp[n-2];

    }
}
