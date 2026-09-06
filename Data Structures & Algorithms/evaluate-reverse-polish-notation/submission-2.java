class Solution {
    public int evalRPN(String[] tokens) {
        // Time O(n), Space O()
        Deque<Integer> stack = new ArrayDeque<>();
        int ans = 0;
        for (String c : tokens) {
            if (!c.equals("+") && !c.equals("-") && !c.equals("*") && !c.equals("/")) {
                stack.push(Integer.valueOf(c));
                continue;
            }

            int secondNumb = stack.pop();
            int firstNumb = stack.pop();
            ans = switch(c) {
                case "+" -> firstNumb + secondNumb;
                case "-" -> firstNumb - secondNumb;
                case "*" -> firstNumb * secondNumb;
                default -> firstNumb / secondNumb;
            };

            stack.push(ans);
        }

        return stack.pop();
    }
}
