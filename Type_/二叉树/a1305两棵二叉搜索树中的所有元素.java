package Type_.二叉树;

import Common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 1305. 两棵二叉搜索树中的所有元素
 * https://leetcode.cn/problems/all-elements-in-two-binary-search-trees/description/
 */
public class a1305两棵二叉搜索树中的所有元素 {
    class Solution {
        public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
            BSTIterator bstIterator1 = new BSTIterator(root1);
            BSTIterator bstIterator2 = new BSTIterator(root2);

            List<Integer> arr = new ArrayList<>();
            while (bstIterator1.hasNext() && bstIterator2.hasNext()) {
                if(bstIterator1.peek() > bstIterator2.peek())
                    arr.add(bstIterator2.next());
                else
                    arr.add(bstIterator1.next());
            }
            while (bstIterator1.hasNext())
                arr.add(bstIterator1.next());
            while (bstIterator2.hasNext())
                arr.add(bstIterator2.next());

            return arr;
        }


    }


    class BSTIterator {

        private final List<TreeNode> stack = new LinkedList();

        private void pushLeftBranch(TreeNode p) {
            while (p != null) {
                stack.addFirst(p);
                p = p.left;
            }
        }

        public BSTIterator(TreeNode root) {
            pushLeftBranch(root);
        }

        public int peek(){
            return stack.getFirst().val;
        }

        public int next() {
            TreeNode node = stack.removeFirst();
            pushLeftBranch(node.right);
            return node.val;
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }
    }

}
