class Solution {
    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i <= j) {
            char increaseChar = s.charAt(i);
            char decreaseChar = s.charAt(j);
            if (!isAlphanumericCharacters(increaseChar)) {
                i++;
                continue;
            }
            if (!isAlphanumericCharacters(decreaseChar)) {
                j--;
                continue;
            }

            if (Character.toLowerCase(increaseChar) != Character.toLowerCase(decreaseChar)) {
                System.out.println("increaseChar: " + increaseChar + ", decreaseChar: " + decreaseChar);
                return false;
            }

            i++;
            j--;
        }

        return true;
    }

    public boolean isAlphanumericCharacters(char c) {
        if (
            ('0' <= c && c <= '9')
            || ('A' <= c && c <= 'Z')
            || ('a' <= c && c <= 'z')
        ) {
            return true;
        }

        return false;
    }
}
