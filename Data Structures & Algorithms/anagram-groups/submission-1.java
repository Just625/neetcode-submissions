class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // strs[i] is made up of lowercase English letters.
        // => it can be presented using int[26]
        // Time O(n^2), Space O(n)
        // List<List<String>> answer = new ArrayList<>();
        // int[][] strings = new int[strs.length][26];

        // for (int i = 0; i < strs.length; i++) {
        //     String str = strs[i];
        //     int[] asciiArr = new int[26];
        //     for (int j = 0; j < str.length(); j++) {
        //         asciiArr[str.charAt(j) - 'a'] += 1;
        //     }

        //     strings[i] = asciiArr;
        // }

        // Set<Integer> excludedIndex = new HashSet<>();

        // for (int i = 0; i < strs.length; i++) {
        //     if (excludedIndex.contains(i)) continue;

        //     List<String> group = new ArrayList<>();
        //     group.add(strs[i]);
        //     excludedIndex.add(i);
        //     for (int j = i + 1; j < strs.length; j++) {
        //         if (Arrays.equals(strings[i], strings[j])) {
        //             group.add(strs[j]);
        //             excludedIndex.add(j);
        //         }
        //     }
        //     answer.add(group);
        // }

        // return answer;


        // Still use int[26] to represent character, but this time convert it to String and use it
        // in map as a key and value is list of string have the same key
        // Time 
        List<List<String>> ans = new ArrayList<>();
        Map<String, List<String>> groups = new HashMap<>();

        for (String str : strs) {
            String key = convertToFrequencyCnt(str);
            if (groups.containsKey(key)) {
                var groupList = groups.get(key);
                groupList.add(str);
                continue;
            }

            List<String> groupList = new ArrayList<>();
            groupList.add(str);
            groups.put(key, groupList);
        }

        for (List<String> group : groups.values()) {
            ans.add(group);
        }

        return ans;
    }

    public String convertToFrequencyCnt (String str) {
        int[] freq = new int[26];
        for (int i = 0; i < str.length(); i++) {
            freq[str.charAt(i) - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for (int f : freq) {
            sb.append(f).append("#");
        }

        return sb.toString();
    }
}
