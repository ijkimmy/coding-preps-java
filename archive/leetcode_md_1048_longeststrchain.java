import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
public class leetcode_md_1048_longeststrchain {

    // 57m
    public int longestStrChain(String[] words) {
        // bottom-up dp w/ bucket sort, time: O(nl^2), space: O(n)
        final int maxwordlen = 16;
        List<String>[] bucket = new List[maxwordlen+1];
        for(String word: words){
            if(bucket[word.length()] == null) bucket[word.length()] = new ArrayList<>();
            bucket[word.length()].add(word);
        }

        int maxcnt = 1;
        HashMap<String, Integer> cnt = new HashMap<>();
        for(int i=1; i<bucket.length; ++i){
            if(bucket[i] == null) continue;
            if(bucket[i-1] == null){
                for(String word: bucket[i]){
                    cnt.put(word, 1);
                }
            } else {
                for(String word: bucket[i]){
                    int len = 1;
                    for(int wi=0; wi<word.length(); ++wi){
                        StringBuilder sb = new StringBuilder(word);
                        sb.deleteCharAt(wi);
                        int prevlen = cnt.getOrDefault(sb.toString(), 0) + 1;
                        len = Math.max(len, prevlen);
                    }
                    cnt.put(word, len);
                    maxcnt = Math.max(maxcnt, len);
                }
            }
        }

        return maxcnt;
    }
}
