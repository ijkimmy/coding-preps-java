import java.util.HashMap;
public class leetcode_md_833_findreplacestr {

    // 38m
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        HashMap<Integer, Integer> idxs = new HashMap<>();
        for(int i=0; i<indices.length; ++i){
            idxs.put(indices[i], i);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); ++i){
            if(!idxs.containsKey(i)){
                sb.append(s.charAt(i));
            } else {
                int k = idxs.get(i);

                if(!s.startsWith(sources[k], i)){       // using startsWith is much faster than below method
                    sb.append(s.charAt(i));
                } else {
                    sb.append(targets[k]);
                    i = i + sources[k].length() - 1;
                }

                // String src = sources[k];
                // int srcidx = 0, sidx = i;
                // for(; srcidx<src.length() && sidx<s.length(); ++srcidx, ++sidx){
                //     if(src.charAt(srcidx) != s.charAt(sidx))
                //         break;
                // }

                // if(srcidx != src.length()){
                //     sb.append(s.charAt(i));
                //     continue;
                // }

                // sb.append(targets[k]);
                // i = sidx-1;
            }
        }

        return sb.toString();
    }
}
