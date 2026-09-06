class Solution {
    public boolean isValidSudoku(char[][] board) {
        // // Check every column to see if they contains duplicate values between 1 to 9 except .
        // // Do the same for every row
        // // Do the same for every block of 3
        // // Time O(n*n + n * n + n * n) = O(n^2), Space O(n)
        // int len = board.length;
        // Set<Character> duplicateSet = new HashSet<>();

        // // Check column
        // for (int row = 0; row < len; row++) {
        //     // Reuse set
        //     duplicateSet.clear();
        //     for (int column = 0; column < len; column++) {
        //         char c = board[row][column];
        //         if (c == '.') continue;
        //         if (duplicateSet.contains(c)) return false;
        //         duplicateSet.add(c);
        //     }
        // }

        // // Check row
        // for (int column = 0; column < len; column++) {
        //     // Reuse set
        //     duplicateSet.clear();
        //     for (int row = 0; row < len; row++) {
        //         char c = board[row][column];
        //         if (c == '.') continue;
        //         if (duplicateSet.contains(c)) return false;
        //         duplicateSet.add(c);
        //     }
        // }

        // // Check every block of 3
        // // Example: blockRowStart = 0, blockColStart = 3 => (0,3) to (2,5)
        // // (0,3) + (0,0) = (0,3)
        // // (0,3) + (0,1) = (0,4)
        // // (0,3) + (0,2) = (0,5)

        // // (0,3) + (1,0) = (1,3)
        // // (0,3) + (1,1) = (1,4)
        // // (0,3) + (1,2) = (1,5)

        // // (0,3) + (2,0) = (2,3)
        // // (0,3) + (2,1) = (2,4)
        // // (0,3) + (2,2) = (2,5)
        // int blockSize = 3;
        // for (int blockRowStart = 0; blockRowStart < len; blockRowStart += blockSize) {
        //     for (int blockColumnStart = 0; blockColumnStart < len; blockColumnStart += blockSize) {
        //         duplicateSet.clear();
        //         for (int i = 0; i < 3; i++) {
        //             for (int j = 0; j < 3; j++) {
        //                 int row = blockRowStart + i;
        //                 int column = blockColumnStart + j;
        //                 char c = board[row][column];
        //                 if (c == '.') continue;
        //                 if (duplicateSet.contains(c)) return false;
        //                 duplicateSet.add(c);
        //             }
        //         }
        //     }
        // }

        // return true;

        // One pass solution
        // When looping through each char, we actually can identify its column, row and block which it belongs to
        // Therefore, we can create 3 map which represent column, row and block respectively and check duplicate there
        // Tricky part is how to identify which block its belong to
        // blockId = (row / 3) * 3 + (col / 3)
        // divide by 3 because it is a block of 3x3, multiply by 3 because each line contains only 3 records
        // Block can be represented like this:
        // 0 1 2
        // 3 4 5
        // 6 7 8
        Map<Integer, Set<Character>> rowMap = new HashMap<>();
        Map<Integer, Set<Character>> columnMap = new HashMap<>();
        Map<Integer, Set<Character>> blockMap = new HashMap<>();
        int len = board.length;
        for (int row = 0; row < len; row++) {
            for (int column = 0; column < len; column++) {
                char c = board[row][column];
                if (c == '.') {
                    continue;
                }

                // if (rowMap.containsKey(row)) {
                //     Set<Character> seen = rowMap.get(row);
                //     if (seens.contains(c)) return false;
                //     seen.add(c);
                // } else {
                //     Set<Character> seen = new HashSet<>();
                //     seen.add(c);
                //     rowMap.put(row, seen);
                // }
                // Create a HashSet if key doesn't exist and then put it in the map
                // After that, it return the HashSet, so we can add value to the HashSet
                boolean canAdd = rowMap.computeIfAbsent(row, k -> new HashSet<>())
                    .add(c);
                // If Set already contains char -> duplicate values -> return false;
                if (!canAdd) return false;

                canAdd = columnMap.computeIfAbsent(column, k -> new HashSet<>()).add(c);
                if (!canAdd) return false;

                int blockID = (row / 3) * 3 + (column / 3);
                canAdd = blockMap.computeIfAbsent(blockID, k -> new HashSet<>()).add(c);
                if (!canAdd) return false;
            }
        }

        return true;
    }
}
