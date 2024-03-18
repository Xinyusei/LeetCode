package Type_.二叉树;

import Common.ListNode;
import Common.TreeNode;

/**
 * 1367. 二叉树中的链表
 * https://leetcode.cn/problems/linked-list-in-binary-tree/description/
 */
public class a1367二叉树中的链表 {
    public boolean isSubPath(ListNode head, TreeNode root) {
        if (head == null) return true;
        if (root == null) return false;
        if (isSamePath(head, root))
            return true;
        return isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    public boolean isSamePath(ListNode head, TreeNode root) {
        if (head == null) return true;
        if (root == null) return false;
        if (head.val != root.val)
            return false;
        return isSamePath(head.next, root.left) || isSamePath(head.next, root.right);

    }
}
