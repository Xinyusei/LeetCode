package Type_.二叉树;

import Common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 987. 二叉树的垂序遍历
 * https://leetcode.cn/problems/vertical-order-traversal-of-a-binary-tree/description/
 */
public class a987二叉树的垂序遍历 {
    class Triple {
        int x;
        int y;
        TreeNode node;

        public Triple(int x, int y, TreeNode node) {
            this.x = x;
            this.y = y;
            this.node = node;
        }
    }


    public List<List<Integer>> verticalTraversal(TreeNode root) {
        // 遍历二叉树，并且为所有节点生成对应的坐标
        traverse(root, 0, 0);

        // 根据题意，根据坐标值对所有节点进行排序：
        // 按照 y 从小到大排序，y 相同的话按 x 从小到大排序，
        // 如果 y 和 x 都相同，按照 node.val 从小到大排序。
        nodes.sort((Triple a, Triple b) -> {
            if (a.y == b.y && a.x == b.x)
                return a.node.val - b.node.val;
            if (a.y == b.y)
                return a.x - b.x;
            return a.y - b.y;
        });
        //将排好序的节点组装成题目要求的格式
        int preY = Integer.MIN_VALUE;
        LinkedList<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < nodes.size(); i++) {
            Triple cur = nodes.get(i);
            if (cur.y != preY) {
                // 开始记录新的一列
                res.addLast(new LinkedList<>());
                preY = cur.y;
            }
            res.getLast().add(cur.node.val);
        }
        return res;
    }

    List<Triple> nodes = new ArrayList<>();

    public void traverse(TreeNode root, int x, int y) {
        if (root == null)
            return;
        nodes.add(new Triple(x, y, root));
        traverse(root.left, x + 1, y - 1);
        traverse(root.right, x + 1, y + 1);
    }
}
