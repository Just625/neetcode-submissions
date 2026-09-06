class Solution {
    public int maxArea(int[] heights) {
        // Time O(n), Space O(1)
        int ans = 0;
        int l = 0, r = heights.length - 1;

        while (l < r) {
            int heightL = heights[l];
            int heightR = heights[r];
            ans = Math.max(ans, Math.abs(l - r) * Math.min(heightL, heightR));

            if (heightL == heightR) {
                l++;
                // r--;
            } else if (heightL < heightR) {
                l++;
            } else {
                r--;
            }
        }

        return ans;
    }
}
