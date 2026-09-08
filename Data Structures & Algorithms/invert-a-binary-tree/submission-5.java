/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public TreeNode invertTree(TreeNode root) {
        // BFS: Time O(n), Space O(n)
        // if (root == null) return root;

        // Using queue interface is better then deque here
        // Queue<TreeNode> queue = new ArrayDeque<>();
        // queue.offer(root);

        // while (!queue.isEmpty()) {
        //     TreeNode cur = queue.poll();

        //     // if (cur == null) continue;

        //     TreeNode temp = cur.left;
        //     cur.left = cur.right;
        //     cur.right = temp;

        //     if (cur.left != null) queue.offer(cur.left);
        //     if (cur.right != null) queue.offer(cur.right);
        // }

        // return root;

        // DFS: Time O(n), Space O(n)
        if (root == null) return root;

        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();

            TreeNode temp = cur.left;
            cur.left = cur.right;
            cur.right = temp;

            if (cur.left != null) stack.push(cur.left);
            if (cur.right != null) stack.push(cur.right);
        }

        return root;
    }
}
