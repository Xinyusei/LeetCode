package Type_.二叉树;

import Common.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * 958. 二叉树的完全性检验
 * https://leetcode.cn/problems/check-completeness-of-a-binary-tree/description/
 */
public class a958二叉树的完全性检验 {


    public boolean isCompleteTree(TreeNode root) {
        // 遍历完所有非空节点时变成 true
        boolean end = false;
        List<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        while (!queue.isEmpty()) {
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                TreeNode first = queue.removeFirst();
                if (first == null) {
                    // 第一次遇到 null 时 end 变成 true
                    // 如果之后的所有节点都是 null，则说明是完全二叉树
                    end = true;
                } else {
                    if (end)
                        return false;
                    queue.addLast(first.left);
                    queue.addLast(first.right);
                }
            }
        }
        return end;
    }


    //最大编号
    int maxIndex = 0;

    //二叉树的节点数量
    int nodeCnt = 0;

    public boolean isCompleteTree(TreeNode root) {
        traverse(root, 1);

        //如果二叉树节点数量与最大编号相同则是完全二叉树。 因为编号对应下来是 1234 且不会有间隙。 才是完全二叉树
        return nodeCnt == maxIndex;
    }

    void traverse(TreeNode root, int index) {
        if (root == null)
            return;

        nodeCnt++;
        maxIndex = Math.max(maxIndex, index);
        traverse(root.left, index * 2);
        traverse(root.right, index * 2 + 1);

    }
}



