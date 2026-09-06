class Solution {
    public boolean isAnagram(String s, String t) {
        // Two strings must have the same length
        if (s.length() != t.length()) return false;

        // Count frequency of each characters in each strings to compare later
        Map<Character, Integer> frequencyS = new HashMap<>();
        Map<Character, Integer> frequencyT = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            frequencyS.put(s.charAt(i), frequencyS.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            frequencyT.put(t.charAt(i), frequencyT.getOrDefault(t.charAt(i), 0) + 1);
        }

        return frequencyS.equals(frequencyT);
    }
}
