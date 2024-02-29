package Type_.二叉树;

import Common.TreeNode;

import java.util.*;

/**
 * 652. 寻找重复的子树
 * https://leetcode.cn/problems/find-duplicate-subtrees/description/
 */
public class a652寻找重复的子树 {

    private Map<String, Integer> map = new HashMap<>();

    private List<TreeNode> res = new LinkedList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        traverse(root);
        return res;
    }

    String traverse(TreeNode node) {
        if (node == null)
            return "#";
        String left = traverse(node.left);
        String right = traverse(node.right);
        String curPath = left + "_" + right + "_" + node.val;

        int freq = map.getOrDefault(curPath, 0);

        if (freq == 1) {
            res.add(node);
        }
        map.put(curPath, freq + 1);

        return curPath;

    }

}
