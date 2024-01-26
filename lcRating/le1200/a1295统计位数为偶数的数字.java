package lcRating.le1200;

/**
 * 1295. 统计位数为偶数的数字
 * https://leetcode.cn/problems/find-numbers-with-even-number-of-digits/
 */
public class a1295统计位数为偶数的数字 {
    public int findNumbers(int[] nums) {
        int count = 0;
        for (int num : nums) {
            if ((getPNum(num) & 1) == 0)
                count++;
        }
        return count;
    }

    private int getPNum(int num) {
        return (int) Math.log10(num) + 1;
    }
}
