public class leetcode_md_1472_browserhistory {
    class Node{
        String url;
        Node prev;
        Node next;
        Node(String url, Node prev, Node next){
            this.url = url;
            this.prev = prev;
            this.next = next;
        }
    }

    Node current;


    // 25m
    public leetcode_md_1472_browserhistory(String homepage) {
        current = new Node(homepage, null, null);
    }
    
    public void visit(String url) {
        Node newcurr = new Node(url, current, null);
        current.next = newcurr;
        current = current.next;
    }
    
    public String back(int steps) {
        while(current.prev != null && steps > 0){
            current = current.prev;
            --steps;
        }

        return current.url;
    }
    
    public String forward(int steps) {
        while(current.next != null && steps > 0){
            current = current.next;
            ++steps;
        }

        return current.url;
    }
}
