package lcRating.gt1200le1400;

/**
 * https://leetcode.cn/problems/find-the-town-judge/
 * 997. 找到小镇的法官
 */
public class a997找到小镇的法官 {
    public int findJudge(int n, int[][] trust) {
        int[][] graph = new int[n + 1][n + 1];
        for (int i = 0; i < trust.length; i++) {
            int p1 = trust[i][0], p2 = trust[i][1];
            graph[p1][p2] = 1;
        }
        int[][] find = new int[n + 1][2];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (graph[i][j] == 1)
                    find[i][0]++;
                if (graph[j][i] == 1)
                    find[i][1]++;
            }
        }
        //找到出度为0,入度为n - 1的人
        for (int i = 1; i <= n; i++) {
            if (find[i][0] == 0 && find[i][1] == n - 1)
                return i;
        }
        return -1;
    }

    /**
     * 优化-直接使用两个数组保存入度出度即可,无需建图
     *
     * @param n
     * @param trust
     * @return
     */
    public int findJudge2(int n, int[][] trust) {
        int[] inDegree = new int[n + 1];
        int[] outDegree = new int[n + 1];
        for (int i = 0; i < trust.length; i++) {
            int p1 = trust[i][0], p2 = trust[i][1];
            outDegree[p1]++;
            inDegree[p2]++;
        }
        //找到出度为0,入度为n - 1的人
        for (int i = 1; i <= n; i++) {
            if (outDegree[i] == 0 && inDegree[i] == n - 1)
                return i;
        }
        return -1;
    }
}
