import java.util.Arrays;

/**
 * @author zhujiaxi01
 * @date 2022-06-02 13:54
 */
public class Day0602coinChange {
    static int res = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int[] coins = new int[]{1,2,5};
        System.out.println(coinChange(coins,11));
    }

//    public static int coinChange1(int[] coins, int amount) {
//        int[] dp = new int[amount + 1];
//
//        Arrays.fill(dp,amount + 1);
//        dp[0] = 0;
//        for (int i = 1; i <= amount; i++) {
//            for (int j = 0; j < coins.length; j++) {
//
//            }
//        }
//    }



    public static int coinChange(int[] coins, int amount) {
        helper(coins,amount,0);
        return res;


    }
    private static void helper(int[] coins, int amount,int index) {
        if (amount == 0) {
            res = Math.min(res,index);
        }
        if (amount < 0) {
            return;
        }
        for (int i = 0; i < coins.length; i++) {
            helper(coins,amount - coins[i],index + 1);
        }
    }
}
