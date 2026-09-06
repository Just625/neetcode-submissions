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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Time O(n), Space O(n)
        List<ListNode> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            list.add(cur);
            cur = cur.next;
        }

        int size = list.size();

        if (size == 1) return null;

        // Remove head
        if (n == list.size()) {
            return head.next;
        }

        // Remove tail
        // if (n == 1) {
        //     list.get(size - n - 1).next = null;
        //     return head;
        // }

        // Connect node before n and after n
        list.get(size - n - 1).next = list.get(size - n).next;
        return head;
    }
}
