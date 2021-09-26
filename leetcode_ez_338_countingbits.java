public class leetcode_ez_338_countingbits {
    // idea
    // number of 1 is +1 of all previous numbers at when i is power of 2

    public static void main(String[] args){
        countBits(5);
    }

    // 1hr
    public static int[] countBits(int n) {
        // // Solution 1: Overheads while using Math.log
        // int[] retval = new int[n+1];

        // // base case 
        // retval[0] = 0;  

        // int repeatidx = 0;
        // for(int i=1; i<=n; ++i){
        //     // if i is power of 2, repeat from beginning + 1
        //     double dlog2 = Math.log(i)/Math.log(2);
        //     if(dlog2 == (int)dlog2) repeatidx = 0; 

        //     retval[i] = retval[repeatidx++] + 1;
        // }

        // return retval;

        ///////////////////////////////////////////////////////

        // // Solutiom 2: remove overheads from Solution 1
        // int[] retval = new int[n+1];
        
        // retval[0] = 0;

        // int arridx = 1, repeatidx = 0;
        // while(arridx <= n){
        //     int idx = arridx;
        //     while(repeatidx < arridx && idx <= n)
        //         retval[idx++] = retval[repeatidx++] + 1;
        //     arridx = idx;
        //     repeatidx = 0;
        // }
        // return retval;

        ///////////////////////////////////////////////////////

        // Solution 3: use information of i/2 and i%2

        int[] retval = new int[n+1];
        for(int i=1; i<=n; ++i){
            retval[i] = retval[i/2] + i%2;
        }
        return retval;
    }
}
