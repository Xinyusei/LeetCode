package Type_.二叉树;

import Common.TreeNode;

import javax.swing.plaf.SeparatorUI;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class a637二叉树的层平均值 {
    public List<Double> averageOfLevels(TreeNode root) {
        List<TreeNode> queue = new LinkedList<>();
        List<Double> res = new ArrayList<>();
        if (root == null)
            return res;
        queue.addLast(root);

        while (!queue.isEmpty()) {
            int sz = queue.size();
            long sum = 0;
            for (int i = 0; i < sz; i++) {
                TreeNode first = queue.removeFirst();
                sum += first.val;
                if (first.left != null)
                    queue.addLast(first.left);
                if (first.right != null)
                    queue.addLast(first.right);
            }
            res.addLast(1.0 * sum / sz);
        }
        return res;
    }
}
