class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // 1
        // int[] ans = new int[k];

        // // Count number frequency
        // Map<Integer, Integer> freq = new HashMap<>();

        // for (int num : nums) {
        //     freq.put(num, freq.getOrDefault(num, 0) + 1);
        // }

        // // Sort the frequency
        // List<Integer> freqList = new ArrayList<>();
        // for (Integer f : freq.values()) {
        //     freqList.add(f);
        // }
        // Collections.sort(freqList);
        
        // Set<Integer> usedNumber = new HashSet<>();
        // int size = freqList.size();
        // // Find the top-k element by getting from the end to the start of the list
        // for (int i = 0; i < k; i++) {
        //     int currFreq = freqList.get(size - 1 - i);

        //     // Find the corresponding number in map
        //     for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
        //         int number = entry.getKey();
        //         if (entry.getValue() == currFreq && !usedNumber.contains(number)) {
        //             ans[i] = number;
        //             usedNumber.add(number);
        //             break;
        //         }
        //     }
        // }

        // return ans;

        // 1.1
        int[] ans = new int[k];
        // Count number frequency: number-frequency (key-value)
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // Convert back to pairs [frequency-number] and put into a list
        List<Integer[]> freqNumberPairs = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            freqNumberPairs.add(new Integer[]{entry.getValue(), entry.getKey()});
        }

        // Sort the list in descending order
        Collections.sort(freqNumberPairs, (f1, f2) -> f2[0].compareTo(f1[0]));
        
        // Find the top-k element by getting from getting first-k elements
        for (int i = 0; i < k; i++) {
            ans[i] = freqNumberPairs.get(i)[1];
        }

        return ans;
    }
}
