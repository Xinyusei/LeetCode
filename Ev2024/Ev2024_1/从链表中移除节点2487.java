package Ev2024.Ev2024_1;

import Common.ListNode;

/**
 * https://leetcode.cn/problems/remove-nodes-from-linked-list/description/
 * 2487. 从链表中移除节点
 */
public class 从链表中移除节点2487 {
    /**
     * 单调栈 + 头插法 1
     *
     * @param head
     * @return
     */

    /*
    public ListNode removeNodes(ListNode head) {
        ArrayDeque<ListNode> stack = new ArrayDeque<>();
        for (; head != null; head = head.next) {
            stack.push(head);
        }
        // 5 2 13 3 8 反着来,从8往前面看,保证序列单调不减
        for (; !stack.isEmpty(); stack.pop()) {
            if (head == null || stack.peek().val >= head.val) {
                stack.peek().next = head;
                head = stack.peek();
            }
        }
        return head;
    }
    */


    /**
     * 单调栈2
     * @param head
     * @return
     */

    /*
    public ListNode removeNodes(ListNode head) {
        ArrayList<Integer> nums = new ArrayList<>();
        while (head != null) {
            nums.add(head.val);
            head = head.next;
        }
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (Integer num : nums) {
            while (!stack.isEmpty() && stack.peek() < num) {
                stack.pop();
            }
            stack.push(num);
        }
        ListNode dummy = new ListNode();
        head = dummy;
        while (!stack.isEmpty()) {
            ListNode node = new ListNode(stack.peek());
            node.next = head;
            head = node;
            stack.pop();
        }
        return dummy.next;
    }
    */

    /**
     * 递归
     * @param head
     * @return
     */
    public ListNode removeNodes(ListNode head) {
        //当前节点要做的事情:
        if(head == null)
            return null;

        head.next = removeNodes(head.next);
        if(head.next != null && head.val < head.next.val){
            head = head.next;
        }
        return head;
    }
}
