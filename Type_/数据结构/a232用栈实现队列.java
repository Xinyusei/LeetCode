package Type_.数据结构;

import java.util.LinkedList;
import java.util.List;

/**
 * 232. 用栈实现队列
 * https://leetcode.cn/problems/implement-queue-using-stacks/description/?envType=daily-question&envId=2024-03-04
 */
public class a232用栈实现队列 {

}
class MyQueue {
    //用两个栈 模拟队列 stackA和stackB只能进行addLast(),removeLast()操作

    //stackA 存储队列内元素,stackB 辅助模拟入队操作
    private final List<Integer> stackA;
    private final List<Integer> stackB;


    public MyQueue() {
        stackA = new LinkedList<>();
        stackB = new LinkedList<>();
    }

    //stackA 3 2 1
    //stackB 1 2
    public void push(int x) {
        while (!stackA.isEmpty()){
            stackB.addLast(stackA.removeLast());
        }
        stackB.addLast(x);
        while (!stackB.isEmpty()){
            stackA.addLast(stackB.removeLast());
        }
    }

    public int pop() {
        return stackA.removeLast();

    }

    public int peek() {
        return stackA.getLast();
    }

    public boolean empty() {
        return stackA.isEmpty();
    }
}
