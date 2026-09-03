class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int row = n - 1;
        int col = 0;
        while(row >=0 && col < m){
            if(matrix[row][col] == target){
                return true;
            }
            if(matrix[row][col] > target){
                row--;
            }else{
                col++;
            }
        }
        return false;
        // for(int i = 0; i < matrix.length; i++){
        //     for(int j = 0; j < matrix[0].length; j++){
        //         if(matrix[i][j] == target){
        //             return true;
        //         }
        //     }
        // }
        // return false;
    }
}