package Type_.二叉树;

import Common.TreeNode;

/**
 * 1379. 找出克隆二叉树中的相同节点
 * <a href="https://leetcode.cn/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree/description/?envType=daily-question&envId=2024-04-03">...</a>
 */
public class a1379找出克隆二叉树中的相同节点 {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (cloned == null || target == null)
            return null;
        TreeNode leftTree = getTargetCopy(original, cloned.left, target);
        if (leftTree != null)
            return leftTree;
        if (cloned.val == target.val)
            return cloned;
        return getTargetCopy(original, cloned.right, target);

    }

}

