package Type_.二叉树;

import Common.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 1609. 奇偶树
 * https://leetcode.cn/problems/even-odd-tree/description/
 */
public class a1609奇偶树 {
    public boolean isEvenOddTree(TreeNode root) {
        boolean even = true;
        List<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        while (!queue.isEmpty()) {
            int sz = queue.size();
            // 记录前一个节点，便于判断是否递增/递减
            int prev = even ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            for (int i = 0; i < sz; i++) {
                TreeNode first = queue.removeFirst();
                //偶数下标 层上的所有节点的值都是 奇 整数，从左到右按顺序 严格递增
                if (even) {
                    if ((first.val & 1) == 0 || prev >= first.val)
                        return false;
                    //奇数下标 层上的所有节点的值都是 偶 整数，从左到右按顺序 严格递减
                } else {
                    if ((first.val & 1) != 0 || prev <= first.val)
                        return false;
                }
                if (first.left != null)
                    queue.addLast(first.left);
                if (first.right != null)
                    queue.addLast(first.right);
                prev = first.val;
            }
            even = !even;
        }
        return true;
    }
}
