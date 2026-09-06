class Solution {
    public int findMin(int[] nums) {
        // brute force
        int min = nums[0];
        for(int n : nums) {
            min = Math.min(min, n);
        }

        return min;
    }
}
