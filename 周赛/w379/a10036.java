package 周赛.w379;

/**
 * 10036. 捕获黑皇后需要的最少移动次数
 * https://leetcode.cn/problems/minimum-moves-to-capture-the-queen/description/
 */
public class a10036 {
    //分类讨论
    public int minMovesToCaptureTheQueen(int x1, int y1, int x2, int y2, int e1, int e2) {
        //仅需1次:
        //象跟皇后同一条直线且没有车在其中间挡路
        if (Math.abs(x2 - e1) == Math.abs(y2 - e2) && !isStuckCar(x1, y1, x2, y2, e1, e2))
            return 1;
        //车跟皇后在同一条线上且没有象在其该线中间挡路
        if ((x1 == e1 || y1 == e2) && !isStuckEle(x1, y1, x2, y2, e1, e2))
            return 1;
        //其他情况均至少需要两次
        return 2;
    }

    //x1,y1是车-直线移动 x2,y2是象-斜方向移动
    private boolean isStuckCar(int x1, int y1, int x2, int y2, int e1, int e2) {
        double k = 1.0 * (y2 - e2) / (x2 - e1);
        double q = e2 - k * e1;

        if (y1 == x1 * k + q && x1 > Math.min(x2, e1) && x1 < Math.max(x2, e1))
            return true;
        else
            return false;
    }
    //x1,y1是车-直线移动 x2,y2是象-斜方向移动
    private boolean isStuckEle(int x1, int y1, int x2, int y2, int e1, int e2) {
        if (x1 == e1 && x1 == x2 && y2 > Math.min(y1, e2) && y2 < Math.max(y1, e2)) {
            return true;
        }
        if (y1 == e2 && y1 == y2 && x2 > Math.min(x1, e1) && x2 < Math.max(x1, e1))
            return true;
        return false;
    }
}
