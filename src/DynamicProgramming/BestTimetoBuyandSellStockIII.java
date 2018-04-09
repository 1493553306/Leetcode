package DynamicProgramming;
import java.util.Scanner;

public class BestTimetoBuyandSellStockIII {
    //超时，把prices分为左右两部分，每部分利用BestTimetoBuyandSellStock找最大收益，左右利益加起来求最大收益
    /*public int maxProfit(int[] prices) {
        if(prices.length == 0) return 0;
        int profit = 0, leftprofit = 0, rightprofit = 0;
        int leftbuy = prices[0], rightbuy;
        for(int i = 0; i < prices.length; i++){
            leftprofit = Math.max(leftprofit, prices[i]-leftbuy);
            leftbuy = Math.min(leftbuy, prices[i]);
            rightbuy = prices[i];
            for(int r = i; r < prices.length; r++){
                rightprofit = Math.max(rightprofit, prices[r]-rightbuy);
                rightbuy = Math.min(rightbuy, prices[r]);
            }
            profit = Math.max(profit, leftprofit+rightprofit);
            rightprofit = 0;
        }
    return profit;
    }*/
    //把prices分为左右两部分,分别求左右部分的最大收益，左右利益加起来求最大收益。
    //将数组price的相邻值相减（右边减左边）变换成数组b,左部分从头向尾统计最大收益，右部分从尾向头统计最大收益。
    public int maxProfit(int[] prices) {
        if(prices.length == 0 || prices.length ==1)  return 0;
        if(prices.length == 2) return Math.max(0, prices[1]-prices[0]);
        int len = prices.length, profit = 0, lefttmp = 0, righttmp = 0;
        int[] leftprofit = new int[len-1], rightprofit = new int[len-1];
        for(int i = 0; i <len-1; i++)
        {
            if(i == 0){
                leftprofit[0] = Math.max(prices[i+1]-prices[0],0);
                lefttmp = Math.max(prices[i+1] - prices[i],0);
            }
            else {
                lefttmp = Math.max(prices[i+1] - prices[i] + lefttmp, 0);
                leftprofit[i] = Math.max(leftprofit[i-1], lefttmp);
            }
        }
        for(int j = len-2; j >= 0; j--){
            if(j == len-2){
                rightprofit[j] = Math.max(prices[j+1]-prices[j],0);
                righttmp = Math.max(prices[j+1] - prices[j],0);
            }
            else {
                righttmp = Math.max(prices[j+1] -prices[j] + righttmp, 0);
                rightprofit[j] = Math.max(rightprofit[j+1], righttmp);
            }
        }
        for(int m = 0; m < len-2; m++)
            profit = Math.max(profit, leftprofit[m] + rightprofit[m+1]);
        return profit;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] prices = new int[len];
        BestTimetoBuyandSellStockIII sl = new BestTimetoBuyandSellStockIII();
        for(int i = 0; i < len; i++)
            prices[i] = sc.nextInt();
        sl.maxProfit(prices);
    }
}
