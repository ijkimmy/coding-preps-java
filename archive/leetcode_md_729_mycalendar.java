import java.util.TreeMap;
import java.util.Map.Entry;
public class leetcode_md_729_mycalendar {
    TreeMap<Integer, Integer> calendar;


    // 23m
    // use treemap to store timelapses
    // time: O(nlogn), space: O(n)
    public leetcode_md_729_mycalendar() {
        calendar = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        Entry<Integer, Integer> prev = calendar.lowerEntry(end);
        Entry<Integer, Integer> next = calendar.ceilingEntry(end);

        if(prev.getValue() >= start || next.getKey() < end){
            return false;
        } 

        calendar.put(start, end-1);
        return true;
    }
}
