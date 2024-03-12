package Type_.二叉树;

import Common.TreeNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 1261. 在受污染的二叉树中查找元素
 * https://leetcode.cn/problems/find-elements-in-a-contaminated-binary-tree/description/
 */
public class a1261在受污染的二叉树中查找元素 {
}

class FindElements {
    private final Set<Integer> s = new HashSet<>();

    public FindElements(TreeNode root) {
        recover(root, 0);
    }

    public void recover(TreeNode root, int val) {
        if (root == null)
            return;
        s.add(val);
        root.val = val;
        recover(root.left, val * 2 + 1);
        recover(root.right, val * 2 + 2);
    }

    public boolean find(int target) {
        return s.contains(target);
    }
}
