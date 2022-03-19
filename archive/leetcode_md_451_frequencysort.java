import java.util.HashMap;
// import java.util.Arrays;
// import java.util.Collections;
import java.util.List;
// import java.util.LinkedList;
import java.util.ArrayList;
public class leetcode_md_451_frequencysort {

    // 106m
    public String frequencySort(String s) {
        // // 2 Arrays - sorting together, time: O(size + S + sizelogsize + S) = O(Max(sizelogsize, S)), space: O(size)
        // final int size = 26+26+10; // 0~9A~Za~z

        // int[] cnt = new int[size];
        // int[] idx = new int[size];

        // for(int i=0; i<size; ++i)
        //     idx[i] = i;

        // for(int i=0; i<s.length(); ++i){
        //     int c = s.charAt(i);
        //     if(c-'0' < 10){
        //         c = c-'0';
        //         ++cnt[c];
        //     } else if (c-'A' < 26){
        //         c = c-'A'+10;
        //         ++cnt[c];
        //     } else {
        //         c = c-'a'+10+26;
        //         ++ cnt[c];
        //     }
        // }

        // // sort both arrays - insertion sort
        // for(int i=1; i<size; ++i){
        //     int keycnt = cnt[i];
        //     int keyidx = idx[i];
        //     int j = i-1;
        //     while(j >= 0 && cnt[j] > keycnt){
        //         cnt[j+1] = cnt[j];
        //         idx[j+1] = idx[j--];
        //     }
        //     cnt[j+1] = keycnt;
        //     idx[j+1] = keyidx;
        // }

        // String retval = "";
        // for(int i=size-1; i>=0 && cnt[i] > 0; --i){
        //     int c = idx[i];
        //     if(c < 10){
        //         c = c+'0';
        //     } else if(c<36){
        //         c = c-10+'A';
        //     } else {
        //         c = c-10-26+'a';
        //     }

        //     char ch = (char) c;
        //     retval += String.valueOf(ch).repeat(cnt[i]);
        // }

        // return retval;



        // // solution1: arrays and sorting, time: O(slogs + s + slogs + s) = O(slogs), space: O(s)
        // char[] chars = s.toCharArray();
        // Arrays.sort(chars);

        // StringBuilder sb = new StringBuilder(); sb.append(chars[0]);
        // List<String> groups = new LinkedList<>();
        // for(int i=1; i<chars.length; ++i){
        //     if(chars[i-1] != chars[i]){
        //         groups.add(sb.toString());
        //         sb.setLength(0);
        //     }
        //     sb.append(chars[i]);
        // }
        // groups.add(sb.toString());
        // sb.setLength(0);

        // Collections.sort(groups, ((a,b) -> b.length()-a.length()));
        // for(String group: groups){
        //     sb.append(group);
        // }

        // return sb.toString();



        // // solution2: hashmap and sorting, time: O(s + s + slogs + s) = O(slogs), space: O(s)
        // HashMap<Character, Integer> cntmap = new HashMap<>();
        // for(int i=0; i<s.length(); ++i)
        //     cntmap.put(s.charAt(i), cntmap.getOrDefault(s.charAt(i), 0)+1);
        
        // List<Character> lstchar = new LinkedList<>(cntmap.keySet());
        // Collections.sort(lstchar, ((a,b)-> cntmap.get(b)-cntmap.get(a)));

        // String retval = "";
        // for(char c: lstchar){
        //     retval += String.valueOf(c).repeat(cntmap.get(c));
        // }

        // return retval;



        // solution3: multisets and bucket sort, time: O(n), space: O()
        int maxfreq = 0;
        HashMap<Character, Integer> cntmap = new HashMap<>();
        for(int i=0; i<s.length(); ++i){
            int freq = cntmap.getOrDefault(s.charAt(i), 0) + 1;
            maxfreq = freq > maxfreq ? freq: maxfreq;
            cntmap.put(s.charAt(i), freq);
        }
        
        List<Character>[] bucket = new List[maxfreq];
        
        for(char c: cntmap.keySet()){
            int idx = cntmap.get(c) - 1;
            if(bucket[idx] == null) bucket[idx] = new ArrayList<>();
            bucket[idx].add(c);
        }
 
        String retval = "";
        for(int i=bucket.length-1; i>=0; --i){
            if(bucket[i]!=null){
                for(char c: bucket[i]){
                    retval += String.valueOf(c).repeat(i+1);
                }
            }
        }

        return retval;
    }
}
