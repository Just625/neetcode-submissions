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
    public void reorderList(ListNode head) {
        // Split the linked list into two halves: the first one is increasing while the second one decresing
        //      To do that, we need to find the middle node (the end of the first list and the start of the new list)
        //          We do that by using fast and slow pointer. When the fast pointer reachs the end node or the node before it, the slow pointer reach the middle
        // We also need to reverse the second list so we can start from the end of the second list
        // Then we just need to get one from each havles every time and connect them

        // Time O(n + n) -> O(n), Space O(1)
        ListNode slow = head, fast = head;
        // 1 - 2 - 3 - 4 => 1 - 2 - 3 - 4 (stop) Even list
        // s,f                  s   f   
        // 1 - 2 - 3 - 4 - 5 => 1 - 2 - 3 - 4 - 5 => 1 - 2 - 3 - 4 - 5 (stop) Odd list
        // s,f                      s   f                    s       f
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode prev = null;
        ListNode second = slow.next;
        // Cut the ties between two lists
        slow.next = null;
        // Reverse the second list
        while (second != null) {
            ListNode temp = second.next;
            second.next = prev;
            prev = second;
            second = temp;
        }
        // prev become the last node

        // Merge two lists
        while (prev != null) {
            ListNode tempFirst = head.next;
            ListNode tempSecond = prev.next;
            head.next = prev;
            prev.next = tempFirst;
            head = tempFirst;
            prev = tempSecond;
        }


    }
}
