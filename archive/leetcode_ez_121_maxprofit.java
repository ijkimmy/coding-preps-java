
public class leetcode_ez_121_maxprofit {

    // 31m
    public int maxProfit(int[] prices) {
        int minprice = Integer.MAX_VALUE, maxprofit = 0;
        for(int i=0; i<prices.length; ++i){
            if(prices[i] < minprice)
                minprice = prices[i];
            else if(prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice;
        }
        return maxprofit;
    }
}
