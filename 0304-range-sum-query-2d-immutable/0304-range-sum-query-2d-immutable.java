class NumMatrix {
    int[][] mat;
    int n;
    int m;

    public NumMatrix(int[][] matrix) {
        n = matrix.length;
        m = matrix[0].length;
        mat = new int[n][m];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                mat[i][j]= matrix[i][j];
            }
        }
    }   
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        if( row1<0 || row1>=n ||
            row2<0 || row2>=n ||
            col1<0 || col1>=m ||
            col2<0 || col2>=m ){
            return -1;
        }
        int sum = 0;
        for(int i = row1;i<=row2;i++){
            for(int j = col1; j<=col2;j++){
                sum+=mat[i][j];
            }
        }
        return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */