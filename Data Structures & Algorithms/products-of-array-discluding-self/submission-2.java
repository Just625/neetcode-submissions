class Solution {
    public int[] productExceptSelf(int[] nums) {
        // Get multiply of all values in nums, then at each index, just divide by the nums[i]
        // Special cases handle:
        //     if there is only 1 zero in nums, then exclude it 
        //     If there is more than 1 zero, then return int arrays with full of zero
        int zeroCnt = 0;
        int zeroIdx = -1;
        int products = nums[0];
        int[] ans = new int[nums.length];
        if (nums[0] == 0) {
            zeroCnt++;
            zeroIdx = 0;
            if (nums[1] == 0) return ans;
            else products = nums[1];
        } else {
            if (nums[1] == 0) {
                zeroCnt++;
                zeroIdx = 1;
            } else {
                products *= nums[1];
            }
        }

        for (int i = 2; i < nums.length; i++) {
            int num = nums[i];
            if (num == 0) {
                zeroCnt++;
                zeroIdx = i;
                if (zeroCnt > 1) return ans;
            } else {
                products *= num;
            }
        }

        if (zeroCnt == 1) {
            ans[zeroIdx] = products;
            return ans;
        }

        for (int i = 0; i < nums.length; i++) {
            ans[i] = products / nums[i];
        }

        return ans;
    }
}  
