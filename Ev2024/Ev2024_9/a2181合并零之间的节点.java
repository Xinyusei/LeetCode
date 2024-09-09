package Ev2024.Ev2024_9;

import Common.ListNode;

/**
 * @Author: ZJX
 * @Date: 2024/09/09
 * @Description: <a href="https://leetcode.cn/problems/merge-nodes-in-between-zeros/">2181. 合并零之间的节点</a>
 * 耗时:10分钟
 */
public class a2181合并零之间的节点 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode mergeNodes(ListNode head) {
            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            ListNode lo = head.next, hi = head.next;
            while (hi != null) {
                int curSum = 0;
                while (hi != null && hi.val != 0) {
                    curSum += hi.val;
                    hi = hi.next;
                }
                if (hi == null)
                    break;
                lo.val = curSum;
                lo.next = hi.next;
                lo = hi.next;
                hi = hi.next;
            }
            return dummy.next;
        }
    }
}
