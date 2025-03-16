class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int buyOnPrice = 0;
        int maxProfit = 0;
        int startIndex = 0;

        for(int endIndex = 0; endIndex<n ; endIndex++){
            buyOnPrice = prices[startIndex];
            if(startIndex < endIndex){
                maxProfit = Math.max(maxProfit, prices[endIndex] - buyOnPrice);
            }
            while(prices[endIndex] < prices[startIndex]){
                startIndex++;
            }
        }
        return maxProfit;
    }
}