package 代码随想录.回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author: ZJX
 * @Date: 2024/10/16
 * @Description:
 */
public class a51_N皇后 {
    class Solution {

        List<List<String>> res = new ArrayList<>();

        public List<List<String>> solveNQueens(int n) {
            char[][] q = new char[n][n];
            for (char[] c : q) {
                Arrays.fill(c, '.');
            }
            backtrack(q, 0);
            return res;
        }

        private void backtrack(char[][] q, int x) {
            if (x == q.length) {
                // 当到达最后一行时，说明找到了一个解，将当前棋盘状态添加到结果列表中
                res.add(construct(q));
                return;
            }

            for (int i = 0; i < q.length; i++) {
                if (isValid(q, x, i)) {
                    q[x][i] = 'Q';
                    backtrack(q, x + 1);
                    q[x][i] = '.';
                }
            }
        }

        private List<String> construct(char[][] q) {
            int n = q.length;
            ArrayList<String> s = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    sb.append(q[i][j]);
                }
                s.add(sb.toString());
            }
            return s;
        }

        //该方法检查是否是合法的象棋摆放情况
        private boolean isValid(char[][] q, int x, int y) {
            int n = q.length;
            //同一行
            for (int i = 0; i < n; i++) {
                if (q[x][i] == 'Q')
                    return false;
            }
            //同一列
            for (int i = 0; i < n; i++) {
                if (q[i][y] == 'Q')
                    return false;
            }
            //
            for (int i = x, j = y; i >= 0 && j < n; i--, j++) {
                if (q[i][j] == 'Q')
                    return false;
            }
            for (int i = x, j = y; i < n && j >= 0; i++, j--) {
                if (q[i][j] == 'Q')
                    return false;
            }
            for (int i = x, j = y; i >= 0 && j >= 0; i--, j--) {
                if (q[i][j] == 'Q')
                    return false;
            }
            for (int i = x, j = y; i < n && j < n; i++, j++) {
                if (q[i][j] == 'Q')
                    return false;
            }
            return true;
        }
    }
}
