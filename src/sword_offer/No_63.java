package sword_offer;

/**
 * @author weib
 * @date 2021-12-09 15:20
 * 股票的最大利润
 * https://leetcode-cn.com/problems/gu-piao-de-zui-da-li-run-lcof/
 */
public class No_63 {
    public int maxProfit(int[] prices) {
        if (prices.length == 0){
            return 0;
        }
        int gain_min = Integer.MAX_VALUE;
        int gain_max = 0;
        int cur_min = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++){
            int price = prices[i];
            if (cur_min > price) {
                cur_min = price;
            }
            // 新区间
            if ((price - cur_min) > gain_max - gain_min ){
                gain_min = cur_min;
                gain_max = price;
            }
            // 扩充区间
            if (gain_max < price){
                gain_max = price;
            }
        }
        return gain_max - gain_min;
    }
}
