public class leetcode_ez_70_climbstairs {

    // 40m
    public int climbStairs(int n) {
        // // dynamic programming, time=O(n), space=O(n)
        // int[] rule = new int[n+1];
        // rule[0] = 1; rule[1] = 1; 
        
        // for(int i=2; i<=n; ++i){
        //     rule[i] = rule[i-1] + rule[i-2];
        // }
        // return rule[n];

        /////////////////////////////////////////////////////////////////////////

        // // fibonacci number, time=O(n), space=O(1)
        // if(n==1) return 1;
        // int first = 1, second = 2;
        // for(int i=3; i<=n; ++i){
        //     int third = first + second;
        //     first = second;
        //     second = third;
        // }
        // return second;

        /////////////////////////////////////////////////////////////////////////

        // // fibonacci formula, time=O(log n), space=O(1)
        // double sqrt5 = Math.sqrt(5);
        // double fibn = Math.pow((1+sqrt5)/2, n+1)-Math.pow((1-sqrt5)/2, n+1);
        // return (int)(fibn/sqrt5);

        /////////////////////////////////////////////////////////////////////////

        // Binets method, time=O(log n), space=O(1)
        int[][] q = {{1, 1}, {1, 0}};
        int[][] res = pow(q, n);
        return res[0][0];
    }

    public int[][] pow(int[][] a, int n){
        int[][] ret = {{1, 0}, {0, 1}};
        while(n>0){
            if((n&1)==1)
                ret = multiply(ret, a);
            n >>= 1;
            a = multiply(a, a);
        }
        return ret;
    }

    public int[][] multiply(int[][] a, int[][]b){
        int[][] c = new int[2][2];
        for(int i=0; i<2; ++i){
            for(int j=0; j<2; ++j)
                c[i][j] = a[i][0] * b[0][j] + a[i][1] * b[1][j];
        }
        return c;
    }
}
