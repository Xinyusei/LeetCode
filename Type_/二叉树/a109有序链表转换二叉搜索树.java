package Type_.二叉树;

import Common.ListNode;
import Common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 109. 有序链表转换二叉搜索树
 * <a href="https://leetcode.cn/problems/convert-sorted-list-to-binary-search-tree/description/">...</a>
 */
public class a109有序链表转换二叉搜索树 {
    class Solution1 {
        List<Integer> arr = new ArrayList<>();

        public TreeNode sortedListToBST(ListNode head) {
            List<Integer> arr = traverse(head);
            return build(arr, 0, arr.size() - 1);
        }

        public List<Integer> traverse(ListNode head) {
            if (head == null)
                return arr;
            arr.add(head.val);
            traverse(head.next);

            return arr;

        }

        public TreeNode build(List<Integer> nums, int lo, int hi) {
            if (lo > hi)
                return null;
            int idx = (lo + hi) / 2;
            TreeNode root = new TreeNode(nums.get(idx));
            root.left = build(nums, lo, idx - 1);
            root.right = build(nums, idx + 1, hi);

            return root;

        }
    }

    class Solution2 {
        public TreeNode sortedListToBST(ListNode head) {
            return build(head, null);
        }

        public TreeNode build(ListNode begin, ListNode end) {
            if (begin == end)
                return null;

            ListNode mid = getMid(begin, end);
            TreeNode root = new TreeNode(mid.val);
            root.left = build(begin, mid);
            root.right = build(mid.next, end);

            return root;
        }

        public ListNode getMid(ListNode begin, ListNode end) {
            ListNode slow = begin, fast = begin;
            while (fast != end && fast.next != end) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }
    }

    class Solution3 {
        ListNode cur;

        public TreeNode sortedListToBST(ListNode head) {
            int len = 0;
            for (ListNode p = head; p != null; p = p.next)
                len++;

            cur = head;
            return inorderBuild(0, len - 1);
        }

        public TreeNode inorderBuild(int left, int right) {
            if (left > right)
                return null;

            int mid = (right - left) >> 1 + left;
            TreeNode leftTree = inorderBuild(left, mid - 1);

            TreeNode root = new TreeNode(cur.val);
            cur = cur.next;

            TreeNode rightTree = inorderBuild(mid + 1,right);

            root.left = leftTree;
            root.right = rightTree;
            return root;

        }

    }

}
