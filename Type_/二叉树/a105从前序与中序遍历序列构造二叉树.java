package Type_.二叉树;

import Common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 * https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
 */
public class a105从前序与中序遍历序列构造二叉树 {


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }


        return build(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1, map);


    }

    /*
    build 函数的定义：
    若前序遍历数组为 preorder[preStart..preEnd]，
    中序遍历数组为 inorder[inStart..inEnd]，
    构造二叉树，返回该二叉树的根节点
*/
    private TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> map) {
        if (inStart > inEnd)
            return null;

        int rootVal = preorder[preStart];
        int idx = map.get(rootVal);

        TreeNode root = new TreeNode(rootVal);

        int leftTreeSize = idx - inStart;
        root.left = build(preorder, preStart + 1, preStart + leftTreeSize, inorder, inStart, idx - 1, map);
        root.right = build(preorder, preStart + leftTreeSize + 1, preEnd, inorder, idx + 1, inEnd, map);
        return root;
    }

}
