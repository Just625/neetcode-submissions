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

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Time O(n + m) where n and m are two lists's length, Space O(1)
        ListNode cur = new ListNode();
        ListNode head = cur;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }

            cur = cur.next;
        }

        // while (list1 != null) {
        //     cur.next = list1;
        //     list1 = list1.next;
        //     cur = cur.next;
        // }
        if (list1 != null) {
            cur.next = list1;
        }

        // while (list2 != null) {
        //     cur.next = list2;
        //     list2 = list2.next;
        //     cur = cur.next;
        // }
        if (list2 != null) {
            cur.next = list2;
        }

        return head.next;
    }
}