package Ev2024_1;

import Common.ListNode;
import com.sun.source.tree.LiteralTree;

/**
 * 82. 删除排序链表中的重复元素 II
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-list-ii/description/?envType=daily-question&envId=2024-01-15
 */
public class a82删除排序链表中的重复元素 {
    /**
     * 保证没有重复元素
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode slow = dummy, fast = head;
        while (fast != null) {
            if (fast.next != null && fast.next.val == fast.val) {
                //发现重复节点,跳过重复节点
                while (fast.next != null && fast.next.val == fast.val)
                    fast = fast.next;
                fast = fast.next;

                //此时还不能让slow直接接fast,因为还没有判断此时fast后面的元素是否还是重复元素
                //1-1-1-2-2这里仅仅跳过1,到达第一个2,还不能接
                if (fast == null)
                    slow.next = fast;
            } else {
                //当前节点不是重复节点
                slow.next = fast;
                slow = slow.next;
                fast = fast.next;
            }
        }
        return dummy.next;
    }

    /**
     * 给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。
     * 仅仅保留一个重复元素
     *
     * @param head
     * @return
     */

    /**
     * 原地前后双指针
     * @param head
     * @return
     */
    public ListNode deleteDuplicates2(ListNode head) {
        ListNode p = head, q = head;
        while (q != null) {
            while (q.val != p.val) {
                p.next = q;
                p = p.next;
            }
            q = q.next;
        }
        p.next = null;
        return head;
    }

    /**
     * 再开一个链表来链接原来的节点
     * @param head
     * @return
     */
    public ListNode deleteDuplicates3(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy, q = head;
        while (q != null) {
            //当前元素是重复元素
            if (q.next != null && q.next.val == q.val) {
                while (q.next != null && q.next.val == q.val)
                    q = q.next;
                p.next = q;
            } else {
                p.next = q;
                p = p.next;
                q = q.next;
            }
        }
        return dummy.next;
    }
}
