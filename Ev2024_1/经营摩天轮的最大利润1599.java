package Ev2024_1;

public class 经营摩天轮的最大利润1599 {
    /**
     * https://leetcode.cn/problems/maximum-profit-of-operating-a-centennial-wheel/description/?envType=daily-question&envId=2024-01-01
     * @param customers
     * @param boardingCost
     * @param runningCost
     * @return
     */
    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        int n = customers.length, turn = 0, bal = 0, Maxbal = 0, Minturn = -1;
        for (int i = 0; i < n - 1; i++) {
            int up = Math.min(customers[i], 4);
            bal += up * boardingCost - runningCost;
            turn++;
            if (bal > Maxbal) {
                Maxbal = bal;
                Minturn = turn;
            }
            customers[i + 1] += customers[i] - up;
        }
        //最后一批客人到达,此时需要查看前面还有多少人排队
        int wait = customers[n - 1];
        while (wait > 0) {
            int up = Math.min(wait, 4);
            bal += up * boardingCost - runningCost;
            turn++;
            if (bal > Maxbal) {
                Maxbal = bal;
                Minturn = turn;
            }
            wait -= up;
        }
        return Maxbal < 0 ? -1 : Minturn;
    }
}

