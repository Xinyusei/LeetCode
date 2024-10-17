package 代码随想录.回溯;

/**
 * @Author: ZJX
 * @Date: 2024/10/17
 * @Description:
 */
public class a37解数独 {
    class Solution {
        public void solveSudoku(char[][] board) {
            backtrack(board);
        }

        //因为解数独找到一个符合的条件（就在树的叶子节点上）立刻就返回，相当于找从根节点到叶子节点一条唯一路径，所以需要使用bool返回值。
        private boolean backtrack(char[][] board) {
            //一个for循环遍历棋盘的行，一个for循环遍历棋盘的列，一行一列确定下来之后，递归遍历这个位置放9个数字的可能性！
            for (int i = 0; i < 9; i++) { //遍历行
                for (int j = 0; j < 9; j++) {  //遍历列
                    if (board[i][j] != '.')
                        continue;
                    for (char k = '1'; k <= '9'; k++) { //[i,j] 这个位置 可以放数，尝试放'1' - '9'
                        if (isValid(board, k, i, j)) { //判断这个位置是否允许放k
                            board[i][j] = k; //放k
                            if (backtrack(board)) //继续递归，如果找到一组解，则返回
                                return true;
                            board[i][j] = '.'; //撤销
                        }
                    }
                    return false; //[i,j] 这个位置 '1' - '9' 都没有返回true，说明这个位置找不到解，返回false
                }
            }
            return true;
        }


        //x:[0,1,2],[3,4,5],[6,7,8]
        //y:[0,1,2],[3,4,5],[6,7,8]
        private boolean isValid(char[][] board, char v, int x, int y) {
            int xA = x / 3, yA = y / 3;

            //2,2
            //同一行：
            for (int j = 0; j < 9; j++) {
                if (board[x][j] == v)
                    return false;
            }
            //同一列
            for (int i = 0; i < 9; i++) {
                if (board[i][y] == v)
                    return false;
            }
            //3 * 3 网格内
            for (int i = xA * 3; i < xA * 3 + 3; i++) {
                for (int j = yA * 3; j < yA * 3 + 3; j++) {
                    if (board[i][j] == v)
                        return false;
                }
            }
            return true;
        }
    }
}

