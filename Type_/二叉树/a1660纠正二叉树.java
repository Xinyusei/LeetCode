package Type_.二叉树;

import Common.TreeNode;

import java.util.*;

/**
 * 1660纠正二叉树
 * <a href="https://leetcode.cn/problems/correct-a-binary-tree/description/">...</a>
 */
public class a1660纠正二叉树 {
    //你有一棵二叉树，这棵二叉树有个小问题，其中有且只有一个无效节
    //它的右子节点错误地指向了与其在同一层且在其右侧的一个其他节点。

    //给定一棵这样的问题二叉树的根节点 `root`，将该无效节点及其所有子节点移除（除被错误指向的节点外），然后返回新二叉树的根结点。


    //DFS解法
    class Solution1 {
        Set<TreeNode> seen = new HashSet<>();

        public TreeNode correctBinaryTree(TreeNode root) {
            if (root == null) {
                return null;
            }
            if (root.right != null && seen.contains(root.right)) {
                //找到了该无效节点
                return null;
            }
            // 要先遍历右子树，后遍历左子树
            root.right = correctBinaryTree(root.right);
            root.left = correctBinaryTree(root.left);
            seen.add(root);
            return root;


        }
    }

    //BFS解法
    class Solution2 {
        public TreeNode correctBinaryTree(TreeNode root) {
            if (root == null)
                return null;
            List<TreeNode> queue = new LinkedList<>();
            queue.addLast(root);
            Map<TreeNode, TreeNode> map = new HashMap<>();
            map.put(root, null);
            while (!queue.isEmpty()) {
                TreeNode first = queue.removeFirst();
                if (first.right != null) {
                    if (map.containsKey(first.right)) {
                        TreeNode node = map.get(first);
                        if (node.left == first)
                            node.left = null;
                        else
                            node.right = null;
                        break;
                    } else{
                        queue.add(first.right);
                        map.put(first.right, first);
                    }
                }
                if (first.left != null) {
                    map.put(first.left, first);
                    queue.addLast(first.left);
                }
            }
            return root;
        }
    }
}
