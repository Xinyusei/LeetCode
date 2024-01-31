package lcRating.gt1200le1400;

/**
 * 1491. 去掉最低工资和最高工资后的工资平均值
 * https://leetcode.cn/problems/average-salary-excluding-the-minimum-and-maximum-salary/description/
 */
public class a1491去掉最低工资和最高工资后的工资平均值 {
    public double average(int[] salary) {
        int minSalary = salary[0], maxSalary = minSalary, sum = 0;
        for (int s : salary) {
            if (s < minSalary)
                minSalary = s;
            else if (s > maxSalary)
                maxSalary = s;
            sum += s;
        }
        return (double) (sum - minSalary - maxSalary) / (salary.length - 2);
    }

}
