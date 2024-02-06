# 每日

## 1.8 MID-思维

```java
package Ev2024.Ev2024_1;

import java.util.*;

/**
 * mid-01-08
 * https://leetcode.cn/problems/number-of-boomerangs/description/?envType=daily-question&envId=2024-01-08
 * 翻译-每次从points数组中选一个点,从剩下的点中计算每个点到该点的距离,将其按照 距离：个数 存储在map中。
 * 每遍历完一个点,计算还有多少个点到其的距离相等。从中选出两个点
 */
public class 回旋镖的数量447 {
    public int numberOfBoomerangs(int[][] points) {
        //在循环外面new更快
        HashMap<Double, Integer> map = new HashMap<>();
        int ans = 0;
        for (int[] curP : points) {
            //每遍历一个点都需要更新
            map.clear();
            for (int[] otherP : points) {
                //计算其他点到当前点的距离
                Double dis = getDis(curP, otherP);
                int val;
                if (map.containsKey(dis))
                    val = map.get(dis) + 1;
                else
                    val = 1;
                map.put(dis, val);
            }
            for (Integer value : map.values()) {
                if (value >= 2) {
                    //注意这里需求顺序，故不需要/2
                    ans += value * (value - 1);
                }
            }
        }
        return ans;
    }

    //这里没有开平方,小技巧
    private double getDis(int[] point1, int[] point2) {
        return (point1[0] - point2[0]) * (point1[0] - point2[0]) + (point1[1] - point2[1]) * (point1[1] - point2[1]);
    }
}
```



## 1.10 easy-模拟/括号匹配/栈

```java
package Ev2024.Ev2024_1;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

/**
 * https://leetcode.cn/problems/minimum-string-length-after-removing-substrings/description/?envType=daily-question&envId=2024-01-10
 * 2696. 删除子串后的字符串最小长度
 */
public class 删除子串后的字符串最小长度1_10 {
    public static void main(String[] args) {
        String s = "ABFCACDB";
        System.out.println(s.replace("AF", ""));
    }

    /**
     * 直接模拟删除AB、CD
     *
     * @param s
     * @return
     */
    public int minLength(String s) {
        String sub1 = "AB", sub2 = "CD";
        if (s.contains(sub1) || s.contains(sub2)) {
            s = s.replace(sub1, "");
            s = s.replace(sub2, "");
            System.out.println(s);
        }
        return s.length();
    }


    /**
     * 不去模拟删除，而是借助括号匹配的思路
     *
     * @param s
     * @return
     */
    public int minLength2(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        HashMap<Character, Character> map = new HashMap<>();
        map.put('B', 'A');
        map.put('D', 'C');
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            stack.add(c);
            int n = stack.size();
            if ((c == 'D' || c == 'B') && n >= 2 && stack.get(n - 2) == map.get(c)) {
                stack.remove(n - 1);
                stack.remove(n - 2);
            }
        }
        return stack.size();

    }

    /**
     * https://leetcode.cn/problems/valid-parentheses/
     * 20. 有效的括号
     *
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty() || stack.pop() != map.get(c))
                    return false;
            }
        }
        if (!stack.isEmpty())
            return false;
        return true;
    }

    public boolean isValid2(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else if (stack.isEmpty() || stack.peek() != c)
                return false;
            else
                stack.pop();
        }
        if (!stack.isEmpty())
            return false;
        return true;
    }

}

```

## 1.15 MID-链表、思维、双指针

```
package Ev2024.Ev2024_1;

import Common.ListNode;
import com.sun.source.tree.LiteralTree;

/**
 * 82. 删除排序链表中的重复元素 II
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-list-ii/description/?envType=daily-question&envId=2024-01-15
 */
public class a82删除排序链表中的重复元素 {
    /**
     * 保证没有重复元素
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode slow = dummy, fast = head;
        while (fast != null) {
            if (fast.next != null && fast.next.val == fast.val) {
                //发现重复节点,跳过重复节点
                while (fast.next != null && fast.next.val == fast.val)
                    fast = fast.next;
                fast = fast.next;

                //此时还不能让slow直接接fast,因为还没有判断此时fast后面的元素是否还是重复元素
                //1-1-1-2-2这里仅仅跳过1,到达第一个2,还不能接
                if (fast == null)
                    slow.next = fast;
            } else {
                //当前节点不是重复节点
                slow.next = fast;
                slow = slow.next;
                fast = fast.next;
            }
        }
        return dummy.next;
    }

    /**
     * 给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。
     * 仅仅保留一个重复元素
     *
     * @param head
     * @return
     */

    /**
     * 原地前后双指针
     * @param head
     * @return
     */
    public ListNode deleteDuplicates2(ListNode head) {
        ListNode p = head, q = head;
        while (q != null) {
            while (q.val != p.val) {
                p.next = q;
                p = p.next;
            }
            q = q.next;
        }
        p.next = null;
        return head;
    }

    /**
     * 再开一个链表来链接原来的节点
     * @param head
     * @return
     */
    public ListNode deleteDuplicates3(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy, q = head;
        while (q != null) {
            //当前元素是重复元素
            if (q.next != null && q.next.val == q.val) {
                while (q.next != null && q.next.val == q.val)
                    q = q.next;
                p.next = q;
            } else {
                p.next = q;
                p = p.next;
                q = q.next;
            }
        }
        return dummy.next;
    }
}
```

## 1.25 easy-位运算

