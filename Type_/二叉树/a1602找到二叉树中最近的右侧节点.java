package Type_.二叉树;

import Common.TreeNode;

import java.util.LinkedList;

public class a1602找到二叉树中最近的右侧节点 {
    private TreeNode u;
    private TreeNode res = null;

    public TreeNode findNearestRightNode(TreeNode root, TreeNode u) {
        this.u = u;
        traverse(root);
        return res;
    }

    public void traverse(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        while (!queue.isEmpty()) {
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                TreeNode node = queue.removeFirst();
                if (node.equals(u)) {
                    res = queue.getFirst();
                    return;
                }
                if (node.left != null)
                    queue.addLast(node.left);
                if (node.right != null)
                    queue.addLast(node.right);
            }
        }
    }

}
