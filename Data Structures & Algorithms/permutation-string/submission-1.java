class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        
        // Only lower case letters are in s1 and s2
        int[] s1F = new int[26];
        for (char c : s1.toCharArray()) {
            s1F[c - 'a']++;
        }

        // Keep a window of size s1, compare two frequency array.
        // If not the same length, continue expanding window.
        // Return true if match, else shrink window
        // return false at the end if no match
        int[] s2F = new int[26];
        int l = 0;
        int r = 0;
        int s2FLen = 0;

        while (r < s2.length()) {
            char c = s2.charAt(r);
            s2F[c - 'a']++;
            r++;
            s2FLen++;

            // Continue expand window if its length is less than s1
            if (s2FLen < s1.length()) continue;

            if (Arrays.compare(s1F, s2F) == 0) return true;

            // Shrink window
            s2F[s2.charAt(l) - 'a']--;
            l++;
            s2FLen--;
        }

        return false;
    }
}
