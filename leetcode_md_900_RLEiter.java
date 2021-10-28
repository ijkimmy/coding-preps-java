public class leetcode_md_900_RLEiter {
    int evenidx;
    int[] encoding;

    // 24m, time: O(encoding), space: O(1)
    public leetcode_md_900_RLEiter(int[] encoding) {
        evenidx = 0;
        this.encoding = encoding;
    }
    
    public int next(int n) {
        while(evenidx < encoding.length && encoding[evenidx] < n){
            n -= encoding[evenidx];
            evenidx += 2;
        }

        if(evenidx >= encoding.length) return -1;

        encoding[evenidx] -= n;
        return encoding[evenidx+1];
    }
}
