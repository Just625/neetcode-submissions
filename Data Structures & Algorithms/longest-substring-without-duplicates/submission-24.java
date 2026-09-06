class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        int l = 0;
        Set<Character> seens = new HashSet<>();

        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);

            // Shrink window if it contains duplicate characters
            while (seens.contains(c)) {
                seens.remove(s.charAt(l));
                l++;
            }

            seens.add(c);
            ans = Math.max(ans, r - l + 1);
        }

        return ans;

        // Time O(n), Space O(n)
        // int ans = 0;
        // Map<Character, Integer> seen = new HashMap<>();
        // int l = 0;

        // for (int r = 0; r < s.length(); r++) {
        //     char c = s.charAt(r);
        //     if (seen.containsKey(c)) {
        //         ans = Math.max(ans, r - l);
        //         // l can't go backward
        //         l = Math.max(l, seen.get(c) + 1);
        //     } 

        //     seen.put(c, r);
        // }

        // ans = Math.max(ans, s.length() - l);
        // return ans;
    }
}
