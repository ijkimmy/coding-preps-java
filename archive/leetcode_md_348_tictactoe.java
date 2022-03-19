public class leetcode_md_348_tictactoe {
    // int[][] board;

    // // brute force, time: O(n), space: O(n^2)
    // public leetcode_md_348_tictactoe(int n) {
    //     board = new int[n][n];
    // }
    
    // public int move(int row, int col, int player) {
    //     board[row][col] = player;

    //     int n = board.length;
    //     boolean win = true;
    //     for(int i=0; i<n; ++i){
    //         if(board[row][i] != player){
    //             win = false;
    //             break;
    //         }
    //     }
    //     if(win) return player;

    //     win = true;
    //     for(int i=0; i<n; ++i){
    //         if(board[i][col] != player){
    //             win = false;
    //             break;
    //         }
    //     }
    //     if(win) return player;

    //     int pos = row * n + col;
    //     if(pos%(n+1) == 0){
    //         win = true;
    //         for(int i=0; i<n; ++i){
    //             if(board[i][i] != player){
    //                 win = false;
    //                 break;
    //             }
    //         }
    //         if(win) return player;
    //     }

    //     if(pos!=0 && pos%(n-1)==0){
    //         win = true;
    //         for(int i=0; i<n; ++i){
    //             if(board[i][n-i-1] != player){
    //                 win = false;
    //                 break;
    //             }
    //         }
    //         if(win) return player;
    //     }

    //     return 0;
    // }


    int[] r, c;
    int d, antid;

    // 46m
    // optimized alg. time: O(1), space: O(n)
    public leetcode_md_348_tictactoe(int n) {
        r = new int[n];
        c = new int[n];
        d = 0; antid = 0;
    }
    
    public int move(int row, int col, int player) {
        int n = r.length;
        int val = player==1 ? 1 : -1;
        r[row] += val; if(Math.abs(r[row]) == n) return player;
        c[col] += val; if(Math.abs(c[col]) == n) return player;

        if(row == col) d += val;
        if(row+col == n-1) antid += val;
        if(Math.abs(d)==n || Math.abs(antid)==n) return player;

        return 0;
    }
}
