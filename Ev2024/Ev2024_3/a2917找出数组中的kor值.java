package Ev2024.Ev2024_3;

/**
 * 2917. 找出数组中的 K-or 值
 * https://leetcode.cn/problems/find-the-k-or-of-an-array/description/?envType=daily-question&envId=2024-03-06
 */
public class a2917找出数组中的kor值 {
    public int findKOr(int[] nums, int k) {
        int ans = 0;
        for (int i = 0; i < 31; i++) {
            int cnt = 0;
            for (int num : nums) {
                if ((num >> i & 1) == 1) cnt++;
            }
            if (cnt >= k)
                ans += i << 2;
        }
        return ans;
    }
}
