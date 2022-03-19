import java.util.HashMap;
public class leetcode_ez_205_isomorphicstr {

    // 19m
    public boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length()) return false;
        if(s.length() == 0) return true;

        HashMap<Character, Character> stot = new HashMap<>();
        HashMap<Character, Character> ttos = new HashMap<>();
        for(int i=0; i<s.length(); ++i){
            Character c1 = stot.put(s.charAt(i), t.charAt(i));
            if(c1 != null && c1 != t.charAt(i)) return false;
            Character c2 = ttos.put(t.charAt(i), s.charAt(i));
            if(c2 != null && c2 != s.charAt(i)) return false;
        }

        return true;
    }
}
