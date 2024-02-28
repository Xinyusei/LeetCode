package Type_.二叉树;

import Common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 106. 从中序与后序遍历序列构造二叉树
 * https://leetcode.cn/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/
 */

public class a106从中序与后序遍历序列构造二叉树 {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(postorder, 0, postorder.length - 1,
                inorder, 0, inorder.length - 1, map);
    }

    /*
    build 函数的定义：
    若后序遍历数组为 postorder[postStart..postEnd]，
    中序遍历数组为 inorder[inStart..inEnd]，
    构造二叉树，返回该二叉树的根节点
*/
    private TreeNode build(int[] postorder, int postStart, int postEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> map) {
        if (inStart > inEnd)
            return null;

        int rootVal = postorder[postEnd];
        int idx = map.get(rootVal);


        TreeNode root = new TreeNode(rootVal);

        int leftTreeSize = idx - inStart;

        root.left = build(postorder, postStart, postStart + leftTreeSize - 1,
                inorder, inStart, idx - 1, map);
        root.right = build(postorder, postStart + leftTreeSize, postEnd - 1,
                inorder, idx + 1, inEnd, map);
        return root;
    }

}
