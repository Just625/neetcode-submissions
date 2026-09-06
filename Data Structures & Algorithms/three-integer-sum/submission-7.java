class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // Time O(n^3 + nlogn) ?, Space O(n)
        // int len = nums.length;
        // Set<String> seens = new HashSet<>();
        // List<List<Integer>> ans = new ArrayList<>();
        // for (int i = 0; i < len; i++) {
        //     for (int j = i + 1; j < len; j++) {
        //         for (int k = j + 1; k < len; k++) {
        //             if (nums[i] + nums[j] + nums[k] == 0) {
        //                 List<Integer> triplet = new ArrayList<>();
        //                 triplet.add(nums[i]);
        //                 triplet.add(nums[j]);
        //                 triplet.add(nums[k]);
        //                 Collections.sort(triplet);
        //                 String tripletID = triplet.get(0) + "-" + triplet.get(1) + "-" + triplet.get(2);
        //                 if (seens.add(tripletID)) {
        //                     ans.add(triplet);
        //                 }
        //             }
        //         }
        //     }
        // }

        // return ans;


        List<List<Integer>> ans = new ArrayList<>();
        int len = nums.length;
        Set<List<Integer>> seens = new HashSet<>();
        Arrays.sort(nums);
        System.out.println(nums[0]);
        for (int i = 0; i < len; i++) {
            int l = i + 1;
            int r = len - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[i]);
                    triplet.add(nums[l]);
                    triplet.add(nums[r]);
                    if (seens.add(triplet)) {
                        ans.add(triplet);
                    }
                    // l++;
                    r--;
                } else if (sum > 0) {
                    r--;
                } else {
                    l++;
                }
            }
        }
        return ans;
    }
}
