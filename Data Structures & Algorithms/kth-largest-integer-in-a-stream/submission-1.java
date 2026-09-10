class KthLargest {
    int k;
    List<Integer> list;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.list = new ArrayList<>();
        for (int n : nums) {
            list.add(n);
        }
    }
    
    public int add(int val) {
        this.list.add(val);
        this.list.sort(Integer::compareTo);
        int removeIdx = this.list.size() - k;
        return this.list.get(removeIdx);
    }
}
