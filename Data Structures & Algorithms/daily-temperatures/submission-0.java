class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            int curTemp = temperatures[i];
            for (int j = i + 1; j < len; j++) {
                if (temperatures[j] > curTemp) {
                    ans[i] = j - i;
                    break;
                }
            }
        }

        return ans;
    }
}
