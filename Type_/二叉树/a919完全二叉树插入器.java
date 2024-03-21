package Type_.二叉树;

import Common.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 919. 完全二叉树插入器
 * https://leetcode.cn/problems/complete-binary-tree-inserter/description/
 */
public class a919完全二叉树插入器 {


}


class CBTInserter {
    // 这个队列只记录完全二叉树底部可以进行插入的节点
    private final List<TreeNode> queue = new LinkedList<>();
    private final TreeNode root;

    public CBTInserter(TreeNode root) {
        this.root = root;
        // 实例中 初始化输入
        //["CBTInserter", "insert", "insert", "get_root"]
        //[[[1, 2]], [3], [4], []]
        //输出
        //[null, 1, 2, [1, 2, 3, 4]]
        //
        //解释
        //CBTInserter cBTInserter = new CBTInserter([1, 2]);
        //cBTInserter.insert(3);  // 返回 1
        //cBTInserter.insert(4);  // 返回 2
        //cBTInserter.get_root(); // 返回 [1, 2, 3, 4]

        //1. 进行普通的 BFS，目的是找到底部可插入的节点 按照root为构建树
        List<TreeNode> temp = new LinkedList<>();
        temp.addLast(root);
        while (!temp.isEmpty()) {
            TreeNode node = temp.removeFirst();
            if (node.left != null)
                temp.addLast(node.left);
            if (node.right != null)
                temp.addLast(node.right);
            //叶子节点
            if (node.left == null || node.right == null) {
                // 找到完全二叉树底部可以进行插入的节点
                queue.addLast(node);
            }
        }
    }

    public int insert(int val) {
        TreeNode first = queue.getFirst();
        TreeNode node = new TreeNode(val);
        queue.addLast(node);
        if (first.left == null) {
            first.left = node;
            return first.val;
        }
        if (first.right == null) {
            first.right = node;
            queue.removeFirst();
        }
        return first.val;
    }

    public TreeNode get_root() {
        return root;
    }
}