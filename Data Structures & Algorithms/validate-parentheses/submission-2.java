class Solution {
    public boolean isValid(String s) {
        Deque<Character> openBrackets = new LinkedList<>();
        Map<Character, Character> bracketMap = Map.ofEntries(
            Map.entry(')', '('),
            Map.entry('}', '{'),
            Map.entry(']', '[')
        );

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                openBrackets.push(c);
                continue;
            }

            if (openBrackets.peek() != bracketMap.get(c)) {
                return false;
            }

            openBrackets.pop();
        }
        
        return openBrackets.isEmpty();
    }
}
