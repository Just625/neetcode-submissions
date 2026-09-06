class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Brute-force: nested loops: i and j = i + 1.
        // Calculate sum of each and return equals to target
        // -> Time O(n^2), Space O(1)


        // use a map to store key: difference between each number in nums and target, value: index
        // if difference is found, return index pairs
        // else put it into map
        // Retrieve operation with map only took O(1)
        // -> Time O(n), Space O(n)
        Map<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int difference = target - num;
            if (map.containsKey(difference)) {
                ans[0] = map.get(difference);
                ans[1] = i;
            } else {
                map.put(num, i);
            }
        }

        return ans;
    }
}
