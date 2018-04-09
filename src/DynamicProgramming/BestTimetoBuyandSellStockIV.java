package DynamicProgramming;
import java.util.Scanner;

public class BestTimetoBuyandSellStockIV {
    // 不太理解
    // 我们定义local[i][j]为在到达第i天时最多可进行j次交易并且最后一次交易在最后一天卖出的最大利润，此为局部最优。
    // 然后我们定义global[i][j]为在到达第i天时最多可进行j次交易的最大利润，此为全局最优。
   public int maxProfit(int k, int[] prices) {
        int len = prices.length, profit, diff;
        if(k > len/2)
        {
            /*BestTimetoBuyandSellStockII sl = new BestTimetoBuyandSellStockII();
            profit = sl.maxProfit(prices);*/
            profit = help(prices);
            return profit;
        }
       int[][] local = new int[k+1][len], global = new int[k+1][len];
        for(int i = 1; i <= k; i++){
            for(int j = 1; j <len; j++){
                diff = prices[j] - prices[j-1];
                local[i][j] = Math.max(global[i-1][j-1]+Math.max(diff,0), local[i][j-1]+diff);
                global[i][j] = Math.max(global[i][j-1],local[i][j]);
            }
        }
        return global[k][len-1];
    }

       public int help(int[] prices) {
        int profit = 0;
        for(int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i-1])
                profit += prices[i] - prices[i-1];
        }
        return profit;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int k = sc.nextInt();
        int[] prices = new int[len];
        BestTimetoBuyandSellStockIV sl = new BestTimetoBuyandSellStockIV();
        for(int i = 0; i < len; i++)
            prices[i] = sc.nextInt();
        sl.maxProfit(k, prices);
    }
}
