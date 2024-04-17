package Type_.二叉树;

import Common.TreeNode;

import java.util.*;

/**
 * <a href="https://leetcode.cn/problems/delete-nodes-and-return-forest/description/">1110. 删点成林</a>
 */
public class a1110删点成林 {
    class Solution {
        Set<Integer> set = new HashSet<>();
        List<TreeNode> res = new ArrayList<>();

        public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
            if (root == null)
                return new LinkedList<>();
            for (int c : to_delete) {
                set.add(c);
            }
            doDelete(root, false);
            return res;
        }

        // 定义：输入一棵二叉树，删除 delSet 中的节点，返回删除完成后的根节点
        TreeNode doDelete(TreeNode root, boolean hasParent) {
            if (root == null)
                return null;
            //判断当前节点是否需要删除
            boolean deleted = set.contains(root.val);
            //res中保存都是树的根节点 也就是hasParent = false
            if (!deleted && !hasParent)
                res.add(root);
            //如果delete为true,则该节点需要被删掉,它的左右子树的hasParent应该为false
            root.left = doDelete(root.left, !deleted);
            root.right = doDelete(root.right, !deleted);

            return deleted ? null : root;
        }
    }
}
