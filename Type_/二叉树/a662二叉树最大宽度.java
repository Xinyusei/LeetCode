package Type_.二叉树;

import Common.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * 662. 二叉树最大宽度
 * https://leetcode.cn/problems/maximum-width-of-binary-tree/description/
 */
public class a662二叉树最大宽度 {
    /**
     * 层序遍历 + 编号
     *
     * @param root
     * @return
     */
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


    //记录 每层出现最小的编号
    private final HashMap<Integer, Integer> map = new HashMap<>();
    //层数
    private int deep = 0;

    //结果
    private int result = 0;

    /**
     * DFS + 编号
     * @param root
     * @return
     */
    public int widthOfBinaryTree2(TreeNode root) {
        traverse(root);
        return result;
    }

    //前序遍历 根左右
    public void traverse(TreeNode root) {
        if (root == null)
            return;

        deep++;
        if (root.left != null)
            root.left.val = root.val * 2;
        if (root.right != null)
            root.right.val = root.val * 2 + 1;
        //刚进入的时候一定是该层最小的编号
        map.putIfAbsent(deep, root.val);
        //这一层每遇到一个节点就计算其与最小编号的差
        result = Math.max(result, root.val - map.get(deep) + 1);

        traverse(root.left);
        traverse(root.right);

        deep--;

    }
}
