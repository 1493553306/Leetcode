package DynamicProgramming;
import java.util.Scanner;
//数组相邻元素相减，只要大于0就说明有利润，就可以交易。
public class BestTimetoBuyandSellStockII {
    public int maxProfit(int[] prices) {
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
        int[] prices = new int[len];
        for(int i = 0; i <len; i++)
            prices[i] = sc.nextInt();
        BestTimetoBuyandSellStockII sl = new BestTimetoBuyandSellStockII();
        sl.maxProfit(prices);
    }
}
