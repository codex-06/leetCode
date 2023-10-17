class Solution {
     public void solve(char[][] board, int r, int c, char[][] result){
        if(r == board.length -1 && c == board.length){
            for(int i = 0; i <9; i++){
                for(int j = 0; j <9; j++){
                    result[i][j] = board[i][j]; 
                }
            }
            return;
        }
        if(c == board.length){
            solve(board,r+1,0,result);
            return;
        }
        if(board[r][c] == '.'){
            for (int i = 1; i <=9 ; i++) {
                if(isValid(board,r,c,(char)(i + '0'))){
                    board[r][c] = (char) (i + '0');
                    solve(board,r,c+1,result);
                    board[r][c] = '.';
                }
            }
            return;
        }
        solve(board,r,c+1,result);
    }
    private  boolean isValid(char[][] board, int r, int c, char num) {
        for (int i = 0; i <9; i++) {
            if(board[i][c] == num)return false;
        }
        for (int i = 0; i < 9 ; i++) {
            if(board[r][i] == num) return false;
        }
        int row = r/3 *3;
        int col = c/3*3;
        for (int i = 0; i < 3 ; i++) {
            for (int j = 0; j <3 ; j++) {
                if(board[row+i][col+j] == num) return false;
            }
        }
        return true;
    }
    public void solveSudoku(char[][] board) {
        char[][] result = new char[9][9];
        solve(board,0,0,result);
        for(int i = 0; i <9; i++){
            for(int j = 0; j <9; j++){
                board[i][j] = result[i][j];                 }
            }
        }
    }
