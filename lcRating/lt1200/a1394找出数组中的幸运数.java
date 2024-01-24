package lcRating.lt1200;

/**
 * 1394. 找出数组中的幸运数
 * https://leetcode.cn/problems/find-lucky-integer-in-an-array/
 */
public class a1394找出数组中的幸运数 {
    public int findLucky(int[] arr) {
        int[] map = new int[501];
        //计数
        for (int i = 0; i < arr.length; i++) {
            map[arr[i]]++;
        }
        //map[2] = 2,map[3] = 1,map[4] = 1
        for (int i = map.length - 1; i >= 1; i--) {
            if (map[i] == i)
                return i;
        }
        return -1;
    }
}
