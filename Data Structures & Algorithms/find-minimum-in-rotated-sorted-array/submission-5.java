class Solution {
    public int findMin(int[] nums) {
        // brute force
        // int min = nums[0];
        // for(int n : nums) {
        //     min = Math.min(min, n);
        // }

        // return min;

        // Array can be sorted correctly if leftmost number < middle number < rightmost number
        // Or if only leftmost number < middle number or only middle number < rightmost number (two separate sorted arrays)
        int ans = nums[0];
        int left = 0, right = nums.length - 1;
        while(left <= right) {
            if (nums[left] < nums[right]) {
                ans = Math.min(ans, nums[left]);
                break;
            }

            int middle = left + (right - left) / 2;
            ans = Math.min(ans, nums[middle]);
            if (nums[middle] >= nums[left]) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        return ans;
    }
}
