package Type_.二叉树;

import Common.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * 1302. 层数最深叶子节点的和
 * https://leetcode.cn/problems/deepest-leaves-sum/description/
 */
public class a1302层数最深叶子节点的和 {
    /**
     * BFS 模版
     *
     * @param root
     * @return
     */
    public int deepestLeavesSum2(TreeNode root) {
        int preLevelSum = 0;
        List<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        while (!queue.isEmpty()) {
            int sz = queue.size();
            int levelSum = 0;
            for (int i = 0; i < sz; i++) {
                TreeNode first = queue.removeFirst();
                levelSum += first.val;
                if (first.left != null)
                    queue.addLast(first.left);
                if (first.right != null)
                    queue.addLast(first.right);
            }
            preLevelSum = levelSum;
        }
        return preLevelSum;
    }


    /**
     * DFS
     *
     * @param root
     * @return
     */
    HashMap<Integer, Integer> map;

    int maxDepth = 1;

    public int deepestLeavesSum(TreeNode root) {
        map = new HashMap<Integer, Integer>();
        traverse(root, 1);
        return map.get(maxDepth);
    }

    public void traverse(TreeNode root, int deep) {
        if (root == null)
            return;

        map.put(deep, root.val + map.getOrDefault(deep, 0));
        maxDepth = Math.max(maxDepth, deep);
        traverse(root.left, deep + 1);
        traverse(root.right, deep + 1);

    }
}
