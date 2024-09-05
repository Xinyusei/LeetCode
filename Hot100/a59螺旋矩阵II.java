package Hot100;

import Common.ListNode;

import java.util.Arrays;

/**
 * @Author: ZJX
 * @Date: 2024/09/05
 * @Description: 螺旋矩阵  同类型的还有 <a href="https://leetcode.cn/problems/spiral-matrix-iv/">2326. 螺旋矩阵 IV</a>
 */
public class a59螺旋矩阵II {
    //
    class Solution1 {
        public int[][] generateMatrix(int n) {
            int top = 0, bottom = n - 1, left = 0, right = n - 1;
            int num = 1;
            int[][] res = new int[n][n];

            while (num < n * n) {
                for (int column = left; column <= right; column++, num++) {
                    res[top][column] = num;
                }
                top++;
                for (int row = top; row <= bottom; row++, num++) {
                    res[row][right] = num;
                }
                right--;
                for (int column = right; column >= left; column--, num++) {
                    res[bottom][column] = num;
                }
                bottom--;
                for (int row = bottom; row >= top; row--, num++) {
                    res[row][left] = num;
                }
                left++;
            }
            return res;
        }
    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution2 {
        public int[][] spiralMatrix(int m, int n, ListNode head) {
            int top = 0, bottom = m - 1, left = 0, right = n - 1;
            int[][] res = new int[m][n];
            for (int[] e : res) {
                Arrays.fill(e, -1);
            }
            while (head != null) {
                for (int column = left; column <= right && head != null; column++, head = head.next) {
                    res[top][column] = head.val;
                }
                top++;
                for (int row = top; row <= bottom && head != null; row++, head = head.next) {
                    res[row][right] = head.val;
                }
                right--;
                for (int column = right; column >= left && head != null; column--, head = head.next) {
                    res[bottom][column] = head.val;
                }
                bottom--;
                for (int row = bottom; row >= top && head != null; row--, head = head.next) {
                    res[row][left] = head.val;
                }
                left++;
            }
            return res;
        }
    }
}

