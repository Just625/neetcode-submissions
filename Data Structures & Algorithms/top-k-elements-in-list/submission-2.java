class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] ans = new int[k];

        // Count number frequency
        Map<Integer, Integer> freq = new HashMap<>();

        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        System.out.println(freq);

        // Sort the frequency
        List<Integer> freqList = new ArrayList<>();
        for (Integer f : freq.values()) {
            freqList.add(f);
        }
        Collections.sort(freqList);
        
        Set<Integer> usedNumber = new HashSet<>();

        int size = freqList.size();
        for (int i = 0; i < k; i++) {
            int currFreq = freqList.get(size - 1 - i);

            // Find the corresponding number in map
            for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
                int number = entry.getKey();
                if (entry.getValue() == currFreq && !usedNumber.contains(number)) {
                    ans[i] = number;
                    usedNumber.add(number);
                    break;
                }
            }
        }

        return ans;
    }
}
