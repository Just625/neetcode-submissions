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
    public boolean hasCycle(ListNode head) {
        // Time O(n), Space O(n)
        // Set<ListNode> seen = new HashSet<>();

        // while (head != null) {
        //     if (seen.contains(head)) {
        //         return true;
        //     }

        //     seen.add(head);
        //     head = head.next;
        // }

        // return false;

        // slow pointer (move one at a time) and fast pointer (move two steps at a time)
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }
}
