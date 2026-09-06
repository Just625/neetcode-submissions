class Solution {
    public int maxProfit(int[] prices) {
        int ans = 0;
        int l = 0;
        int r = 0;
        
        while (r < prices.length) {
            int profit = prices[r] - prices[l];
            ans = Math.max(ans, profit);
            // Update l when encounter smaller price
            if (profit <= 0) l = r;
            r++;
        }

        return ans;
    }
}
