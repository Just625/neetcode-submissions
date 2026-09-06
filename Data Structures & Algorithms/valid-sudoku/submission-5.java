class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Check every column to see if they contains duplicate values between 1 to 9 except .
        // Do the same for every row
        // Do the same for every block of 3
        // Time O(n*n + n * n + n * n) = O(n^2), Space O(1)
        int len = board.length;
        Set<Character> duplicateSet = new HashSet<>();

        // Check column
        for (int i = 0; i < len; i++) {
            // Reuse set
            duplicateSet.clear();
            for (int j = 0; j < len; j++) {
                char c = board[i][j];
                if (c == '.') continue;
                if (duplicateSet.contains(c)) return false;
                duplicateSet.add(c);
            }
        }

        // Check row
        for (int i = 0; i < len; i++) {
            // Reuse set
            duplicateSet.clear();
            for (int j = 0; j < len; j++) {
                char c = board[j][i];
                if (c == '.') continue;
                if (duplicateSet.contains(c)) return false;
                duplicateSet.add(c);
            }
        }

        // Check every block of 3
        // Example: blockRowStart = 0, blockColStart = 3 => (0,3) to (2,5)
        // (0,3) + (0,0) = (0,3)
        // (0,3) + (0,1) = (0,4)
        // (0,3) + (0,2) = (0,5)

        // (0,3) + (1,0) = (1,3)
        // (0,3) + (1,1) = (1,4)
        // (0,3) + (1,2) = (1,5)

        // (0,3) + (2,0) = (2,3)
        // (0,3) + (2,1) = (2,4)
        // (0,3) + (2,2) = (2,5)
        int blockSize = 3;
        for (int blockRowStart = 0; blockRowStart < len; blockRowStart += blockSize) {
            for (int blockColumnStart = 0; blockColumnStart < len; blockColumnStart += blockSize) {
                duplicateSet.clear();
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        int row = blockRowStart + i;
                        int column = blockColumnStart + j;
                        char c = board[row][column];
                        if (c == '.') continue;
                        if (duplicateSet.contains(c)) return false;
                        duplicateSet.add(c);
                    }
                }
            }
        }

        return true;
    }
}
