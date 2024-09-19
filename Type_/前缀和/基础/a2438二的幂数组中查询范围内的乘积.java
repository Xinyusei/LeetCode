package Type_.前缀和.基础;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: ZJX
 * @Date: 2024/09/19
 * @Description:
 */
public class a2438二的幂数组中查询范围内的乘积 {

    class Solution2 {
        private static final int MX = (int) 1e9 + 7;

        public int[] productQueries(int n, int[][] queries) {
            //1,2,4,8
            List<Long> powers = new ArrayList<>();
            while (n != 0) {
                long i = tableSizeFor(n);
                powers.addFirst(i);
                n -= (int) i;
            }
            //System.out.println(powers);
            //1,1,2,8,64
            int m = queries.length;
            int[] res = new int[m];
            for (int i = 0; i < queries.length; i++) {
                int lo = queries[i][0], hi = queries[i][1];
                long pro = 1;
                while (lo <= hi) {
                    pro *= (powers.get(lo++) % MX);
                    pro %= MX;
                }
                res[i] = (int) pro;
            }
            return res;
        }

        private int tableSizeFor(int num) {
            int index = 0;
            while (num >= (1 << index)) {
                index++;
            }
            return 1 << (index - 1);
        }
    }

    class Solution {
        private static final int MX = (int) 1e9 + 7;
        public int[] productQueries(int n, int[][] queries) {
            //1,2,4,8
            ArrayList<BigInteger> powers = new ArrayList<>();
            while (n != 0) {
                long i = tableSizeFor(n);
                powers.addFirst(BigInteger.valueOf(i));
                n -= (int) i;
            }
            for (int i = 1; i < powers.size(); i++) {
                powers.set(i, powers.get(i).multiply(powers.get(i - 1)));
            }
            powers.addFirst(BigInteger.ONE);
            //System.out.println(powers);
            //1,1,2,8,64
            int m = queries.length;
            int[] res = new int[m];
            for (int i = 0; i < queries.length; i++) {
                int lo = queries[i][0], hi = queries[i][1] + 1;
                res[i] = powers.get(hi).divide(powers.get(lo)).mod(BigInteger.valueOf(MX)).intValue();
            }
            return res;
        }
        private int tableSizeFor(int num) {
            int index = 0;
            while (num >= (1 << index)) {
                index++;
            }
            return 1 << (index - 1);
        }
    }
}
