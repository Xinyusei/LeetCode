package Type_.二叉树;

/**
 * 96. 不同的二叉搜索树
 * https://leetcode.cn/problems/unique-binary-search-trees/description/
 */
public class a96不同的二叉搜索树 {
    /**
     * 自顶向下解法 - 递归
     */
    int[][] memo;
    public int numTrees(int n) {
        if (n == 1 || n == 2) return n;
        memo = new int[n + 1][n + 1];
        return count(1, n);
    }

    int count(int lo, int hi) {
        if (lo >= hi)
            return 1;
        if (memo[lo][hi] != 0)
            return memo[lo][hi];
        int res = 0;
        for (int mid = lo; mid <= hi; mid++) {
            int left = count(lo, mid - 1);
            int right = count(mid + 1, hi);
            res += left * right;
        }
        memo[lo][hi] = res;

        return res;
    }

    /**
     * 动态规划
     * @param n
     * @return
     */
    public int numTrees2(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}
