public class leetcode_md_1641_countvowelstrs {

    // 33m
    public int countVowelStrings(int n) {
        int[] a = new int[n+1]; a[1] = 1;
        int[] e = new int[n+1]; e[1] = 1;
        int[] i = new int[n+1]; i[1] = 1;
        int[] o = new int[n+1]; o[1] = 1;
        int[] u = new int[n+1]; u[1] = 1;

        for(int idx=2; idx<n+1; ++idx){
            a[idx] = a[idx-1] + e[idx-1] + i[idx-1] + o[idx-1] + u[idx-1];
            e[idx] = e[idx-1] + i[idx-1] + o[idx-1] + u[idx-1];
            i[idx] = i[idx-1] + o[idx-1] + u[idx-1];
            o[idx] = o[idx-1] + u[idx-1];
            u[idx] = u[idx-1];
        }

        return a[n] + e[n] + i[n] + o[n] + u[n];
    }
}
