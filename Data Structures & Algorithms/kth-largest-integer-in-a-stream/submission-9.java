class KthLargest {
    // Time O(m * nlogn), Space O(n + k)
    // where m is the number of times add() is called
    // n is the nums.length
    // int k;
    // List<Integer> list;
    // public KthLargest(int k, int[] nums) {
    //     this.k = k;
    //     this.list = new ArrayList<>();
    //     for (int n : nums) {
    //         list.add(n);
    //     }
    // }
    
    // public int add(int val) {
    //     this.list.add(val);
    //     this.list.sort(Integer::compareTo);
    //     int idx = this.list.size() - k;
    //     return this.list.get(idx);
    // }

    // By using min-heap with k size, the k-th element will always be at the top of the heap
    // For example: nums = [2,4,5,8], k = 3, heap = [4,5,8]
    // add 9 -> nums = [2,4,5,8,9], heap = [5,8,9] -> we can just get the first element of heap which is 5
    // What if we add 2 -> 2 < 5 (heap's peek) then we don't add it to the heap
    PriorityQueue<Integer> pq;
    int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        // List<Integer> list = Arrays.stream(nums)
        //                             .boxed()
        //                             .collect(Collectors.toList());
        // pq = new PriorityQueue<>(list);
        // while (pq.size() > k) {
        //     pq.poll();
        // }

        // Arrays.sort(nums);
        // pq = new PriorityQueue<>(k);
        // for (int i = nums.length - 1 ; i >= nums.length - k && i >= 0; i--) {
        //     pq.offer(nums[i]);
        // }

        // Because Integer is a Comparable, therefore it will sorted as natural order which is ascending
        pq = new PriorityQueue<>();
        for (int n : nums) {
            pq.offer(n);
            // if (pq.size() > k) {
            //     pq.poll();
            // }
        }
    }

    public int add(int val) {
        // if (pq.size() < this.k) {
        //     pq.offer(val);
        // } else if (val >= pq.peek()) {
        //     pq.poll();
        //     pq.offer(val);
        // }

        pq.offer(val);
        // if (pq.size() > k) {
        //     pq.poll();
        // }
        while (pq.size() > k) {
            pq.poll();
        }

        return pq.peek();
    }
}
