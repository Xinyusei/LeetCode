package Type_.图;

/**
 * 130. 被围绕的区域
 * <a href="https://leetcode.cn/problems/surrounded-regions/description/">...</a>
 */
public class a130被围绕的区域 {
    private class Solution1 {
        int row, col;
        int[][] dir;

        public void solve(char[][] board) {
            this.row = board.length;
            this.col = board[0].length;
            this.dir = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    //找到与边界直接或者间接相连接的'O' 将其标记为'T' - 表明其不是被'X'包围的。
                    if ((i == 0 || j == 0 || i == row - 1 || j == col - 1) && board[i][j] == 'O')
                        dfs(board, i, j);
                }
            }

            //如果为'X' 无需处理
            //如果为'T' 则是直接标记过的不被'X'包围的,将其还原为'0'
            //如果为'0' 则是未被标记的,说明确实是被'X'包围的'0',将其改为'X'
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (board[i][j] == 'T')
                        board[i][j] = 'O';
                    else if (board[i][j] == 'O')
                        board[i][j] = 'X';
                }
            }

        }
        //找到与边界直接或者间接相连接的'O' 将其标记为'T'
        public void dfs(char[][] board, int x, int y) {
            if (x < 0 || x >= row || y < 0 || y >= col || board[x][y] != 'O')
                return;

            board[x][y] = 'T';
            for (int[] d : dir) {
                dfs(board, x + d[0], y + d[1]);
            }
        }

    }
}
