public class leetcode_md_498_diagonalorder {

    // 58m
    public int[] findDiagonalOrder(int[][] mat) {
        // // direction checking, time: O(n*m), space: O(1)
        // int n = mat.length, m = mat[0].length;
        // int[] retval = new int[n*m];

        // boolean up = true;
        // int r = 0, c = 0, idx = 0;
        // while(idx < retval.length){
        //     retval[idx++] = mat[r][c];
        //     int newr = up ? r-1 : r+1;
        //     int newc = up ? c+1 : c-1;

        //     if(newr < 0 || newr == n || newc < 0 || newc == m){
        //         if(up){
        //             if(newc == m)
        //                 ++r;
        //             else 
        //                 ++c;
        //         } else {
        //             if(newr == n)
        //                 ++c;
        //             else
        //                 ++r;
        //         }
        //         up = !up;
        //     } else {
        //         r = newr;
        //         c = newc;
        //     }
        // }

        // return retval;



        // improved version, time: O(n*m), space: O(1)
        int n = mat.length, m = mat[0].length; 
        int[] retval = new int[n*m];
        
        int r = 0, c = 0;
        for(int i=0; i<retval.length; ++i){
            retval[i] = mat[r][c];
            if((r+c)%2 == 0){ // up
                if(c==m-1)      { ++r; }
                else if(r==0)   { ++c; }
                else            { --r; ++c; }
            } else { // down
                if(r==n-1)      { ++c; }
                else if(c==0)   { ++r; }
                else            { ++r; --c; }
            }
        }

        return retval;
    }
}
