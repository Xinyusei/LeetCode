//package Type_.二叉树;
//
//import java.util.LinkedList;
//
///**
// * 117. 填充每个节点的下一个右侧节点指针 II
// * https://leetcode.cn/problems/populating-next-right-pointers-in-each-node-ii/description/
// */
//
//// Definition for a Node.
//class Node {
//    public int val;
//    public Node left;
//    public Node right;
//    public Node next;
//
//    public Node() {
//    }
//
//    public Node(int _val) {
//        val = _val;
//    }
//
//    public Node(int _val, Node _left, Node _right, Node _next) {
//        val = _val;
//        left = _left;
//        right = _right;
//        next = _next;
//    }
//}
//
//public class a117填充每个节点的下一个右侧节点指针II {
//
//    public Node connect(Node root) {
//        if (root == null)
//            return null;
//        traverse(root);
//        return root;
//    }
//
//    private void traverse(Node root) {
//        LinkedList<Node> queue = new LinkedList<Node>();
//        queue.addLast(root);
//        while (!queue.isEmpty()) {
//            int sz = queue.size();
//            Node pre = null;
//            for (int i = 0; i < sz; i++) {
//                Node first = queue.removeFirst();
//                if (pre != null)
//                    pre.next = first;
//                pre = first;
//                if (first.left != null)
//                    queue.addLast(first.left);
//                if (first.right != null)
//                    queue.addLast(first.right);
//            }
//        }
//    }
//}
//
//
//
