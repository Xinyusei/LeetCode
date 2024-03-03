package Type_.数据结构;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 225. 用队列实现栈
 * https://leetcode.cn/problems/implement-stack-using-queues/description/?envType=daily-question&envId=2024-03-03
 */
public class a225用队列实现栈 {


}

class MyStack {

    //queueA 存储栈内元素,queueB作为入栈操作的辅助队列
    //queue这里只能addLast(),removeFirst();
    private List<Integer> queueA;

    private List<Integer> queueB;

    public MyStack() {
        queueA = new LinkedList<>();
        queueB = new LinkedList<>();
    }

    public void push(int x) {
        queueB.addLast(x);
        while (!queueA.isEmpty()) {
            queueB.addLast(queueA.removeFirst());
        }
        List<Integer> temp = queueA;
        queueA = queueB;
        queueB = temp;
    }

    public int pop() {
        return queueA.removeFirst();
    }

    public int top() {
        return queueA.getFirst();
    }

    public boolean empty() {
        return queueA.isEmpty();
    }
}
