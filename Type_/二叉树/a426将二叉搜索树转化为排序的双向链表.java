package Type_.二叉树;

/**
 * <a href="https://leetcode.cn/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/description/">将二叉搜索树转化为排序的双向链表</a>
 */
public class a426将二叉搜索树转化为排序的双向链表 {
    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    class Solution {
        Node pre = null, head = null;

        public Node treeToDoublyList(Node root) {
            if (root == null)
                return null;
            dfs(root);
            head.left = pre;
            pre.right = head;
            return head;
        }

        void dfs(Node root) {
            if (root == null)
                return;
            dfs(root.left);
            if (pre != null)
                pre.right = root;
            else
                head = root;
            root.left = pre;
            pre = root;
            dfs(root.right);
        }

    }
}
