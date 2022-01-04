package sword_offer;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author weib
 * @date 2022-01-04 15:55
 * Offer 49. 丑数
 * https://leetcode-cn.com/problems/chou-shu-lcof/
 *
 * 自己写的太麻烦了 看别人的代码
 *
 */
public class No_49 {


    public int nthUglyNumber(int n) {
        if (n == 1) {
            return 1;
        }
        long[] choushu = new long [3380];
        int num = 0;
        int index = 0;
        choushu[0] = 1;
        while (num < (n-1)*2) {
            num += insertAndsort(choushu, choushu[index]*2, num);
            num += insertAndsort(choushu, choushu[index]*3, num);
            num += insertAndsort(choushu, choushu[index]*5, num);
            index++;
        }
        return (int)choushu[n-1];
    }

    // 插排
    public int insertAndsort(long[] choushu, long num, int endIndex) {
        if (Arrays.binarySearch(choushu,0, endIndex, num) >= 0) {
            return 0;
        }
        int index = endIndex;
        while (choushu[index] > num){
            index--;
        }
        int moveNum = endIndex - index;
        while(moveNum-- > 0){
            choushu[endIndex + 1] = choushu[endIndex];
            endIndex--;
        }
        choushu[index+1] = num;
        return 1;
    }

    // 別人的代碼 短 并且功能是一样的
    public int nthUglyNumber2(int n) {
        int a = 0, b = 0, c = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for(int i = 1; i < n; i++) {
            int n2 = dp[a] * 2, n3 = dp[b] * 3, n5 = dp[c] * 5;
            dp[i] = Math.min(Math.min(n2, n3), n5);
            if(dp[i] == n2) a++;
            if(dp[i] == n3) b++;
            if(dp[i] == n5) c++;
        }
        return dp[n - 1];
    }



    @Test
    public void test(){
        System.out.println(nthUglyNumber(999));
    }

}
