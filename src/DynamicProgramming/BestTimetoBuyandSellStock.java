package DynamicProgramming;

import java.util.Scanner;

public class BestTimetoBuyandSellStock {
    //Time Limit Exceeded
/*    public int maxProfit(int[] prices) {
        int len = prices.length, result = 0;
        int[][] profit = new int[len][len];
        for(int i = 0; i <len; i++){
            for(int j = i+1; j < len; j++){
                profit[i][j] = Math.max(profit[i][j-1], prices[j] - prices[i]);
            }
        }
        for(int i = 0; i < len; i++)
            result = result > profit[i][len-1]? result:profit[i][len-1];
        return result;
    }*/
//minbuyprice里记录的是最小的购买价格，profit[I]记录的是到目前位置最大的收益
    public int maxProfit(int[] prices) {
        if(prices.length == 0) return 0;
        int len = prices.length, minbuyprice = prices[0];
        int[] profit = new int[len];
        for(int i = 1; i < len; i++){
            profit[i] = Math.max(profit[i-1], prices[i] - minbuyprice);
            minbuyprice = minbuyprice < prices[i] ? minbuyprice : prices[i];
        }
        return profit[len-1];
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] prices = new int[len];
        for(int i = 0; i < len; i++)
            prices[i] = sc.nextInt();
        BestTimetoBuyandSellStock sl = new BestTimetoBuyandSellStock();
        sl.maxProfit(prices);
    }
}
