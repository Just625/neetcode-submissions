class Solution {
    public int characterReplacement(String s, int k) {
        // int ans = 0;
        // In each window, we can have the longest repeating character possible by replacing any characters that aren't the character with the highest frequency
        // Therefore, we need to keep track of the frequency of characters in window
        // A window is valid if we can replace any characters which aren't the char with the higest frequency with some number smaller or equal to k
        // -> window's size - max frequency <= k
        // Time O(n^2), Space O(n)
        // for (int i = 0; i < s.length(); i++) {
        //     Map<Character, Integer> charFrequency = new HashMap<>();
        //     int maxFrequency = 0;
        //     for (int j = i; j < s.length(); j++) {
        //         char c = s.charAt(j);
        //         // Update frequency
        //         charFrequency.put(c, charFrequency.getOrDefault(c, 0) + 1);
        //         // Update max frequency
        //         maxFrequency = Math.max(maxFrequency, charFrequency.get(c));

        //         // Check if window is valid
        //         int windowSize = j - i + 1;
        //         if (windowSize - maxFrequency <= k) {
        //             ans = Math.max(ans, windowSize);
        //         }
        //     }
        // }

        // return ans;


        int ans = 0;
        int maxFrequency = 0;
        Map<Character, Integer> charFrequency = new HashMap<>();
        int l = 0;

        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            charFrequency.put(c, charFrequency.getOrDefault(c, 0) + 1);
            maxFrequency = Math.max(maxFrequency, charFrequency.get(c));

            // Shrinking window until it is valid
            // int windowSize = r - l + 1;
            while (r - l + 1  - maxFrequency > k) {
                char charL = s.charAt(l);
                charFrequency.put(charL, charFrequency.get(charL) - 1);
                l++;
            }

            // The window is now valid, therefore we can check the size
            ans = Math.max(ans, r - l + 1);
        }

        return ans;
    }
}
