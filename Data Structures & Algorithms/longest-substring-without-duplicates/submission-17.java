class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) return s.length();

        int ans = 1;
        Set<Character> seen = new HashSet<>();
        int l = 0;
        int r = 0;
        while (r < s.length() && l <= r) {
            char c = s.charAt(r);
            if (seen.add(c)) {
                // If encounter new unique character, keep expanding window
                ans = Math.max(ans, seen.size());
            } else {
                // Shrink window until window no longer contain duplicate characters
                while (l < r && seen.contains(c)) {
                    seen.remove(s.charAt(l));
                    l++;
                }
                
                seen.add(c);
            }
            r++;
        }

        return ans;
    }
}