package Type_.二分算法.二分答案_求最大;

/**
 * 275. H 指数 II
 * https://leetcode.cn/problems/h-index-ii/description/
 */
public class a275H指数II {
    class Solution {
        public int hIndex(int[] citations) {
            int lo = 0, hi = citations.length;
            while (lo < hi) {
                int mid = (hi - lo) / 2 + lo;
                int citationVal = citations[mid];
                if (citationVal >= citations.length - mid)
                    hi = mid;
                else
                    lo = mid + 1;
            }
            return citations.length - lo;
        }
    }

    class Solution2 {
        public int hIndex(int[] citations) {
            int n = citations.length;
            int lo = 0, hi = n;
            while (lo < hi) {
                int mid = ((hi - lo) >> 1) + lo;
                //citations[mid]代表当前文章的引用指数
                if (citations[mid] >= n - mid) {
                    hi = mid;
                } else
                    lo = mid + 1;
            }
            return n - hi;
        }
    }
}
