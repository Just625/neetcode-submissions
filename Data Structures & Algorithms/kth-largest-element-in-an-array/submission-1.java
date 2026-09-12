class Solution {
    public int findKthLargest(int[] nums, int k) {
        // Time O(nlogn), Space O(1)
        // Arrays.sort(nums);
        // return nums[nums.length - k];
        

        Queue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int n : nums) {
            maxHeap.offer(n);
            // System.out.println(maxHeap);
            // if (maxHeap.size() > k) {
            //     maxHeap.poll();
            // }
        }

        int ans = 0;
        while (k > 0) {
            ans = maxHeap.poll();
            k--;
        }

        return ans;
    }
}
