public class leetcode_md_48_rotateimg {

    // 56m
    public void rotate(int[][] matrix) {
        // // changing 4 elem at once, time: O(n), space: O(1)
        // int n = matrix.length, padding = 0; 
        // for(int len=n-1; len>0; len-=2){
        //     for(int i=0; i<len; ++i){ 
        //         int idx0 = padding;
        //         int idxi = padding+i;
        //         int idxn = padding + len;
        //         int idxni = padding + len - i;

        //         int tmp = matrix[idx0][idxi];
        //         matrix[idx0][idxi] = matrix[idxni][idx0];
        //         matrix[idxni][idx0] = matrix[idxn][idxni];
        //         matrix[idxn][idxni] = matrix[idxi][idxn];
        //         matrix[idxi][idxn] = tmp;
        //     }

        //     ++padding;
        // }



        // transpose and reflect, time: O(n), space: O(1)
        transpose(matrix);
        reflect(matrix);
    }

    public void transpose(int[][] matrix){
        for(int i=0; i<matrix.length; ++i){
            for(int j=i; j<matrix.length; ++j){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }

    public void reflect(int[][] matrix){
        int n = matrix.length;
        for(int i=0; i<n; ++i){
            for(int j=0; j<n/2; ++j){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n-j-1];
                matrix[i][n-j-1] = tmp;
            }
        }
    }
}
