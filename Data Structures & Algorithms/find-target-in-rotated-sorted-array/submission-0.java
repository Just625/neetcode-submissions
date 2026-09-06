class Solution {
    public int search(int[] nums, int target) {
        int ans = -1;
        for (int i = 0; i < nums.length; i++) {
                        if (target == nums[i]) {
                            ans =i;
                            break;
                        }
        }

        return ans;
    }
}
