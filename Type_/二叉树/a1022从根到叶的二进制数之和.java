package Type_.二叉树;

import Common.TreeNode;

/**
 * 1022. 从根到叶的二进制数之和
 * https://leetcode.cn/problems/sum-of-root-to-leaf-binary-numbers/description/
 */
public class a1022从根到叶的二进制数之和 {
    private int pathSum = 0;

    private int sum = 0;

    /**
     * 位运算
     * @param root
     * @return
     */
    public int sumRootToLeaf2(TreeNode root) {
        traverse2(root);
        return sum;
    }

    public void traverse2(TreeNode node) {
        if (node == null)
            return;

        pathSum = pathSum << 1 | node.val;
        if (node.left == node.right)
            sum += pathSum;
        traverse2(node.left);
        traverse2(node.right);
        pathSum = (pathSum - node.val) >> 1;
    }


    //方法1 - 用字符串记录路径 在叶子结点计算对应的值
    StringBuilder path = new StringBuilder();
    int res = 0;

    public int sumRootToLeaf1(TreeNode root) {
        traverse(root);
        return res;
    }

    public void traverse(TreeNode root) {
        if (root == null)
            return;
        path.append(root.val);
        if (root.left == root.right) {
            res += str2int(path.toString());
        }
        traverse(root.left);
        traverse(root.right);
        path.deleteCharAt(path.length() - 1);
    }

    public int str2int(String s) {
        int num = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '1')
                num += (int) Math.pow(2, s.length() - 1 - i);
        }
        return num;
    }
}
