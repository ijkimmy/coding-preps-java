/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class leetcode_md_24_swappairLL {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // 19m
    public ListNode swapPairs(ListNode head) {
        // // recursive, time: O(n), space: O(n)
        // if(head == null || head.next == null) return head;

        // ListNode first = head, second = head.next;
        // first.next = swapPairs(second.next);
        // second.next = first;

        // return second;

        // iterative, time: O(n), space: O(1)
        if(head == null || head.next == null) return head;

        ListNode pt = head, prev = null;
        head = head.next;
        while(pt!=null && pt.next!=null){
            if(prev != null)
                prev.next = pt.next;
            ListNode next = pt.next.next;
            pt.next.next = pt;
            pt.next = next;

            prev = pt;
            pt = pt.next;
        }

        return head;
    }
}
