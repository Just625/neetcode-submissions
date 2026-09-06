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

        // The goal is to find the longest repeating substring (window) while using <= k replacements
        // We can choose any character that appears inside window and try to replace all other characters to make the window only contains a unique character
        // -> characters_need_to_be_changed = window_size - frequency_of_the_char_we_choose
        // We fixed the window size and when frequency_of_the_char_we_choose is the max frequency inside window then it appers to be the most optimal solution because we can get the minimum characters need to be changed (window_size - max_frequency)
        // If that optimal solution still greater than k, then no other solutions can be used
        // Therefore, window_size - max_frequency <= k is the condition to make a window valid
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
                maxFrequency = Collections.max(charFrequency.values());
                l++;
            }

            // The window is now valid, therefore we can check the size
            ans = Math.max(ans, r - l + 1);
        }

        return ans;
    }
}
