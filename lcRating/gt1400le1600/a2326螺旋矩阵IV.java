package lcRating.gt1400le1600;

import Common.ListNode;

import java.util.Arrays;

/**
 * @Author: ZJX
 * @Date: 2024/09/05
 * @Description:
 */
public class a2326螺旋矩阵IV {
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
    class Solution {
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