```java
package Ev2024.Ev2024_1;

import java.util.List;

/**
 * 2859. 计算 K 置位下标对应元素的和
 * https://leetcode.cn/problems/sum-of-values-at-indices-with-k-set-bits/?envType=daily-question&envId=2024-01-25
 */
public class a1_25ez {
    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int n = nums.size(), ans = 0;
        for (int i = 0; i < n; i++) {
            if (getPos(i) == k) {
                ans += nums.get(i);
            }
        }
        return ans;
    }

    private int getPos(int num) {
        int pos = 0;
        while (num > 0) {
            if ((num & 1) != 0)
                pos++;
            num >>= 1;
        }
        return pos;
    }
}

```

### 位运算

#### 按位与运算符（&）

参加运算的两个数据，按二进制位进行“与”运算。

运算规则：0&0=0; 0&1=0;  1&0=0;  1&1=1;

与运算”的特殊用途：

（1）清零。如果想将一个单元清零，即使其全部二进制位为0，只要与一个各位都为零的数值相与，结果为零。

（2）取一个数中的指定位

方法：找一个数，对应X要取的位，该数的对应位为1，其余位为零，此数与X进行“与运算”可以得到X中的指定位。

例：设X=10101110，

   取X的低4位，用 X & 0000 1111 = 00001110 即可得到；



#### 按位或运算符（|）

参加运算的两个对象，按二进制位进行“或”运算。

运算规则：0|0=0； 0|1=1； 1|0=1；  1|1=1；

   即 ：参加运算的两个对象只要有一个为1，其值为1。

“或运算”特殊作用：

（1）常用来对一个数据的某些位置1。

方法：找到一个数，对应X要置1的位，该数的对应位为1，其余位为零。此数与X相或可使X中的某些位置1。

例：将X=10100000的低4位置1 ，用X | 0000 1111 = 1010 1111即可得到。



#### 异或运算符（^）

参加运算的两个数据，按二进制位进行“异或”运算。

运算规则：0^0=0； 0^1=1； 1^0=1；  1^1=0；

  即：参加运算的两个对象，如果两个相应位为“异”（值不同），则该位结果为1，否则为0。



“异或运算”的特殊作用：

（1）使特定位翻转找一个数，对应X要翻转的各位，该数的对应位为1，其余位为零，此数与X对应位异或即可。

例：X=10101110，使X低4位翻转，用X ^0000 1111 = 1010 0001即可得到。

 

（2）与0相异或，保留原值 ，X ^ 00000000 = 1010 1110。

取反运算符（~）
参加运算的一个数据，按二进制位进行“取反”运算。

运算规则：~1=0；  ~0=1；

即：对一个二进制数按位取反，即将0变1，1变0。

 

使一个数的最低位为零，可以表示为：a&~1。

1的值为1111111111111110，再按“与”运算，最低位一定为0。因为“~”运算符的优先级比算术运算符、关系运算符、逻辑运算符和其他运算符都高。





# 周赛

## week379

```java
package 周赛.w379;
//1.
public class a10035 {
    /**
     * https://leetcode.cn/problems/maximum-area-of-longest-diagonal-rectangle/description/
     * 10035. 对角线最长的矩形的面积
     *
     * @param dimensions
     * @return
     */
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int area = 0;
        double len = 0;
        for (int i = 0; i < dimensions.length; i++) {
            int[] couple = dimensions[i];
            double clen = gt(couple[0], couple[1]);
            if (clen > len) {
                area = couple[0] * couple[1];
                len = clen;
            } else if (clen == len) {
                area = Math.max(area, couple[0] * couple[1]);
            }
        }
        return area;
    }

    private double gt(int height, int width) {
        return height * height + width * width;
    }
}
```

```java
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

```

```java
package 周赛.w379;

import java.util.*;

/**
 * 10037. 移除后集合的最多元素数
 * https://leetcode.cn/problems/maximum-size-of-a-set-after-removals/description/
 */
public class a10037 {
    public int maximumSetSize(int[] nums1, int[] nums2) {
        //set1代表nums1的不同元素
        Set<Integer> set1 = new HashSet<>();
        //set2代表nums2的不同元素
        Set<Integer> set2 = new HashSet<>();

        //common代表nums1和nums2的不同元素的交集个数
        int common = 0;
        for (int i : nums1) {
            set1.add(i);
        }
        for (int i : nums2) {
            set2.add(i);
        }

        for (Integer i : set1) {
            if (set2.contains(i))
                //交集个数
                common++;
        }
        //m代表需要nums1和nums2均需要移除的元素的个数
        int m = nums1.length / 2;
        //n1和n2分别代表nums1,nums2不同元素个数
        int n1 = set1.size(), n2 = set1.size();
        //如果不移除任何元素，根据容斥原理 nums1和nums2的并集一共有 n1+n2-common个不同元素
        int ans = n1 + n2 - common;
        //我们可以先移除每个数组中的重复元素，再考虑从剩下的数中移除元素。

        //如果n1<=m && n2 <= m,则对结果没有影响
        //但如果n1>m,先从nums1和nums2的交集中移除元素
        if (n1 > m) {
            int mn = Math.min(n1 - m, common);
            common -= mn;
            ans -= n1 - m - mn;
        }
        if (n2 > m) {
            n2 -= Math.min(n2 - m, common);
            ans -= n2 - m;
        }

        return ans;
    }


}

```