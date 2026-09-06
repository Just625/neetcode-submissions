class Solution {
    public int[] productExceptSelf(int[] nums) {
        // 1. Get multiply of all values in nums, then at each index, just divide by the nums[i]
        // Special cases handle:
        //     if there is only 1 zero in nums, then exclude it 
        //     If there is more than 1 zero, then return int arrays with full of zero
        // Also handle case where first element is zero
        // Time O(n + n) = O(n), Space O(n)
        // int zeroCnt = 0;
        // int zeroIdx = -1;
        // int products = nums[0];
        // int[] ans = new int[nums.length];
        // if (nums[0] == 0) {
        //     zeroCnt++;
        //     zeroIdx = 0;
        //     if (nums[1] == 0) return ans;
        //     else products = nums[1];
        // } else {
        //     if (nums[1] == 0) {
        //         zeroCnt++;
        //         zeroIdx = 1;
        //     } else {
        //         products *= nums[1];
        //     }
        // }

        // for (int i = 2; i < nums.length; i++) {
        //     int num = nums[i];
        //     if (num == 0) {
        //         zeroCnt++;
        //         zeroIdx = i;
        //         if (zeroCnt > 1) return ans;
        //     } else {
        //         products *= num;
        //     }
        // }

        // if (zeroCnt == 1) {
        //     ans[zeroIdx] = products;
        //     return ans;
        // }

        // for (int i = 0; i < nums.length; i++) {
        //     ans[i] = products / nums[i];
        // }

        // return ans;

        // 1.1. Init products in order to avoid manually handling first and second elements
        // Because 1 x any number = that number
        int zeroCnt = 0;
        int products = 1;
        int len = nums.length;
        int[] ans = new int[len];

        for (int num : nums) {
            if (num == 0) {
                zeroCnt++;
            } else {
                products *= num;
            }
        }

        if (zeroCnt > 1) {
            return ans;
        }

        for (int i = 0; i < len; i++) {
            int num = nums[i];
            if (zeroCnt == 1) {
                if (num == 0) {
                    ans[i] = products;
                    break;
                }
            } else {
                ans[i] = products / num;
            }
        }

        return ans;
    }
}  
