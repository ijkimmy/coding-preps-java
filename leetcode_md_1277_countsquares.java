public class leetcode_md_1277_countsquares {

    // 34m
    public int countSquares(int[][] matrix) {
        // // brute force solution, O(n^2m^2)
        // if(matrix.length == 0 || matrix[0].length == 0) return 0;

        // int cntsquare = 0;
        // for(int i=0; i<matrix.length; ++i){
        //     for(int j=0; j<matrix[0].length; ++j){
        //         if(matrix[i][j] == 1){
        //             for(int k=0; k+i<matrix.length && k+j<matrix[0].length; ++k){
        //                 boolean square = true;
        //                 for(int l=0; l<=k; ++l){
        //                     if(matrix[k+i][l+j] == 0 || matrix[l+i][k+j] == 0){
        //                         square = false;
        //                         break;
        //                     }
        //                 }
        //                 if(!square) break;
        //                 ++cntsquare;
        //             }
        //         }
        //     }
        // }

        // return cntsquare;


        // dynamic programming, O(nm)
        int cntsquare = 0;
        for(int i=0; i<matrix.length; ++i){
            for(int j=0; j<matrix[0].length; ++j){
                if(matrix[i][j] == 1 && i > 0 && j > 0){
                    matrix[i][j] = Math.min(matrix[i-1][j-1], Math.min(matrix[i-1][j], matrix[i][j-1])) + 1;
                }
                cntsquare += matrix[i][j];
            }
        }

        return cntsquare;
    }
}
