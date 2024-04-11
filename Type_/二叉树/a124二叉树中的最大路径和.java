package Type_.二叉树;

import Common.TreeNode;

/**
 * 124. 二叉树中的最大路径和
 * <a href="https://leetcode.cn/problems/binary-tree-maximum-path-sum/description/">...</a>
 */
public class a124二叉树中的最大路径和 {
    class Solution1 {
        private Integer res = Integer.MIN_VALUE;

        public int maxPathSum(TreeNode root) {
            oneSideMax(root);

            return res;
        }

        //以该节点为根节点的子树中 寻找以该节点为起点的一条路径，使得该路径上的节点值之和最大。
        public int oneSideMax(TreeNode root) {
            if (root == null)
                return 0;
            // 如果子节点的最大贡献值为正，则计入该节点的最大路径和，否则不计入该节点的最大路径和
            int leftMax = Math.max(oneSideMax(root.left), 0);
            int rightMax = Math.max(oneSideMax(root.right), 0);
            // 节点的最大路径和取决于该节点的值与该节点的左右子节点的最大贡献值
            int pathMax = root.val + leftMax + rightMax;
            //更新
            res = Math.max(pathMax, res);
            // 节点的最大路径和取决于该节点的值与该节点的左右子节点的最大贡献值
            // 返回节点的最大贡献值
            return root.val + Math.max(leftMax, rightMax);


        }


    }
}
