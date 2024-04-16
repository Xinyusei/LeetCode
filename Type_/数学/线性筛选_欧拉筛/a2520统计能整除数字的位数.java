package Type_.数学.线性筛选_欧拉筛;

/**
 * 2520. 统计能整除数字的位数
 * <a href="https://leetcode.cn/problems/count-the-digits-that-divide-a-number/description/">...</a>
 */
public class a2520统计能整除数字的位数 {
    class Solution1 {
        /**
         * 取模计算每位
         * @param num
         * @return
         */
        public int countDigits(int num) {
            int ans = 0, temp = num;
            while (temp > 0) {
                if (num % (temp % 10) == 0)
                    ans++;
                temp /= 10;
            }
            return ans;
        }
    }

    class Solution2 {
        /**
         * 数串互转
         * @param num
         * @return
         */
        public int countDigits(int num) {
            String numStr = Integer.toString(num);

            int count = 0;
            for (int i = 0; i < numStr.length(); i++) {
                int n = Character.getNumericValue(numStr.charAt(i));
                if(num % n == 0)
                    count++;
            }
            return count;
        }
    }
}
