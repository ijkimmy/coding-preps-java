// import java.util.Arrays;
public class leetcode_md_621_taskscheduler {

    // 50m
    public int leastInterval(char[] tasks, int n) {
        // // greedy, time: O(n + 26log26 + 26), space: O(1)
        // if(n==0) return tasks.length;

        // final int arrsize = 26;
        // char[] freq = new char[arrsize];
        // for(char task: tasks){
        //     ++freq[task-'A'];
        // }

        // Arrays.sort(freq);

        // int maxfreq = freq[arrsize-1];
        // int idle = (maxfreq-1) * n;

        // for(int i=arrsize-2; i>=0 && idle>0; --i){
        //     idle -= Math.min(maxfreq-1, freq[i]);
        // }
        // idle = Math.max(0, idle);

        // return tasks.length + idle;



        // math, time: O(n), space: O(1)
        if(n==0) return tasks.length;

        final int arrsize = 26;
        int[] freq = new int[arrsize];
        for(int task: tasks)
            ++freq[task-'A'];
        
        int maxf = 0;
        for(int f: freq)
            maxf = Math.max(maxf, f);
        
        int maxcnt = 0;
        for(int f: freq)
            if(f == maxf) ++maxcnt;
        
        return Math.max(tasks.length, (maxf - 1) * (n + 1) + maxcnt);
    }
}
