package Hot100;

/**
 * @Author: ZJX
 * @Date: 2024/09/24
 * @Description:
 */
public class a42接雨水 {
    class Solution1 {
        //预处理
        public int trap(int[] height) {
            //索引为i位置能接住的水的值为
            //min(
            // max(height[0~i]),
            // max(height[i+1,height.length-1]))
            // - height[i];
            int n = height.length;
            int[] l = new int[n];
            int lm = 0;
            for (int i = 0; i < n; i++) {
                int lv = height[i];
                if (lv > lm)
                    lm = lv;
                l[i] = lm;
            }
            int[] r = new int[n];
            int rm = height[n - 1];
            for (int i = n - 1; i > 0; i--) {
                int rv = height[i];
                if (rv > rm)
                    rm = rv;
                r[i] = rm;
            }
            int ans = 0;
            for (int i = 0; i < n; i++) {
                ans += Math.min(l[i], r[i]) - height[i];
            }
            return ans;
        }
    }

    class Solution2 {

        /**
         * DP解法
         *
         * @param height
         * @return
         * @author ZJX
         * @date 2024/09/24
         */
        public int trap(int[] height) {
            //索引为i位置能接住的水的值为
            //min(
            // max(height[0~i]),
            // max(height[i+1,height.length-1]))
            // - height[i];
            int n = height.length;
            int[] l = new int[n];
            l[0] = height[0];
            for (int i = 1; i < n; i++)
                l[i] = Math.max(height[i], l[i - 1]);
            int[] r = new int[n];
            r[n - 1] = height[n - 1];
            for (int i = n - 2; i >= 0; i--)
                r[i] = Math.max(r[i + 1], height[i]);
            int ans = 0;
            for (int i = 0; i < n; i++) {
                ans += Math.min(l[i], r[i]) - height[i];
            }
            return ans;
        }
    }

    /**
     *
     */
    class Solution3 {
        //预处理
        public int trap(int[] height) {
            //索引为i位置能接住的水的值为
            //min(
            // max(height[0~i]),
            // max(height[i+1,height.length-1]))
            // - height[i];
            int n = height.length;
            int lm = 0, rm = 0;
            int ans = 0;
            for (int i = 0, j = n - 1; i < j; ) {
                lm = Math.max(lm, height[i]);
                rm = Math.max(rm, height[i]);
                if (height[i] < height[j]) {
                    ans += lm - height[i];
                    ++i;
                } else {
                    ans += rm - height[j];
                    --j;
                }
            }
            return ans;
        }
    }

    class Solution4 {

        /**
         * 单调栈解法
         *
         * @param height
         * @return
         * @author ZJX
         * @date 2024/09/24
         */
        public int trap(int[] height) {
            //索引为i位置能接住的水的值为
            //min(
            // max(height[0~i]),
            // max(height[i+1,height.length-1]))
            // - height[i];
            int n = height.length;
            int[] l = new int[n];
            l[0] = height[0];
            for (int i = 1; i < n; i++)
                l[i] = Math.max(height[i], l[i - 1]);
            int[] r = new int[n];
            r[n - 1] = height[n - 1];
            for (int i = n - 2; i >= 0; i--)
                r[i] = Math.max(r[i + 1], height[i]);
            int ans = 0;
            for (int i = 0; i < n; i++) {
                ans += Math.min(l[i], r[i]) - height[i];
            }
            return ans;
        }
    }
}
