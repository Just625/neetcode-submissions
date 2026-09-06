class Solution {
    public int search(int[] nums, int target) {
        // Brute-force: Loop nums until find the target
        // Time O(n), Space O(1)

        // Binary search: array is sorted in ascending order and all elements are unique, so we can compare target with the middle element
        // If equals return
        // Else if greater than search the right half
        // else search the left half
        // Continue until target is found or there is no element left
        int leftIdx = 0;
        int rightIdx = nums.length - 1;

        while (leftIdx <= rightIdx) {
            // (rightIdx + leftIdx) / 2
            int midIdx = leftIdx + (rightIdx - leftIdx) / 2;
            int currNumb = nums[midIdx];
            if (currNumb == target) {
                return midIdx;
            } else if (currNumb < target) {
                leftIdx = midIdx + 1;
            } else {
                rightIdx = midIdx - 1;
            }
        }

        return -1;
    }
}
