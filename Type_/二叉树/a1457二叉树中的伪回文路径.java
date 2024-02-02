package Type_.二叉树;


import Common.TreeNode;

import java.util.ArrayList;

public class a1457二叉树中的伪回文路径 {
    private ArrayList<Integer> path = new ArrayList<>();
    private int res = 0;
    private int[] map = new int[10];

    public int pseudoPalindromicPaths(TreeNode root) {
        traverse(root);
        return res;
    }

    private void traverse(TreeNode node) {
        if (node == null)
            return;
        map[node.val]++;
        if (node.left == node.right) {
            boolean valid = isValid(map);
            if (valid)
                res++;
        }
        traverse(node.left);
        traverse(node.right);
        map[node.val]--;
    }

    private boolean isValid(int[] map) {
        int cnt = 0;
        for (int i : map) {
            if ((i & 1) != 0)
                cnt++;
            if (cnt > 1)
                return false;
        }
        return true;
    }
}
