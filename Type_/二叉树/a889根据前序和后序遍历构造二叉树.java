package Type_.二叉树;

import Common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 889. 根据前序和后序遍历构造二叉树
 * https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-postorder-traversal/description/
 */
public class a889根据前序和后序遍历构造二叉树 {
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < postorder.length; i++) {
            map.put(postorder[i], i);
        }

        return build(preorder, 0, preorder.length - 1,
                postorder, 0, postorder.length - 1,
                map);
    }

    public TreeNode build(int[] preorder, int preStart, int preEnd,
                          int[] postorder, int postStart, int postEnd,
                          Map<Integer, Integer> map) {

        if (preStart > preEnd)
            return null;
        if (preStart == preEnd)
            return new TreeNode(preorder[preStart]);

        //root 根节点的值就是前序遍历数组第一个元素
        int rootVal = preorder[preStart], idxRoot = map.get(rootVal);
        TreeNode root = new TreeNode(rootVal);

        int idxLeft = map.get(preorder[preStart + 1]);

        int leftSize = idxLeft - postStart + 1;

        root.left = build(preorder, preStart + 1, preStart + leftSize,
                postorder, postStart, idxLeft, map);
        root.right = build(preorder, preStart + leftSize + 1, preEnd,
                postorder, idxLeft + 1, postEnd - 1, map);

        return root;

    }
}
