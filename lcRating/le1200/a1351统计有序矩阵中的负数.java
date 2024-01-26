package lcRating.le1200;

/**
 * 1351. 统计有序矩阵中的负数
 * https://leetcode.cn/problems/count-negative-numbers-in-a-sorted-matrix/
 */
public class a1351统计有序矩阵中的负数 {
    int res = 0;

    public int countNegatives(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] visited = new int[m][n];
        dfs(grid, m - 1, n - 1, visited);
        return res;
    }

    public void dfs(int[][] grid, int i, int j, int[][] visited) {
        if (i < 0 || j < 0)
            return;
        if (visited[i][j] != 0)
            return;
        if (grid[i][j] >= 0)
            return;
        visited[i][j] = 1;
        res++;
        dfs(grid, i, j - 1, visited);
        dfs(grid, i - 1, j, visited);

    }


    public int countNegatives2(int[][] grid) {
        int ans = 0, m = grid.length, n = grid[0].length;
        int i = m - 1, j = 0;
        while (i >= 0 && j < n) {
            //如果当前的数小于0,则其右边的数必然小于0
            if (grid[i][j] < 0) {
                //加入这一行小于0的数
                ans += n - j;
                //这一行小于0的数找完了,往上一行走
                i--;
            } else
                //当前的数大于0,往右边走,找当前行小于0的第一个数
                j++;
        }
        return ans;
    }
}
