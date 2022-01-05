package sword_offer;

/**
 * @author weib
 * @date 2022-01-05 10:51
 * 17 . 打印从1到最大的n位数
 * https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/
 */
public class No_17 {
    public int[] printNumbers(int n) {
        int max = 0;
        while(n-- > 0) {
            max = max*10 + 9;
        }
        int[] result = new int[max];
        for (int i = 0; i < max ; i++) {
            result[i] = i+1;
        }
        return result;
    }
}
