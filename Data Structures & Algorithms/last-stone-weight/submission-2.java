class Solution {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));

        for (int s : stones) {
            pq.offer(s);
        }

        while (pq.size() >= 2) {
            int firstStone = pq.poll();
            int secondStone = pq.poll();

            if (firstStone != secondStone) {
                // pq.offer(Math.abs(firstStone - secondStone));
                // No need to use Math.abs since firstStone will always be greater or equal to the second stone (thanks to max-heap)
                pq.offer(firstStone - secondStone);
            }
        }

        return pq.isEmpty() ? 0 : pq.poll();
    }
}
