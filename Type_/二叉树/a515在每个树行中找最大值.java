package Type_.二叉树;

import Common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 515. 在每个树行中找最大值
 * https://leetcode.cn/problems/find-largest-value-in-each-tree-row/description/
 */
public class a515在每个树行中找最大值 {
    public List<Integer> largestValues(TreeNode root) {
        List<TreeNode> queue = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        queue.addLast(root);

        while (!queue.isEmpty()) {
            int sz = queue.size();
            int levelMaxVal = queue.getFirst().val;
            for (int i = 0; i < sz; i++) {
                TreeNode first = queue.removeFirst();
                if (i != 0 && first.val > levelMaxVal)
                    levelMaxVal = first.val;
                if (first.left != null)
                    queue.addLast(first.left);
                if (first.right != null)
                    queue.addLast(first.right);
            }
            res.addLast(levelMaxVal);
        }
        return res;
    }
}
