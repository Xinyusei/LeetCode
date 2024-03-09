package Type_.二叉树;

import Common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 199. 二叉树的右视图
 * https://leetcode.cn/problems/binary-tree-right-side-view/description/
 */
public class a199二叉树的右视图 {

    public List<Integer> rightSideView(TreeNode root) {
        List<TreeNode> queue = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        queue.addLast(root);
        while (!queue.isEmpty()) {
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                TreeNode node = queue.removeFirst();
                //只添加每层的第一个元素
                if (i == 0)
                    res.addLast(node.val);
                //由于是先添加右节点,所有得到的右视图
                if (node.right != null)
                    queue.addLast(node.right);
                if (node.left != null)
                    queue.addLast(node.left);

            }
        }
        return res;
    }
}
