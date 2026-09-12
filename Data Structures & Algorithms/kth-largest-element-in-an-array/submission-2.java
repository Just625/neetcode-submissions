class Solution {
    public int findKthLargest(int[] nums, int k) {
        // Time O(nlogn), Space O(1)
        // Arrays.sort(nums);
        // return nums[nums.length - k];
        

        // Time O(nlogn + k), Space O(k)
        // Queue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        // for (int n : nums) {
        //     maxHeap.offer(n);
        // }

        // int ans = 0;
        // while (k > 0) {
        //     ans = maxHeap.poll();
        //     k--;
        // }

        // return ans;


        // Time O(nlogk), Space O(k)
        Queue<Integer> minHeap = new PriorityQueue<>();
        for (int n : nums) {
            minHeap.offer(n);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        return minHeap.poll();
    }
}
