package Type_.二叉树;


import java.util.LinkedList;

class Node {
    int val;
    Node left;
    Node right;
    Node parent;

    public Node(int val, Node left, Node right, Node parent) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.parent = parent;
    }

    public Node() {

    }
}

public class a1650二叉树的最近公共祖先III {

    Node lowestCommonAncestor(Node a, Node b) {
        Node p = a, q = b;
        if (p == q)
            return p;
        int sizeP = 0, sizeQ = 0;
        while (p != null) {
            p = p.parent;
            sizeP++;
        }
        while (q != null) {
            q = q.parent;
            sizeQ++;
        }
        int diff = Math.abs(sizeP - sizeQ);
        p = a;
        q = b;
        while (diff-- > 0) {
            if (sizeP > sizeQ)
                p = p.parent;
            else
                q = q.parent;
        }
        while (p != q) {
            p = p.parent;
            q = q.parent;
        }
        return p;
    }
}
