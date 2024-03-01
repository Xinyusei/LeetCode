package Type_.二叉树;

import Common.TreeNode;

import javax.swing.tree.TreeCellRenderer;
import java.util.LinkedList;
import java.util.List;

/**
 * 297. 二叉树的序列化与反序列化
 * https://leetcode.cn/problems/serialize-and-deserialize-binary-tree/description/
 */
public class a297二叉树的序列化与反序列化 {
    private final String SEP_SYMBOL = ",";
    private final String NULL_SYMBOL = "#";

    private final Integer NULL_VAL = 1100;


    // Encodes a tree to a single string.

    //#,#,2,#,#,4,#,#,5,3,1
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();

        //前序遍历序列化二叉树
        //inTraverse2Str(root, sb);

        //后序遍历序列化二叉树
        //postTraverse2Str(root, sb);

        //层序遍历序列化二叉树
        levelTraverse2Str(root, sb);
        return sb.toString();
    }

    // Decodes your encoded data to tree.

    //1,2,#,#,3,4,#,#,5,#,#,
    public TreeNode deserialize(String data) {
        if(data.isEmpty()) return null;
        String[] split = data.split(SEP_SYMBOL);
        LinkedList<String> nodes = new LinkedList<>();
        for (String s : split) {
            nodes.addLast(s);
        }

        //前序遍历对应的反序列化
        //return inTraverse2Tree(nodes);

        //后序遍历对应的反序列化
        //return postTraverse2Tree(nodes);

        //层序遍历对应的反序列化
        return levelTraverse2Tree(nodes);
    }


    /**
     * 层序遍历序列化二叉树
     *
     * @param root
     * @param sb
     */
    //1,2,3,#,#,4,5,#,#,#,#,
    void levelTraverse2Str(TreeNode root, StringBuilder sb) {
        if (root == null)
            return;
        List<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.removeFirst();
                if(node == null){
                    sb.append(NULL_SYMBOL).append(SEP_SYMBOL);
                    continue;
                }
                sb.append(node.val).append(SEP_SYMBOL);
                queue.addLast(node.left);
                queue.addLast(node.right);
            }
        }
    }

    //[1,2,3,#,#,4,5,#,#,#,#]
    TreeNode levelTraverse2Tree(LinkedList<String> nodesList) {
        if (nodesList.isEmpty())
            return null;
        LinkedList<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(nodesList.removeFirst()));
        queue.addLast(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode treeNode = queue.removeFirst();
                String leftString = nodesList.removeFirst();
                if(!leftString.equals(NULL_SYMBOL)){
                    treeNode.left = new TreeNode(Integer.parseInt(leftString));
                    queue.addLast(treeNode.left);
                }
                String rightString = nodesList.removeFirst();
                if (!rightString.equals(NULL_SYMBOL)) {
                    treeNode.right = new TreeNode(Integer.parseInt(rightString));
                    queue.addLast(treeNode.right);
                }
            }
        }
        return root;
    }

    /**
     * 前序遍历 序列化二叉树
     *
     * @param root
     * @param sb
     */
    //1,2,#,#,3,4,#,#,5,#,#,
    void inTraverse2Str(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(NULL_SYMBOL).append(SEP_SYMBOL);
            return;
        }
        /****** 前序位置 ******/
        sb.append(root.val).append(SEP_SYMBOL);
        /********************/
        inTraverse2Str(root.left, sb);
        inTraverse2Str(root.right, sb);
    }

    /**
     * 与前序遍历相对应 反序列二叉树
     *
     * @param nodes
     * @return
     */
    //[1,2,#,#,3,4,#,#,5,#,#]
    TreeNode inTraverse2Tree(LinkedList<String> nodes) {
        if (nodes.isEmpty())
            return null;

        String first = nodes.removeFirst();
        if (first.equals(NULL_SYMBOL))
            return null;
        TreeNode treeNode = new TreeNode(Integer.parseInt(first));
        treeNode.left = inTraverse2Tree(nodes);
        treeNode.right = inTraverse2Tree(nodes);

        return treeNode;
    }

    /**
     * 后序遍历 序列化二叉树
     *
     * @param root
     * @param sb
     */

    //#,#,2,#,#,4,#,#,5,3,1,
    void postTraverse2Str(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(NULL_SYMBOL).append(SEP_SYMBOL);
            return;
        }
        postTraverse2Str(root.left, sb);
        postTraverse2Str(root.right, sb);

        sb.append(root.val).append(SEP_SYMBOL);
    }

    //#,#,2,#,#,4,#,#,5,3,1,
    TreeNode postTraverse2Tree(LinkedList<String> nodes) {
        if (nodes.isEmpty())
            return null;
        String last = nodes.removeLast();
        if (last.equals(NULL_SYMBOL))
            return null;
        TreeNode treeNode = new TreeNode(Integer.parseInt(last));
        treeNode.right = postTraverse2Tree(nodes);
        treeNode.left = postTraverse2Tree(nodes);

        return treeNode;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;

        a297二叉树的序列化与反序列化 test = new a297二叉树的序列化与反序列化();
        String dataString = test.serialize(node1);
        System.out.println(dataString);
        System.out.println(test.deserialize(dataString));

    }

}
