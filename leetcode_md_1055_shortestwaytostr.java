import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
public class leetcode_md_1055_shortestwaytostr {

    // 49m
    public int shortestWay(String source, String target) {
        // binary search src, time: O(TlogS), space: O(S)
        final int nchars = 26;
        List<Integer>[] src = new List[nchars];
        for(int i=0; i<source.length(); ++i){
            int arridx = source.charAt(i) - 'a';
            if(src[arridx] == null) src[arridx] = new ArrayList<>();
            src[arridx].add(i);
        }

        int srcidx = 0, itercnt = 1;
        for(int i=0; i<target.length(); ++i){
            int trg = target.charAt(i) - 'a';
            if(src[trg] == null) return -1;
            int searchidx = Collections.binarySearch(src[trg], srcidx);
            if(searchidx < 0) searchidx = -searchidx - 1;
            if(searchidx == src[trg].size()) {
                searchidx = 0;
                ++itercnt;
            }
            srcidx = src[trg].get(searchidx) + 1;
        }

        return itercnt;
    }
}