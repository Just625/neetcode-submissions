class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // strs[i] is made up of lowercase English letters.
        // => it can be presented using int[26]
        List<List<String>> answer = new ArrayList<>();
        int[][] strings = new int[strs.length][26];

        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            int[] asciiArr = new int[26];
            for (int j = 0; j < str.length(); j++) {
                asciiArr[str.charAt(j) - 'a'] += 1;
            }

            strings[i] = asciiArr;
        }

        Set<Integer> excludedIndex = new HashSet<>();

        for (int i = 0; i < strs.length; i++) {
            if (excludedIndex.contains(i)) continue;

            List<String> group = new ArrayList<>();
            group.add(strs[i]);
            excludedIndex.add(i);
            for (int j = i + 1; j < strs.length; j++) {
                if (Arrays.equals(strings[i], strings[j])) {
                    group.add(strs[j]);
                    excludedIndex.add(j);
                }
            }
            answer.add(group);
        }

        return answer;
    }
}
