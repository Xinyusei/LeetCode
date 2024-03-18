package Type_.二叉树;

import java.util.HashMap;

/**
 * 666. 路径总和 IVopen in new window
 * https://leetcode.cn/problems/path-sum-iv
 */
public class a666路径总和 {
    // code -> value，节点编码到节点值的映射
    HashMap<Integer, Integer> tree = new HashMap<>();
    private int sum = 0;

    public int pathSum(int[] nums) {
        for (int code : nums) {
            int value = code % 10;
            code /= 10;
            // 记录节点编码到值的映射
            //11 ->3 21->5 22->1
            tree.put(code, value);
        }
        // 输入已经排序，第一个就是根节点
        int rootCode = nums[0] / 10;
        traverse(rootCode, 0);
        return sum;

    }

    // 二叉树遍历函数，顺便记录遍历过得路径之和
    void traverse(int code, int path) {
        if (!tree.containsKey(code)) {
            return;
        }
        // 当前遍历到的节点值
        int value = tree.get(code);
        int[] pos = decode(code);
        // 当前遍历到的节点深度和 id
        int depth = pos[0], id = pos[1];
        //左右子节点的编码
        int leftCode = encode(depth + 1, id * 2 - 1);
        int rightCode = encode(depth + 1, id * 2);
        //到达叶子节点
        if(!tree.containsKey(leftCode) && !tree.containsKey(rightCode)){
            sum += path + value;
            return;
        }
        traverse(leftCode,path + value);
        traverse(rightCode,path + value);

    }

    private int encode(int depth, int id) {
        return id + depth * 10;
    }


    int[] decode(int code) {
        //21 即 第2层 第1个节点,返回{2,1}
        return new int[]{code / 10, code % 10};
    }
}


