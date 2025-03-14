class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Efficient solution Time: O(m+n) Space: O(1)
        // Starting from the last column of the first row and deciding where to move
        int i = 0;
        int j = matrix[0].length-1;
        while(i < matrix.length && j >= 0){
            if(matrix[i][j]==target){
                return true;
            }
            if(matrix[i][j] > target)
                j--;
            else
                i++;
        }
        return false;
    }

    // Binary Search Approach on Matrix - Less efficient than the above solution
    // Time: O(log(mn)) | Space: O(1)
    public boolean searchMatrix2(int[][] matrix, int target) {
        if(matrix.length == 0) return false;

        int rows = matrix.length;
        int columns = matrix[0].length;

        int low = 0;
        int high = rows * columns;

        while(low < high) {
            int mid = (low+high)/2;

            if(matrix[mid/columns][mid%columns] == target) {
                return true;
            } else if (matrix[mid/columns][mid%columns] < target) {
                low = mid+1;
            } else {
                high = mid;
            }
        }
        return false;
    }
}