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
        Deque<ListNode> stack = new ArrayDeque<>();
        ListNode cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }

        int n = stack.size();
        for (int i = 0; i < n / 2; i++) {
            ListNode tail = stack.pop();
            ListNode temp = head.next;
            head.next = tail;

            if (tail == temp) {
                temp = null;
            }

            tail.next = temp;
            head = temp;
        }

        if (head != null) head.next = null;
    }
}
