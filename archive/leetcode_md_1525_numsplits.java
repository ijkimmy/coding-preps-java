import java.util.HashSet;
public class leetcode_md_1525_numsplits {

    // 29m
    public int numSplits(String s) {
        int[] distinct = new int[s.length()];
        HashSet<Character> set = new HashSet<>(); 
        for(int i=0; i<s.length(); ++i){
            set.add(s.charAt(i));
            distinct[i] = set.size();
        }

        set.clear();
        int retval = 0;
        for(int i=s.length()-1; i>0; --i){
            set.add(s.charAt(i));
            if(distinct[i-1] == set.size())
                ++retval;
        }

        return retval;
    }
}
