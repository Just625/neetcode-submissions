class Solution {

//     public String encode(List<String> strs) {
//         // Turn every character to their ASCII int values: 'a' -> 97
//         // Add 0 to the front if needed to form their string value of 3 characters: '097'
//         // Add '.' to mark the end of a string
//         StringBuilder sb = new StringBuilder();
//         for (int i = 0; i < strs.size(); i++) {
//             String str = strs.get(i);
//             for (int j = 0; j < str.length(); j++) {
//                 sb.append(convertCharToStrNumberFormat(str.charAt(j)));
//             }
//             sb.append(".");
//         }
//         return sb.toString();
//     }

//     public String convertCharToStrNumberFormat(char c) {
//         int number = c;
//         StringBuilder numberStr = new StringBuilder(3);
//         numberStr.append(number);
//         for (int i = numberStr.length(); i < 3; i++) {
//             numberStr.insert(0, "0");
//         }
//         return numberStr.toString();
//     }

//     public List<String> decode(String str) {
//         List<String> ans = new ArrayList<>();
//         // Split into array of strings by '.'
//         // Convert every character into int and to char
//         // Append to form a string
//         // Don't use split because if the last word is empty then it is removed
// //        String[] strs = str.split("\\.");
// //        for (String word : strs) {
// //            int i = 0;
// //            StringBuilder sb = new StringBuilder();
// //            while (i < word.length()) {
// //                char c = convertStrNumberFormatToChar(word.substring(i, i + 3));
// //                sb.append(c);
// //                i += 3;
// //            }
// //            ans.add(sb.toString());
// //        }
// //        return ans;

//         // Don't use split because if the last word is empty then it is removed
//         StringBuilder sb = new StringBuilder();
//         for (char c : str.toCharArray()) {
//             // End of a word
//             if (c == '.') {
//                 int i = 0;
//                 StringBuilder wordSB = new StringBuilder();
//                 while (i < sb.length()) {
//                     char character = convertStrNumberFormatToChar(sb.substring(i, i + 3));
//                     wordSB.append(character);
//                     i += 3;
//                 }
//                 ans.add(wordSB.toString());
//                 // Reuse sb
//                 sb.setLength(0);
//             } else {
//                 sb.append(c);
//             }
//         }
        
//         return ans;
//     }

//     public char convertStrNumberFormatToChar(String str) {
//         return (char)Integer.parseInt(str);
//     }

    // Second solution: Encode using this format: length.string
    // Where length of the length of string, string is the actual string it self
    // '.' is just a separation character between length and the string content
    // Therefore, when decoding, we just need to read until encounter '.' and we will substring amount of length characters
    // to get the original string

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str.length())
                .append(".")
                .append(str);
        }
        return sb.toString();
    }
    
    public List<String> decode(String str) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int i = 0; 
        int j = 0;
        while (i < str.length()) {
            char c = str.charAt(j);
            if (c == '.') {
                String lengthStr = str.substring(i, j);
                int length = Integer.parseInt(lengthStr);
                // Move i to the start of the word, pass through "."
                i = j + 1;
                ans.add(str.substring(i, i + length));
                // Move i and j to the start of new length
                i = i + length;
                j = i;
            } else {
                j++;
            }
        }

        return ans;
    }
}
