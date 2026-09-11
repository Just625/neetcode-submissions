class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] ans = new int[k][2];
        Map<Double, List<Integer>> distanceMap = new HashMap<>();

        for (int i = 0; i < points.length; i++) {
            int[] arr = points[i];
            int x = arr[0];
            int y = arr[1];
            distanceMap.computeIfAbsent(calculateDistance(x, y), e -> new ArrayList<>()).add(i);
        }

        List<Double> distances = new ArrayList<>(distanceMap.keySet());
        distances.sort(Double::compare);

        int i = 0;
        for (double distance : distances) {
            // if (k <= 0) break;
            List<Integer> indices = distanceMap.get(distance);
            System.out.println("indices:" + indices + ", i: " + i + ",k: " + k);
            // int size = indices.size();
            // if (size >= k) {
            //     for (int idx : indices) {
            //         ans[i] = points[idx];
            //         i++;
            //     }
            //     break;
            // } else {
            //     for (int j = 0; j < k; j++) {
            //         ans[i] = points[j];
            //         i++;
            //     }
            //     k = k - size;
            // }

            for (int idx : indices) {
                if (k <= 0) break;
                ans[i] = points[idx];
                i++;
                k--;
            }
        }
        return ans;
    }

    public double calculateDistance(int x, int y) {
        return Math.sqrt(x * x + y * y);
    }
}
