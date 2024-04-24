package Type_.二叉树;

import Common.TreeNode;

import java.util.*;
import java.util.function.Function;

/**
 * <a href="https://leetcode.cn/problems/amount-of-time-for-binary-tree-to-be-infected/description/">2385. 感染二叉树需要的总时间</a>
 */
public class a2385感染二叉树需要的总时间 {
    class Solution {
        private final Map<Integer, List<TreeNode>> g = new HashMap<>();
        private final Set<Integer> seen = new HashSet<>();
        public int amountOfTime(TreeNode root, int start) {
            buildG(root, null);
            return BFS(start);
        }
        private void buildG(TreeNode node, TreeNode parent) {
            if (node == null)
                return;
            if (parent != null) {
                g.computeIfAbsent(parent.val, key -> new ArrayList<>()).add(node);
            }
            g.computeIfAbsent(node.val, key -> new ArrayList<>()).add(parent);
            buildG(node.left, node);
            buildG(node.right, node);
        }
        private int BFS(int start) {
            List<Integer> queue = new LinkedList<>();
            queue.add(start);
            int width = 0;
            seen.add(start);
            while (!queue.isEmpty() && seen.size() != g.size()) {
                int sz = queue.size();
                for (int i = 0; i < sz; i++) {
                    Integer first = queue.removeFirst();
                    List<TreeNode> neighbor = g.getOrDefault(first, List.of());
                    if (neighbor != null) {
                        for (TreeNode node : neighbor) {
                            if (node != null && !seen.contains(node.val)) {
                                queue.addLast(node.val);
                                seen.add(node.val);
                            }
                        }
                    }
                }
                width++;
            }
            return width;
        }
    }
}
