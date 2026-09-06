class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // Time O(n^2), Space O(1)
        // int[] ans = new int[2];
        // for (int i = 0; i < numbers.length; i++) {
        //     for (int j = i + 1; j < numbers.length; j++) {
        //         if (numbers[i] + numbers[j] == target) {
        //             // return 1-indexed
        //             ans[0] = i + 1;
        //             ans[1] = j + 1;
        //             return ans;
        //         }
        //     }
        // }

        // return ans;


        // Use two pointers: left pointers (one travels forward), right pointer (one travels backward)
        // If sum of both numbers = target, return two indexes
        // If sum < target -> need to increase -> therefore increase left pointers
        // If sum > target -> need to decrease -> therefore decrease right pointers
        // Time O(n), Space O(1)
        int[] ans = new int[2];
        int l = 0, r = numbers.length - 1;
        while (l < r) {
            int leftNumb = numbers[l];
            int rightNumb = numbers[r];
            int sum = leftNumb + rightNumb;
            if (sum == target) {
                // 1-indexed
                ans[0] = l + 1;
                ans[1] = r + 1;
                break;
            } else if (sum < target) {
                l++;
            } else {
                r--;
            }
        }

        return ans;
    }
}
