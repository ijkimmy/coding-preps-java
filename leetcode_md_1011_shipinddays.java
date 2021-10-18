public class leetcode_md_1011_shipinddays {

    // 43m
    public int shipWithinDays(int[] weights, int days) {
        // binary search, time: O(n*logSIZE), space: O(1), where SIZE is search space (max-min)
        int min = 0, max = 0;
        for(int w: weights){
            min = min < w ? w : min;
            max += w;
        }

        if(days == 1) return max;
        if(days == weights.length) return min;

        while(min < max){
            int cap = min + (max-min)/2;
            int needed = 1, weight = 0;
            for(int w: weights){
                if(weight+w > cap){
                    ++needed;
                    weight = 0;
                }
                weight += w;
            }
            if(needed > days) min = cap+1;
            else max = cap;
        }

        return min;
    }
}
