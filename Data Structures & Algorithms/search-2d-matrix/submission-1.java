class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        // 1 <= rows, cols <= 100
        int cols = matrix[0].length;

        int top = 0;
        int bottom = rows - 1;

        // Binary search on matrixes: search for row
        while (top <= bottom) {
            int midRow = top + (bottom - top) / 2;
            int[] currentMatrix = matrix[midRow];
            int rowMin = currentMatrix[0];
            int rowMax = currentMatrix[cols - 1];
            if (rowMin <= target && target <= rowMax) {
                // binary search on current matrix
                int left = 0;
                int right = cols - 1;
                while (left <= right) {
                    int mid = left + (right - left) / 2;
                    if (currentMatrix[mid] == target) {
                        return true;
                    } else if (target < currentMatrix[mid]) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }

                // If target is not found within the current row, then no other rows can contains target 
                // -> return false rightaway
                return false;
            } else if (target < rowMin) {
                bottom = midRow - 1;
            } else { // target > rowMax
                top = midRow + 1;
            }
        }

        return false;
    }
}
