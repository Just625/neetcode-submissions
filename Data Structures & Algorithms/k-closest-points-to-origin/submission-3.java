class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // int[][] ans = new int[k][2];
        // Map<Double, List<Integer>> distanceMap = new HashMap<>();

        // for (int i = 0; i < points.length; i++) {
        //     int[] arr = points[i];
        //     int x = arr[0];
        //     int y = arr[1];
        //     distanceMap.computeIfAbsent(calculateDistance(x, y), e -> new ArrayList<>()).add(i);
        // }

        // List<Double> distances = new ArrayList<>(distanceMap.keySet());
        // distances.sort(Double::compare);

        // int i = 0;
        // for (double distance : distances) {
        //     List<Integer> indices = distanceMap.get(distance);
        //     // System.out.println("indices:" + indices + ", i: " + i + ",k: " + k);
        //     for (int idx : indices) {
        //         if (k <= 0) break;
        //         ans[i] = points[idx];
        //         i++;
        //         k--;
        //     }
        // }
        // return ans;


        // int[][] ans = new int[k][2];
        // Queue<int[]> minHeap = new PriorityQueue<>((a, b) -> Double.compare(calculateDistance(a[0], a[1]), calculateDistance(b[0], b[1])));

        // for (int[] point : points) {
        //     minHeap.offer(point);
        // }

        // int i = 0;
        // while (!minHeap.isEmpty() && i < k) {
        //     ans[i] = minHeap.poll();
        //     i++;
        // }

        // return ans;

        int[][] ans = new int[k][2];
        Queue<int[]> maxHeap = new PriorityQueue<>((a, b) -> Double.compare(calculateDistance(b[0], b[1]), calculateDistance(a[0], a[1])));

        for (int[] point : points) {
            maxHeap.offer(point);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        int i = 0;
        while (!maxHeap.isEmpty()) {
            ans[i] = maxHeap.poll();
            i++;
        }

        return ans;
    }

    public double calculateDistance(int x, int y) {
        return Math.sqrt(x * x + y * y);
    }
}
