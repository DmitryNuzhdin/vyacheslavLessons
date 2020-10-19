package leetcode.BuyAndSellStock;

public class Solution {
    public static int maxProfit(int[] prices){
        int maxProfit = 0;
        int newProfit;
        if (prices.length < 1) {
            return 0;
        }
        int oldPrice = prices[0];
        for (int currentPrice: prices) {
            newProfit = currentPrice - oldPrice;
            maxProfit = Math.max(maxProfit, newProfit);
            if (currentPrice < oldPrice)
                oldPrice = currentPrice;
        }
        return maxProfit;
    }
    public static void main(String[] args){
        int[] prices1 = {1,2,3,4,5,6};
        int result = maxProfit(prices1);
        System.out.println("My array 1, answer must be 5");
        System.out.println(result);

        int[] prices2 = {2,1,3,4,5,6};
        result = maxProfit(prices2);
        System.out.println("My array 2, answer must be 5");
        System.out.println(result);

        int[] prices3 = {2};
        result = maxProfit(prices3);
        System.out.println("Array with one element");
        System.out.println(result);


        int[] prices4 = {};
        result = maxProfit(prices4);
        System.out.println("Empty array");
        System.out.println(result);


        int[] prices5 = {7,1,5,3,6,4};
        result = maxProfit(prices5);
        System.out.println("From litecode 1, answer must be 5");
        System.out.println(result);

        int[] prices6 = {7,6,4,3,1};
        result = maxProfit(prices6);
        System.out.println("From litecode 2, answer must be 0");
        System.out.println(result);
    }
}
