import java.util.HashMap;
import java.util.TreeMap;

public class leetcode_md_981_timemap {
    HashMap<String, TreeMap<Integer, String>> map;


    // 20m
    public leetcode_md_981_timemap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)){
            map.put(key, new TreeMap<>());
        }

        map.get(key).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)){
            return "";
        }
        
        Integer prevts = map.get(key).floorKey(timestamp);
        if(prevts == null){
            return "";
        }

        return map.get(key).get(prevts);
    }
}
