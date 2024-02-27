package Type_.二叉树;


import Common.Node;
import Common.TreeNode;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * 116. 填充每个节点的下一个右侧节点指针
 * https://leetcode.cn/problems/populating-next-right-pointers-in-each-node/description/
 */
public class a116填充每个节点的下一个右侧节点指针 {

//    public Node connect(Node root) {
//        if (root == null)
//            return null;
//        LinkedList<Node> queue = new LinkedList<>();
//        queue.addLast(root);
//        traverse(queue);
//        return root;
//    }
//
//
//    void traverse(LinkedList<Node> queue) {
//        while (!queue.isEmpty()) {
//            int sz = queue.size();
//            for (int i = 0; i < sz; i++) {
//                Node node = queue.removeFirst();
//                if (i < sz - 1)
//                    node.next = queue.getFirst();
//                if (node.left != null)
//                    queue.addLast(node.left);
//                if (node.right != null)
//                    queue.addLast(node.right);
//            }
//        }
//    }

    public Node connect(Node root) {
        traverse(root);
        return root;
    }
    private void traverse(Node root){
        if (root == null)
            return;

        if (root.left != null) {
            root.left.next = root.right;
            if (root.right != null && root.next != null) {
                root.right.next = root.next.left;
            }
        }
        traverse(root.left);
        traverse(root.right);
    }
}
