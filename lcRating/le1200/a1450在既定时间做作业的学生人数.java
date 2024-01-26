package lcRating.le1200;

/**
 * 1450. 在既定时间做作业的学生人数
 * https://leetcode.cn/problems/number-of-students-doing-homework-at-a-given-time/
 */
public class a1450在既定时间做作业的学生人数 {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int n = startTime.length, res = 0;
        for (int i = 0; i < n; i++) {
            if (queryTime >= startTime[i] && queryTime <= endTime[i])
                res++;
        }
        return res;
    }
}
