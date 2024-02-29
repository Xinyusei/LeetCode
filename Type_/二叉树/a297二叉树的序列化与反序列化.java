package Type_.二叉树;

import Common.TreeNode;

import java.util.LinkedList;

/**
 * 297. 二叉树的序列化与反序列化
 * https://leetcode.cn/problems/serialize-and-deserialize-binary-tree/description/
 */
public class a297二叉树的序列化与反序列化 {
    private final String SEP_SYMBOL = ",";
    private final String NULL_SYMBOL = "#";

    // Encodes a tree to a single string.

    //#,#,2,#,#,4,#,#,5,3,1
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        traverse2Str(root, sb);
        return sb.toString();
    }

    // Decodes your encoded data to tree.

    //#_#_2_#_#_4_#_#_5_3_1
    public TreeNode deserialize(String data) {
        String[] split = data.split(SEP_SYMBOL);
        LinkedList<String> nodes = new LinkedList<>();
        for (String s : split) {
            nodes.addLast(s);
        }
        return traverse2Tree(nodes);
    }

    //1,2,#,#,3,4,#,#,5,#,#,
    void traverse2Str(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(NULL_SYMBOL).append(SEP_SYMBOL);
            return;
        }
        /****** 前序位置 ******/
        sb.append(root.val).append(SEP_SYMBOL);
        /********************/
        traverse2Str(root.left, sb);
        traverse2Str(root.right, sb);
    }

    //[1,2,#,#,3,4,#,#,5,#,#]
    TreeNode traverse2Tree(LinkedList<String> nodes) {
        if (nodes.isEmpty())
            return null;

        String first = nodes.removeFirst();
        if (first.equals(NULL_SYMBOL))
            return null;
        TreeNode treeNode = new TreeNode(Integer.parseInt(first));
        treeNode.left = traverse2Tree(nodes);
        treeNode.right = traverse2Tree(nodes);

        return treeNode;

    }

    //    LinkedList<Integer> res;
//
//    //1,2,-1,-1,3,4,-1,-1,5,-1,-1
//    void traverseToList(TreeNode root) {
//        if (root == null) {
//            res.add(-1);
//            return;
//        }
//        res.addLast(root.val);
//        traverseToList(root.left);
//        traverseToList(root.right);
//    }
}
