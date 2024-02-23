package Type_.二叉树;

import Common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的前序遍历
 * https://leetcode.cn/problems/binary-tree-preorder-traversal/description/
 */
public class a144二叉树的前序遍历 {


    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;

        res.add(root.val);
        res.addAll(preorderTraversal(root.left));
        res.addAll(preorderTraversal(root.right));

        return res;
    }


    //方法1-传统前序遍历
//    private List<Integer> res = new ArrayList<>();
//
//    public List<Integer> preorderTraversal(TreeNode root) {
//        traverse(root);
//        return res;
//    }
//
//    private void traverse(TreeNode node) {
//        if (node == null)
//            return;
//
//        //前序位置
//        res.add(node.val);
//        traverse(node.left);
//        traverse(node.right);
//
//    }
}
