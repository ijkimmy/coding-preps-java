public class leetcode_md_122_maxprofit {

    // 22m
    public int maxProfit(int[] prices) {
        // linear scan, time: O(n), space: O(1)
        int min = prices[0], max = 0, profit = 0;
        for(int p: prices){
            if(p >= max) max = p;
            else {
                profit += max - min;
                max = min = p;
            }
        }
        return profit;
    }
}
