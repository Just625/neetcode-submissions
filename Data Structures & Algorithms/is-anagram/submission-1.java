class Solution {
    public boolean isAnagram(String s, String t) {
        // // Two strings must have the same length
        // if (s.length() != t.length()) return false;

        // // Count frequency of each characters in each strings to compare later
        // Map<Character, Integer> frequencyS = new HashMap<>();
        // Map<Character, Integer> frequencyT = new HashMap<>();

        // for (int i = 0; i < s.length(); i++) {
        //     frequencyS.put(s.charAt(i), frequencyS.getOrDefault(s.charAt(i), 0) + 1);
        // }

        // for (int i = 0; i < t.length(); i++) {
        //     frequencyT.put(t.charAt(i), frequencyT.getOrDefault(t.charAt(i), 0) + 1);
        // }

        // // Can use equals directly because equals compare two maps's key and value
        // // Character and Integer in Java override equals and hashCode already
        // return frequencyS.equals(frequencyT);

        // Two strings only contain lower-case English letters -> maximum 26 characters
        // We can use array in place of Map
        int[] frequencyS = new int[26];
        int[] frequencyT = new int[26];

        for (int i = 0; i < s.length(); i++) {
            frequencyS[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            frequencyT[t.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (frequencyS[i] != frequencyT[i]) return false;
        }

        return true;
    }
}
