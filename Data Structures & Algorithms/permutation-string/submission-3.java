class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        
        // Time O(n), Space O(1)
        // Only lower case letters are in s1 and s2
        int[] s1Freq = new int[26];
        for (char c : s1.toCharArray()) {
            s1Freq[c - 'a']++;
        }

        // Keep a window of size s1, compare two frequency array.
        // If not the same length, continue expanding window.
        // Return true if match, else shrink window
        // return false at the end if no match
        int[] windowFreq = new int[26];
        int l = 0;
        int r = 0;

        while (r < s2.length()) {
            char c = s2.charAt(r);
            windowFreq[c - 'a']++;
            r++;

            // Continue expand window if its length is less than s1
            // window's size = r - l 
            if ((r - l) < s1.length()) continue;

            if (Arrays.equals(s1Freq, windowFreq)) return true;

            // Shrink window
            windowFreq[s2.charAt(l) - 'a']--;
            l++;
        }

        return false;
    }
}
