package Type_.二叉树;

import Common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static Type_.二叉树.a102二叉树的层序遍历.res;

/**
 * 1161. 最大层内元素和
 * https://leetcode.cn/problems/maximum-level-sum-of-a-binary-tree/description/
 */
public class a1161最大层内元素和 {
    public int maxLevelSum(TreeNode root) {
        int deep = 0, resDeep = 0, maxSum = Integer.MIN_VALUE;
        List<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        while (!queue.isEmpty()) {
            int sz = queue.size();
            int levelSum = 0;
            deep++;
            for (int i = 0; i < sz; i++) {
                TreeNode first = queue.removeFirst();
                levelSum += first.val;
                if (first.left != null)
                    queue.addLast(first.left);
                if (first.right != null)
                    queue.addLast(first.right);
            }
            if (levelSum > maxSum) {
                maxSum = levelSum;
                resDeep = deep;
            }
        }
        return resDeep;
    }
}
