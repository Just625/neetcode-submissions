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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // // BFS throught two trees at the same time
        // // If values are not equals, return false right away
        // // Check if both queues are empty, return true, else return false
        // if (p == null && q == null) return true;
        // if (p == null && q != null
        //     || (p != null && q == null)) return false;

        // Queue<TreeNode> firstQueue = new ArrayDeque<>();
        // firstQueue.offer(p);
        // Queue<TreeNode> secondQueue = new ArrayDeque<>();
        // secondQueue.offer(q);

        // while (!firstQueue.isEmpty() && !secondQueue.isEmpty()) {
        //     TreeNode first = firstQueue.poll();
        //     TreeNode second = secondQueue.poll();

        //     if (first.val != second.val) {
        //         return false;
        //     }

        //     if (first.left != null && second.left != null) {
        //         firstQueue.offer(first.left);
        //         secondQueue.offer(second.left);
        //     } else if (first.left == null && second.left != null
        //     || (first.left != null && second.left == null)) {
        //         return false;
        //     }

        //     if (first.right != null && second.right != null) {
        //         firstQueue.offer(first.right);
        //         secondQueue.offer(second.right);
        //     } else if (first.right == null && second.right != null
        //     || (first.right != null && second.right == null)) {
        //         return false;
        //     }
        // }

        // return firstQueue.isEmpty() && secondQueue.isEmpty();


        if (p == null && q == null) return true;
        else if (p == null && q != null
            || (p != null && q == null)) return false;
        else if (p.val != q.val) return false;

        boolean isSameTreeLeft = isSameTree(p.left, q.left);
        boolean isSameTreeRight = isSameTree(p.right, q.right);

        return isSameTreeLeft && isSameTreeRight;
    }
}
