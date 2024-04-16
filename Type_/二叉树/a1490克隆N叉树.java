package Type_.二叉树;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/clone-n-ary-tree/description/">克隆N叉树</a>
 */
public class a1490克隆N叉树 {
    class Node {
        public int val;
        public List<Node> children;

        public Node(int val, List<Node> childrenList) {
        }
    }

    class Solution {
        public Node cloneTree(Node root) {
            if (root == null)
                return null;
            List<Node> childrenList = new ArrayList<>(root.children.size());
            for (Node node : root.children) {
                childrenList.add(cloneTree(node));
            }
            return new Node(root.val, childrenList);
        }
    }
}
