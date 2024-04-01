package Type_.二叉树;

import Common.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * 582. 杀掉进程
 * <a href="https://leetcode.cn/problems/kill-process/description/">...</a>
 */
public class a582杀掉进程 {
    /**
     * 并查集 、 图论
     *
     * @param pid  第i个进程id
     * @param ppid 第i个进程的父进程id
     * @param kill 需要杀死的进程id
     * @return 杀掉该进程后的所有进程 ID 的列表
     */
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        HashMap<Integer, List<Integer>> tree = new HashMap<>();
        //建立多叉树
        for (int i = 0; i < pid.size(); i++) {
            int child = pid.get(i);
            int parent = ppid.get(i);
            tree.putIfAbsent(parent, new ArrayList<>());
            tree.get(parent).add(child);
        }
        List<Integer> res = new LinkedList<>();
        // 我这里用 BFS 算法遍历子树，删除以 kill 为根的所有子节点
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(kill);
        while (!queue.isEmpty()) {
            int cur = queue.removeFirst();
            res.add(cur);
            if (tree.containsKey(cur)) {
                queue.addAll(tree.get(cur));
            }
        }

        return res;
    }
}
