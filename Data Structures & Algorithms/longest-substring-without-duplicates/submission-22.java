class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        Map<Character, Integer> seen = new HashMap<>();
        int l = 0;

        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            if (seen.containsKey(c)) {
                ans = Math.max(ans, r - l);
                // l can't go backward
                l = Math.max(l, seen.get(c) + 1);
            } 

            seen.put(c, r);
        }

        // ans = Math.max(ans, seen.size());
        ans = Math.max(ans, s.length() - l);

        return ans;
    }
}
