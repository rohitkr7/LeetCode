class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        int[] rowTracker = new int[m];
        int[] colTracker = new int[n];
        
        // Iterating and tracking rows and cols which contains zeros
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j] == 0){
                    rowTracker[i] = -1; // placing -1 to denote that zero was present
                    colTracker[j] = -1;
                }
            }
        }
        
        // Iterating and updating rows and cols as per the zero placements
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(rowTracker[i] == -1 || colTracker[j] == -1){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}