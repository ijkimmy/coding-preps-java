import java.util.List;
import java.util.LinkedList;
public class leetcode_md_969_pancakesort {

    // 49m
    public List<Integer> pancakeSort(int[] arr) {
        // similar to bubble sort algorithm, find max at tail in each iteration 
        // O(n^2)
        List<Integer> retval = new LinkedList<>();

        int n = arr.length - 1;
        while(n > 0){
            int maxidx = maxidx(arr, n);
            if(maxidx != n){
                flip(arr, maxidx); retval.add(maxidx+1); // flip at kth means flip k+1 elem
                flip(arr, n); retval.add(n+1);
            }
            --n;
        }

        return retval;
    }

    public int maxidx(int[] arr, int range){
        if(range >= arr.length) return -1;

        int maxidx = 0;
        for(int i=1; i<=range; ++i)
            maxidx = arr[maxidx] < arr[i] ? i : maxidx;
        return maxidx;
    }

    public void flip(int[] arr, int range){
        if(range >= arr.length) return;

        int lo = 0, hi = range;
        while(lo < hi){
            int tmp = arr[lo];
            arr[lo] = arr[hi];
            arr[hi] = tmp;
            ++lo; --hi;
        }
    }
}
