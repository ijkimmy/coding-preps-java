import java.util.HashMap;
public class leetcode_ez_359_logger {
    HashMap<String, Integer> log;
    
    // 17m
    public leetcode_ez_359_logger() {
        log = new HashMap<String, Integer>();
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(log.containsKey(message) && log.get(message)+10 > timestamp)
            return false;
        log.put(message, timestamp);
        return true;
    }
}
