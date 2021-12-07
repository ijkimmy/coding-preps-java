// import java.util.TreeMap;
public class leetcode_md_731_mycalendar {
    // TreeMap<Integer, Integer> time;
    // public leetcode_md_731_mycalendar() {
    //     // brute force treemap, time: O(nlogn), space: O(n)
    //     time = new TreeMap<>();
    // }
    
    // public boolean book(int start, int end) {
    //     time.put(start, time.getOrDefault(start, 0) + 1);
    //     time.put(end, time.getOrDefault(end, 0) - 1);

    //     int cnt = 0;
    //     for(int interval: time.values()){
    //         cnt += interval;
    //         if(cnt >= 3){
    //             time.put(start, time.get(start)-1);
    //             time.put(end, time.get(end)+1);
    //             return false;
    //         }
    //     }

    //     return true;
    // }

    class Node{
        int start, end;
        Node left, right;
        boolean overlap;

        public Node(int start, int end){
            this.start = start;
            this.end = end;
        }
    }

    Node root;

    // 42M
    public leetcode_md_731_mycalendar() {
        // binary search tree implementation, time: O(logn), space: O(n)
        // MUCH MUCH FASTER!
    }

    public boolean book(int start, int end) {
        if(!insertable(root, start, end)){
            return false;
        }

        root = insert(root, start, end);
        return true;
    }

    public boolean insertable(Node r, int start, int end){
        if(r == null) return true;
        if(start >= end) return true;
        if(end <= r.start){
            return insertable(r.left, start, end);
        } else if(r.end <= start){
            return insertable(r.right, start, end);
        } else {
            if(r.overlap)
                return false;
            if(r.start <= start && end <= r.end)    // fully occupied
                return true;
            else 
                return insertable(r.left, start, r.start) && insertable(r.right, r.end, end);
        }
    }

    public Node insert(Node r, int start, int end){
        if(r==null) return new Node(start, end);
        if(start >= end) return r;
        if(end <= r.start){
            r.left = insert(r.left, start, end);
            return r;
        } else if(r.end <= start){
            r.right = insert(r.right, start, end);
            return r;
        } else {
            int a = Math.min(start, r.start);
            int b = Math.max(start, r.start);
            int c = Math.min(end, r.end);
            int d = Math.max(end, r.end);

            r.left = insert(r.left, a, b);      // interval a--b
            
            r.start = b;                        // interval b--c
            r.end = c;            
            r.overlap = true;

            r.right = insert(r.right, c, d);    // interval c--d
            return r;
        }
    }
}
