package Type_.二叉树;

import Common.TreeNode;

import java.util.*;

/**
 * 742. 二叉树最近的叶节点
 * https://leetcode.cn/problems/closest-leaf-in-a-binary-tree/description/
 */
public class a742二叉树最近的叶节点 {

}

class a742Solution {
    public int findClosestLeaf(TreeNode root, int k) {
        // 找到目标节点并构建所需的子节点到父节点的映射
        traverse(root, k, null);
        // 执行 BFS 算法
        Queue<TreeNode> q = new LinkedList<>();
        HashSet<TreeNode> visited = new HashSet<>();
        q.offer(target);
        visited.add(target);

        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                TreeNode cur = q.poll();
                if (cur.left == null && cur.right == null) {
                    // BFS 首次到达的叶子结点就是最近的叶子结点
                    return cur.val;
                }
                if (cur.left != null && !visited.contains(cur.left)) {
                    q.offer(cur.left);
                    visited.add(cur.left);
                }
                if (cur.right != null && !visited.contains(cur.right)) {
                    q.offer(cur.right);
                    visited.add(cur.right);
                }
                TreeNode parentNode = parentMap.get(cur);
                if (parentNode != null && !visited.contains(parentNode)) {
                    q.offer(parentNode);
                    visited.add(parentNode);
                }
            }
        }
        return -1;
    }

    TreeNode target = null;
    HashMap<TreeNode, TreeNode> parentMap = new HashMap<>();

    // 遍历函数，找到值为 k 的那个节点，同时记录子节点到父节点的映射
    void traverse(TreeNode root, int k, TreeNode parent) {
        if (root == null || target != null) {
            return;
        }
        // 记录子节点到父节点的映射
        parentMap.put(root, parent);

        if (root.val == k) {
            target = root;
            return;
        }

        traverse(root.left, k, root);
        traverse(root.right, k, root);
    }

}

class a742Solution2 {

    private int k;
    private TreeNode target = null;
    private final Map<Integer, TreeNode> parent = new HashMap<>();
    private final Set<Integer> visited = new HashSet<>();

    private TreeNode res = null;

    public int findClosestLeaf(TreeNode root, int k) {
        this.k = k;
        traverse(root, null);
        DFS(root);
        return res.val;
    }

    private void traverse(TreeNode root, TreeNode parentNode) {
        if (root == null)
            return;
        parent.put(root.val, parentNode);
        if (root.val == k)
            target = root;
        traverse(root.left, root);
        traverse(root.right, root);
    }

    private void DFS(TreeNode node) {
        if (node == null || visited.contains(node.val) || res != null)
            return;

        if (node.left == node.right)
            res = node;
        visited.add(node.val);
        DFS(parent.get(node.val));
        DFS(node.left);
        DFS(node.right);
    }

}
