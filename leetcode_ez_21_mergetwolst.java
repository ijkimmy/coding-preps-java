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

public class leetcode_ez_21_mergetwolst {
    public class ListNode{
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // 18m
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // // recursive solution
        // if(l1 == null) return l2;
        // else if(l2 == null) return l1;
        // else if(l1.val < l2.val) {
        //     l1.next = mergeTwoLists(l1.next, l2);
        //     return l1;
        // }
        // else{
        //     l2.next = mergeTwoLists(l1, l2.next);
        //     return l2;
        // }


        // iterative solution
        ListNode head = new ListNode(-1);
        ListNode pt = head;

        while(l1!=null && l2!=null){
            if(l1.val < l2.val){
                pt.next = l1;
                l1 = l1.next;
            }
            else{
                pt.next = l2;
                l2 = l2.next;
            }
            pt = pt.next;
        }

        pt.next = l1==null? l2 : l1;

        return head.next;
    }
}
