package Type_.动态规划;

import javax.lang.model.type.ArrayType;
import java.util.Arrays;
import java.util.Comparator;

public class a354俄罗斯套娃信封问题 {

    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0])
                    return o2[1] - o1[1];
                return o1[0] - o2[0];

            }
        });
        //System.out.println(Arrays.deepToString(envelopes));
        //先将信封按照宽度排序
        int n = envelopes.length;
        //dp[i]表示以envelopes[i]结尾的最多套娃信封个数
        int[] dp = new int[n];
        //base case
        Arrays.fill(dp, 1);

        for (int i = 0; i < n; i++) {
            //判断envelops[i]能否装下前面的信封
            for (int j = 0; j < i; j++) {
                //如果高度更高,说明可以装入
                if (envelopes[i][0] != envelopes[j][0] && envelopes[i][1] > envelopes[j][1])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
        int res = 1;
        for (int j : dp) {
            res = Math.max(res, j);
        }
        return res;
    }
}
