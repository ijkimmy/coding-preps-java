import java.util.List;
import java.util.HashMap;
import java.util.LinkedList;
public class leetcode_md_249_grpstrs {

    // 20m
    public List<List<String>> groupStrings(String[] strings) {
        // time: O(nm), space: O(nm), where n is length of array and m is avg length of string
        HashMap<String, List<String>> grps = new HashMap<>();
        for(String str: strings){
            int offset = str.charAt(0)-'a';
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<str.length(); ++i){
                int val = (str.charAt(i) - offset) % 26;
                sb.append((char)val);
            }

            String key = sb.toString();
            if(!grps.containsKey(key)){
                grps.put(key, new LinkedList<>());
            }
            grps.get(key).add(str);
        }

        List<List<String>> retval = new LinkedList<>();
        for(String key: grps.keySet()){
            retval.add(grps.get(key));
        }

        return retval;
    }
}
