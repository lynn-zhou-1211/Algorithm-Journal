class Solution {
    public boolean isValidSudoku(char[][] board) {
       // 维护行、列、宫格三个count
       // 遍历每一个元素，同时检查三个数组有没有重复
       int[][] rows = new int[9][10];
       int[][] cols = new int[9][10];
       int[][] boxes = new int[9][10];

       for(int i = 0; i<9;i++){
            for(int j = 0;j<9;j++){
                if(board[i][j]=='.'){
                    continue;
                }
                int num = board[i][j]-'0';
                int boxIdx = (i/3)*3+j/3;
                if(rows[i][num]==1 || cols[j][num]==1 || boxes[boxIdx][num]==1){
                    return false;
                }
                rows[i][num]=1;
                cols[j][num]=1; 
                boxes[boxIdx][num]=1;
            }
       }
       return true;
    }
}