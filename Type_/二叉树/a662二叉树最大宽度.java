package Type_.二叉树;

import Common.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * 662. 二叉树最大宽度
 * https://leetcode.cn/problems/maximum-width-of-binary-tree/description/
 */
public class a662二叉树最大宽度 {
    public int widthOfBinaryTree(TreeNode root) {
        //  1
        // 2 3
        //4 5 7
        List<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        root.val = 1;
        int res = 0;
        while (!queue.isEmpty()) {
            int sz = queue.size();
            res = Math.max(res, queue.getLast().val - queue.getFirst().val + 1);
            for (int i = 0; i < sz; i++) {
                TreeNode first = queue.removeFirst();
                if (first.left != null) {
                    first.left.val = first.val * 2;
                    queue.addLast(first.left);
                }
                if (first.right != null) {
                    first.right.val = first.val * 2 + 1;
                    queue.addLast(first.right);
                }
            }
        }
        return res;
    }
}
