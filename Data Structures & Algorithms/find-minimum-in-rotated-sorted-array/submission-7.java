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
        // So if middle is in the left sorted array, and because when the array is rotated, the right most elements will be at the front, therefore every elements from the left array will be larger than the right array
        // For example: [1,2,3,4,5] -> [3,4,5,1,2] -> search the right 
        // If middle is in the right sorted array, then every elements on the right side will be larger than middle -> so we search left
        int min = nums[0];
        int left = 0, right = nums.length - 1;

        while (left < right) {
            // The array is already sorted (rotated 0 or n times)
            if (nums[left] < nums[right]) {
                return nums[left];
            }

            int middle = left + (right - left) / 2;
            // Because left can be the middle
            if (nums[left] <= nums[middle]) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }

        return nums[left];
    }
}
