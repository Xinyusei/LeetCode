package Type_.二叉树;

import Common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 257. 二叉树的所有路径
 * https://leetcode.cn/problems/binary-tree-paths/description/
 */
public class a257二叉树的所有路径 {
    // 记录 backtrack 函数递归时的路径
    private final List<String> allPath = new ArrayList<>();
    // 记录从根节点到所有叶子节点的路径
    private final List<String> path = new LinkedList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        backtrack(root);
        return allPath;
    }

    public void backtrack(TreeNode node) {
        if (node == null)
            return;
        //到达叶子节点
        path.addLast(Integer.toString(node.val));
        if (node.left ==  node.right) {
            //将当前路径加入到allPath
            allPath.addLast(String.join("->", path));
        }
        backtrack(node.left);
        backtrack(node.right);
        path.removeLast();
    }
}
