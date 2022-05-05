package hot_100;

import java.util.HashMap;

/**
 * @author weib
 * @date 2022-05-05 11:47
 * 322. 零钱兑换
 * https://leetcode-cn.com/problems/coin-change/
 * 动态规划
 */
public class No_322_coin_change {


    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        HashMap<Integer, Integer> dp = new HashMap<Integer, Integer>();
        return coinChange(coins, amount, dp);

    }


    public int coinChange(int[] coins, int amount, HashMap<Integer, Integer> dp) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        if (dp.get(amount) != null) {
            return dp.get(amount);
        }
        int least = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int f = coinChange(coins, amount - coins[i], dp);
            if (f < 0) {
                continue;
            }
            least = f < least ? f : least;
        }
        least = least == Integer.MAX_VALUE ? -1 : least+1;
        dp.put(amount, least);
        return least;
    }
}
