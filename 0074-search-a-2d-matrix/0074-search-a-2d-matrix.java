class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // int n= matrix.length;
        // int m =matrix[0].length;
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<m;j++){
        //         if(matrix[i][j] == target)
        //             return true;
        //     }
        // }
        // return false;
        int n=matrix.length;
        int m=matrix[0].length;
        int row=0;
        int col=m-1;
        while(row<n && col>=0){
            if (matrix[row][col]==target){
                return true;
            }else if(matrix[row][col]>target){
                col--;
            }else{
                row++;
            }
        }
        return false;
    }
}