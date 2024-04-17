package Type_.二叉树;

import Common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/maximum-binary-tree-ii/description/">998. 最大二叉树 II</a>
 */
public class a998最大二叉树II {
    class Solution {


        public TreeNode insertIntoMaxTree(TreeNode root, int val) {
            if (root == null)
                return new TreeNode(val);
            if (root.val < val) {
                TreeNode node = new TreeNode(val);
                node.left = root;
                return node;
            } else {
                root.right = insertIntoMaxTree(root.right, val);
            }

            return root;

        }

    }
}
