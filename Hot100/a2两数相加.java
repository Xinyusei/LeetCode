package Hot100;

import Common.ListNode;

import java.util.ArrayList;
import java.util.List;

public class a2两数相加 {


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ArrayList<Integer> list1 = new ArrayList<>(), list2 = new ArrayList<>();
        ListNode p1 = l1, p2 = l2;
        while (p1 != null) {
            list1.add(p1.val);
            p1 = p1.next;
        }
        while (p2 != null) {
            list2.add(p2.val);
            p2 = p2.next;
        }
        int inc = 0;
        ArrayList<Integer> saveList = new ArrayList<>();
        int i = 0, j = 0;
        for (; i < list1.size() && j < list2.size(); i++, j++) {
            int x = list1.get(i) + list2.get(j) + inc;
            if (x >= 10) {
                x -= 10;
                inc = 1;
            } else
                inc = 0;
            saveList.add(x);
        }
        for (; i < list1.size(); i++) {
            int x = list1.get(i) + inc;
            if (x >= 10) {
                x -= 10;
                inc = 1;
            } else
                inc = 0;
            saveList.add(x);
        }
        for (; j < list2.size(); j++) {
            int x = list2.get(j) + inc;
            if (x >= 10) {
                x -= 10;
                inc = 1;
            } else
                inc = 0;
            saveList.add(x);
        }
        if (inc == 1)
            saveList.add(inc);
        ListNode dummy = new ListNode(), p = dummy;
        for (Integer num : saveList) {
            ListNode node1 = new ListNode(num);
            p.next = node1;
            p = node1;
        }
        return dummy.next;
    }


    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode p1 = l1, p2 = l2;
        int inc = 0;
        ArrayList<Integer> saveList = new ArrayList<>();
        while (p1 != null && p2 != null) {
            int x = p1.val + p2.val + inc;
            if (x >= 10) {
                x -= 10;
                inc = 1;
            } else
                inc = 0;
            System.out.println(x);
            saveList.add(x);
            p1 = p1.next;
            p2 = p2.next;
        }
        if (p2 != null)
            p1 = p2;
        while (p1 != null) {
            int x = p1.val + inc;
            if (x >= 10) {
                x -= 10;
                inc = 1;
            } else
                inc = 0;
            System.out.println(x);
            saveList.add(x);
            p1 = p1.next;
        }
        if (inc == 1)
            saveList.add(inc);
        ListNode dummy = new ListNode(), p = dummy;
        for (Integer num : saveList) {
            ListNode node1 = new ListNode(num);
            p.next = node1;
            p = node1;
        }
        return dummy.next;
    }
}
