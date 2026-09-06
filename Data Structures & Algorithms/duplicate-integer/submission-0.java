class Solution {
    public boolean hasDuplicate(int[] nums) {
        // Time O(n^2), Space O(1)
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) return true;
            }
        }

        return false;
    }
}