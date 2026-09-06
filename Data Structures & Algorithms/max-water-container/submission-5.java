class Solution {
    public int maxArea(int[] heights) {
        // Time O(n), Space O(1)
        // Area = (2nd height  - 1st height) * shorter height 
        // The height is limited by the shorter height between the two
        // => to increase the area, must move the shorter height inward (left pointer increase or right pointer decrease)
        // Moving the higher line never helps because its keeps the height the same but reduce width
        int ans = 0;
        int l = 0, r = heights.length - 1;

        while (l < r) {
            int heightL = heights[l];
            int heightR = heights[r];
            ans = Math.max(ans, (r - l) * Math.min(heightL, heightR));

            if (heightL == heightR) {
                // Move either one or move both still works
                // l++;
                r--;
            } else if (heightL < heightR) {
                l++;
            } else {
                r--;
            }
        }

        return ans;
    }
}
