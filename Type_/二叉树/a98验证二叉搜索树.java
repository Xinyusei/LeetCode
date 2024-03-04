package Type_.二叉树;

import Common.TreeNode;

/**
 * 98. 验证二叉搜索树
 * https://leetcode.cn/problems/validate-binary-search-tree/description/
 */
public class a98验证二叉搜索树 {
    //有效 二叉搜索树定义如下：
    //节点的左子树只包含 小于 当前节点的数。- 即节点左子树的 最大值 小于等于当前节点值
    //节点的右子树只包含 大于 当前节点的数。- 节点右子树的 最小值 大于等于当前节点值
    //所有左子树和右子树自身必须也是二叉搜索树。- 递归定义

    // 根据 BST 的定义，`root` 的整个左子树都要小于 `root.val`，
    // 整个右子树都要大于 `root.val`。
    public boolean isValidBST(TreeNode root) {
        //return traverse1(root, Long.MIN_VALUE, Long.MAX_VALUE);
        return traverse2(root);
    }

    /**
     * 函数表示考虑以 root 为根的子树
     * 判断子树中所有节点的值是否都在 (l,r)(l,r)(l,r) 的范围内（注意是开区间）。
     *
     * @param node
     * @param lower
     * @param upper
     * @return
     */
    boolean traverse1(TreeNode node, long lower, long upper) {
        if (node == null)
            return true;
        //如果该二叉树的左子树不为空，则左子树上所有节点的值均小于它的根节点的值；
        //若它的右子树不空，则右子树上所有节点的值均大于它的根节点的值；它的左右子树也为二叉搜索树。
        if (node.val <= lower || node.val >= upper)
            return false;
        // 在递归调用左子树时，我们需要把上界 upper 改为 root.val，即调用 helper(root.left, lower, root.val)，
        // 因为左子树里所有节点的值均小于它的根节点的值。
        // 递归调用右子树时，我们需要把下界 lower 改为 root.val，即调用 helper(root.right, root.val)
        // 因为右子树所有节点的值均大于它根节点的值
        return traverse1(node.left, lower, node.val) && traverse1(node.right, node.val, upper);
    }

    /**
     * 重点 -BST 的中序遍历一定是一个升序序列
     * 1. 中序遍历BST存入数组来判断 - 效率低
     * @param node
     * @param leftMaxNode
     * @param rightMinNode
     * @return
     */
    //prev 即中序遍历到某节点的前一个数的值 如果符合BST则prev < node.val
    private long prev = Long.MIN_VALUE;

    /**
     * 判断当前node为根的节点是否为一颗合格的BST
     * @param node
     * @return
     */
    boolean traverse2(TreeNode node) {
        if (node == null)
            return true;

        boolean leftValid = traverse2(node.left);
        if (!leftValid || node.val <= prev)
            return false;
        prev = node.val;
        return traverse2(node.right);
    }
}
