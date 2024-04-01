package Type_.二叉树;

import Common.TreeNode;

import java.util.LinkedList;

/**
 * 536. 从字符串生成二叉树
 * <a href="https://leetcode.cn/problems/construct-binary-tree-from-string/"></a>
 */
public class a536从字符串生成二叉树 {

    //输入："4(2(3)(1))(6(5))"
    //输出：返回代表下列二叉树的根节点:
    //
    //       4
    //     /   \
    //    2     6
    //   / \   /
    //  3   1 5
    public TreeNode str2tree(String s) {
        if (s.isEmpty())
            return null;
        // 用栈模拟递归建树过程
        LinkedList<TreeNode> stack = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                continue;
            }
            if (s.charAt(i) == ')') {
                // 每次遇到有括号，都说明栈顶节点构建完成
                stack.removeFirst();
                continue;
            }
            int num = s.charAt(i) - '0';
            //新建节点
            TreeNode node = new TreeNode(num);
            if (!stack.isEmpty()) {
                TreeNode parent = stack.getFirst();
                if (parent.left == null)
                    parent.left = node;
                else
                    parent.right = node;
            }
            stack.addFirst(node);
        }
        return stack.getFirst();
    }

    public static void main(String[] args) {
        a536从字符串生成二叉树 test = new a536从字符串生成二叉树();

        TreeNode node = test.str2tree("4(2(3)(1))(6(5))");

    }
}
