class Solution {
    public int longestConsecutive(int[] nums) {
        // nums.length >= 0
        int ans = 0;
        Set<Integer> seens = new HashSet<>();

        for (int num : nums) {
            seens.add(num);
        }

        // For every number in nums, check if Set contains the next number
        // If so, increase the count and keep checking until the next number does not appear
        for (int num : nums) {
            // Only start counting when current number is the start of a new sequence
            // which mean there is no 'num - 1' number exist in the arrays
            // Because it will only have less count and avoid repeated works
            if (seens.contains(num - 1)) continue;
            
            int count = 0;
            while (seens.contains(num)) {
                count++;
                num++;
            }
            ans = Math.max(ans, count);
        }

        return ans;
    }
}
