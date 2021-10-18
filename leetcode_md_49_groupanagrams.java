import java.util.List;
import java.util.HashMap;
import java.util.LinkedList;
// import java.util.Arrays;
public class leetcode_md_49_groupanagrams {

    // 36m
    public List<List<String>> groupAnagrams(String[] strs) {
        // // sorted string as key to hashmap, time: O(nmlogm), space: O(nm)
        // HashMap<String, List<String>> groups = new HashMap<>();
        // for(String str: strs){
        //     char[] carr = str.toCharArray();
        //     Arrays.sort(carr);
        //     String sorted = String.valueOf(carr);
            
        //     if(!groups.containsKey(sorted)) groups.put(sorted, new LinkedList<>());
        //     groups.get(sorted).add(str);
        // }

        // return new LinkedList<>(groups.values());



        // count appearance as key to hashmap, time: O(nm), space: O(nm)
        HashMap<String, List<String>> groups = new HashMap<>();
        for(String str: strs){
            char[] cnts = new char[26];         // use char becuz it fits in constraint of s[i].length <= 100 AND char array is faster
            for(int i=0; i<str.length(); ++i){
                ++cnts[str.charAt(i)-'a'];
            }

            String key = String.valueOf(cnts);

            if(!groups.containsKey(key)) groups.put(key, new LinkedList<>());
            groups.get(key).add(str);
        }

        return new LinkedList<>(groups.values());
    }
}
