package lcRating.gt1600le1800;

/**
 * <a href="https://leetcode.cn/problems/check-if-move-is-legal/description/?envType=daily-question&envId=2024-07-09">检查操作是否合法</a>
 */
public class a1958检查操作是否合法 {
    class Solution {
        public boolean checkMove(char[][] board, int rMove, int cMove, char color) {
            //检查八个方向
            int[][] dir = {{0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}};

            for (int t = 0; t < 8; t++) {
                int dx = dir[t][0], dy = dir[t][1];
                if (check(board, rMove, cMove, color, dx, dy)) {
                    return true;
                }
            }
            return false;
        }

        public boolean check(char[][] board, int rMove, int cMove, char color, int dx, int dy) {
            int x = rMove + dx;
            int y = cMove + dy;
            int step = 1;
            while (x >= 0 && x < 8 && y >= 0 && y < 8) {
                if (step == 1) {
                    if (board[x][y] == '.' || board[x][y] == color) {
                        return false;
                    }
                } else {
                    if (board[x][y] == '.') {
                        return false;
                    }
                    if (board[x][y] == color)
                        return true;
                }
                step++;
                x += dx;
                y += dy;
            }
            return false;
        }
    }
}
