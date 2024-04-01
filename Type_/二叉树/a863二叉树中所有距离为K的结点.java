package Type_.二叉树;

import Common.TreeNode;

import javax.swing.*;
import java.util.*;

/**
 * 863. 二叉树中所有距离为 K 的结点
 * https://leetcode.cn/problems/all-nodes-distance-k-in-binary-tree/description/
 */
public class a863二叉树中所有距离为K的结点 {
    /* BFS 版本 */
    // 记录父节点：node.val -> parentNode
    // 题目说了树中所有节点值都是唯一的，所以可以用 node.val 代表 TreeNode
    private final Map<Integer, TreeNode> parent = new HashMap<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        //遍历 得到每个节点的父节点
        traverse(root, null);
        List<Integer> res = new LinkedList<>();
        List<TreeNode> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        //从target节点 开始BFS算法，找到距离为K的节点
        q.addLast(target);
        visited.add(target.val);

        //记录距离 target的距离
        int dist = 0;
        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                TreeNode first = q.removeFirst();
                if (dist == k) {
                    // 找到距离起点 target 距离为 k 的节点
                    res.addLast(first.val);
                }
                TreeNode parentNode = parent.get(first.val);
                if (parentNode != null && !visited.contains(parentNode.val)) {
                    visited.add(parentNode.val);
                    q.addLast(parentNode);
                }
                if (first.left != null && !visited.contains(first.left.val)) {
                    visited.add(first.left.val);
                    q.addLast(first.left);
                }
                if (first.right != null && !visited.contains(first.right.val)) {
                    visited.add(first.right.val);
                    q.addLast(first.right);
                }
            }
            dist++;
        }
        return res;
    }


    private void traverse(TreeNode root, TreeNode parentNode) {
        if (root == null)
            return;
        parent.put(root.val, parentNode);
        traverse(root.left, root);
        traverse(root.right, root);
    }
}

class Solution {

    private final Map<Integer, TreeNode> parent = new HashMap<>();
    private final Set<Integer> visited = new HashSet<>();
    private final List<Integer> res = new ArrayList<>();

    /**
     * DFS
     * @param root 
     * @param target
     * @param k
     * @return
     */
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        traverse(root, null);
        DFS(target, 0, k);
        return res;
    }

    private void traverse(TreeNode root, TreeNode parentNode) {
        if (root == null)
            return;
        parent.put(root.val, parentNode);
        traverse(root.left, root);
        traverse(root.right, root);
    }

    private void DFS(TreeNode node, int dist, int k) {
        if (node == null || visited.contains(node.val))
            return;

        visited.add(node.val);
        if (dist == k)
            res.addLast(node.val);
        DFS(parent.get(node.val), dist + 1, k);
        DFS(node.left, dist + 1, k);
        DFS(node.right, dist + 1, k);
    }
}
