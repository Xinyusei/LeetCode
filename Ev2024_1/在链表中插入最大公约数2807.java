package Ev2024_1;

import Common.ListNode;

/**
 * 2807. 在链表中插入最大公约数
 * https://leetcode.cn/problems/insert-greatest-common-divisors-in-linked-list/description/?envType=daily-question&envId=2024-01-06
 */
public class 在链表中插入最大公约数2807 {
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode p = head;
        while (p != null && p.next != null) {
            ListNode node = new ListNode(gcd(p.val, p.next.val));
            node.next = p.next;
            p.next = node;
            p = node.next;
        }
        return head;
    }

    /*
    public int getMaxNum(int num1, int num2) {
        int minNum = Math.min(num1, num2);
        int res = minNum;
        for (; res >= 1; res--) {
            if (num1 % res == 0 && num2 % res == 0) {
                return res;
            }
        }
        return 1;
    }
    */

    /**
     * 辗转相除法/欧几里得算法
     *
     * @param a
     * @param b
     * @return
     */
    public int gcd(int a, int b) {
        while (b != 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
            System.out.println("tmp: " + tmp + " a: " + a + " b: " + b);
        }
        return a;
    }

    /**
     * 辗转相减法
     * @param a
     * @param b
     * @return
     */
    public int gcd2(int a, int b) {
        while (a != b) {
            if (a > b)
                a -= b;
            else
                b -= a;
            System.out.println(" a: " + a + " b: " + b);

        }
        return a;
    }

    public static void main(String[] args) {
        在链表中插入最大公约数2807 a = new 在链表中插入最大公约数2807();
        int res = a.gcd2(75, 20);
        System.out.println("最大公约数为:" + res);
    }
}
