class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int leftM = 0;
        int rightM = m - 1;

        // Binary search on matrixes
        while (leftM <= rightM) {
            int midM = leftM + (rightM - leftM) / 2;
            System.out.println("midM: " + midM);
            int[] currentMatrix = matrix[midM];
            if (currentMatrix[0] <= target && target <= currentMatrix[n - 1]) {
                // binary search on current matrix
                int leftN = 0;
                int rightN = n - 1;
                while (leftN <= rightN) {
                    int midN = leftN + (rightN - leftN) / 2;
                    System.out.println("midN: " + midM);
                    if (currentMatrix[midN] == target) {
                        return true;
                    } else if (target < currentMatrix[midN]) {
                        rightN = midN - 1;
                    } else {
                        leftN = midN + 1;
                    }
                }
                
                return false;
            } else if (target < currentMatrix[0]) {
                rightM = midM - 1;
            } else {
                leftM = midM + 1;
            }
        }

        return false;
    }
}
