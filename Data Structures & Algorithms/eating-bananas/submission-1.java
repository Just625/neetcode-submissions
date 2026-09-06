class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = piles[0];

        for (int i = 1; i < piles.length; i++) {
            max = Math.max(max, piles[i]);
        }

        // Because with k equal max, then time consumed for every pile would be 1
        // Anything  larger than k would not reduce time consumed because 1 is already the min time consumed
        int ans = max;
        // Binary search on 1 - max
        int left = 1;
        int right = max;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int timeConsumed = getTotalTime(mid, piles);

            if (timeConsumed <= h) {
                ans = Math.min(ans, mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }

    public int getTotalTime(int rate, int[] piles) {
        int total = 0;
        for (int p : piles) {
            total += p / rate;
            total += p % rate == 0 ? 0 : 1;
        }
        return total;
    }
}
