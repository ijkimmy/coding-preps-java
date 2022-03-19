/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class leetcode_ez_141_linkedlstcycle {
    class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
            next = null;
        }
    }


    // 17m
    public boolean hasCycle(ListNode head) {
        // // destructive algorithm, time: O(n), space: O(1)
        // ListNode visited = new ListNode(0);

        // while(head!=null){
        //     ListNode node = head.next;
        //     if(node == visited) return true;
        //     head.next = visited;
        //     head = node;
        // }
        // return false;


        // Floyd's cycle finding algorithm, time: O(n), space: O(1)
        if(head == null) return false;

        ListNode slow = head;
        ListNode fast = head.next;
        while(slow != fast){
            if(fast == null || fast.next == null) return false;

            slow = slow.next;
            fast = fast.next.next;
        }

        return true;
    }
}
