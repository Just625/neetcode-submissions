class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // Time O(n^2), Space O(n)
        // int len = temperatures.length;
        // int[] ans = new int[len];
        // for (int i = 0; i < len; i++) {
        //     int curTemp = temperatures[i];
        //     for (int j = i + 1; j < len; j++) {
        //         if (temperatures[j] > curTemp) {
        //             ans[i] = j - i;
        //             break;
        //         }
        //     }
        // }

        // return ans;


        // Use a stack to hold temperatures index.
        // If stack is not empty and top of the stack is less than to current temperatures -> we found the higher temperature for it
        // => pop the stack until condition is not meet
        // Push the current temperature to the stack until we found higher temperature
        // This way, every temp go into stack and got out at most one

        Deque<Integer> stack = new ArrayDeque<>();
        int len = temperatures.length;
        int[] ans = new int[len];

        for (int i = 0; i < temperatures.length; i++) {
            int currNumb = temperatures[i];

            while (!stack.isEmpty() && temperatures[stack.peek()] < currNumb) {
                ans[stack.peek()] = i - stack.pop();
            }

            stack.push(i);
        }

        return ans;
    }
}
