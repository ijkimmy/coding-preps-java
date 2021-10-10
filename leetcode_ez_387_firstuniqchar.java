import java.util.HashMap;
public class leetcode_ez_387_firstuniqchar {

    // 7m
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c: s.toCharArray())
            map.put(c, map.getOrDefault(c, 0)+1);
        
        for(int i=0; i<s.length(); ++i){
            if(map.get(s.charAt(i)) == 1)
                return i;
        }

        return -1;
    }
}
