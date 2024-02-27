package Type_.二叉树;


import Common.TreeNode;
import org.w3c.dom.Node;

import java.lang.annotation.Target;
import java.util.*;

/**
 * 102. 二叉树的层序遍历
 * https://leetcode.cn/problems/binary-tree-level-order-traversal/description/
 */
public class a102二叉树的层序遍历 {
    public static TreeNode initTree() {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);
        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node2.right = node4;

        return root;
    }


//    public static List<List<Integer>> levelOrder(TreeNode root) {
//        List<List<Integer>> res = new ArrayList<>();
//        Deque<TreeNode> queue = new LinkedList<>();
//        if (root == null)
//            return res;
//        queue.addLast(root);
//        while (!queue.isEmpty()) {
//            int sz = queue.size();
//            ArrayList<Integer> list = new ArrayList<>();
//            for (int i = 0; i < sz; i++) {
//                TreeNode node = queue.removeFirst();
//                if (node.left != null)
//                    queue.addLast(node.left);
//                if (node.right != null)
//                    queue.addLast(node.right);
//                list.add(node.val);
//            }
//            res.add(list);
//        }
//        return res;
//    }

    private static List<List<Integer>> res = new ArrayList<>();

    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null)
            return res;
        LinkedList<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        traverse(nodes);
        return res;
    }

    public static void traverse(List<TreeNode> nodes) {
        //base case
        if (nodes.isEmpty())
            return;
        //前序位置
        LinkedList<Integer> curLevelVal = new LinkedList<>();
        LinkedList<TreeNode> nextLevelNodes = new LinkedList<>();
        for (TreeNode node : nodes) {
            curLevelVal.addLast(node.val);
            if (node.left != null)
                nextLevelNodes.addLast(node.left);
            if (node.right != null)
                nextLevelNodes.addLast(node.right);
        }
        res.add(curLevelVal);
        traverse(nextLevelNodes);
    }

    public static void main(String[] args) {
        TreeNode root = initTree();
        List<List<Integer>> arrList = levelOrder(root);
        for (int i = 0; i < arrList.size(); i++) {
            for (int i1 = 0; i1 < arrList.get(i).size(); i1++) {
                System.out.print(arrList.get(i).get(i1) + " ");
            }
            System.out.println();
        }
    }
}
