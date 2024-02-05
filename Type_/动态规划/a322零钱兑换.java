package Type_.动态规划;

import java.util.Arrays;

/**
 * 322. 零钱兑换
 * https://leetcode.cn/problems/coin-change/
 */
public class a322零钱兑换 {


    /**
     * 动态规划
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        //memo[i]表示凑齐金额i所需的最少硬币数为memo[i]
        int[] memo = new int[amount + 1];
        Arrays.fill(memo, amount + 1);


        //base case
        memo[0] = 0;
        for (int i = 0; i < memo.length; i++) {
            for (int coin : coins) {
                if (i >= coin) {
                    memo[i] = Math.min(memo[i], memo[i - coin] + 1);
                }
            }
        }
        return memo[amount] == amount + 1? -1 : memo[amount];
    }
}
