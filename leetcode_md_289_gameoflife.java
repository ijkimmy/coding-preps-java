public class leetcode_md_289_gameoflife {

    // 37m
    public void gameOfLife(int[][] board) {
        // mark it with different value, time: O(nm), space: O(1)
        // dead -> live: 2
        // live -> dead: -1
        for(int i=0; i<board.length; ++i){
            for(int j=0; j<board[i].length; ++j){
                int live = countliveneighb(board, i, j);
                if(board[i][j] == 1){
                    live -= 1;
                    if(2 > live || live > 3) board[i][j] = -1;
                } else if(live==3) {
                    board[i][j] = 2;
                }
            }
        }

        for(int i=0; i<board.length; ++i){
            for(int j=0; j<board[i].length; ++j){
                board[i][j] = board[i][j] > 0 ? 1 : 0;
            }
        }
    }

    public int countliveneighb(int[][] b, int r, int c){
        int[] dir = { -1, 0, +1 };
        
        int live = 0;
        for(int row: dir){
            for(int col: dir){
                int nextr = r + row; if(0 > nextr || nextr > b.length) continue;
                int nextc = c + col; if(0 > nextc || nextc > b[nextr].length) continue;

                live += Math.abs(b[nextr][nextc]) == 1 ? 1 : 0;
            }
        }
        return live;
    }
}
